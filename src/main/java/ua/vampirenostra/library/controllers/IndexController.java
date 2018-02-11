package ua.vampirenostra.library.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.jdbc.datasource.init.ScriptStatementFailedException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.sql.DataSource;
import java.sql.Connection;


@Controller
public class IndexController {
    @Qualifier("dataSource")
    @Autowired
    DataSource dataSource;

    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createTables(Model model) {
        String result = "Tables created!";
        try {
            ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
            populator.addScript(new ClassPathResource("static/create_tables.sql"));
            dbAccess(populator);
            model.addAttribute("result", "Tables created!");
        } catch (ScriptStatementFailedException e) {
            result = "Sorry, You already have tables created";
        }
        model.addAttribute("result", result);
        return "index";
    }

    @RequestMapping(value = "/clear", method = RequestMethod.GET)
    public String clear(Model model) {

        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.addScript(new ClassPathResource("static/drop_tables.sql"));
        populator.addScript(new ClassPathResource("static/create_tables.sql"));
        dbAccess(populator);

        String result = "Data Cleared!";
        model.addAttribute("result", result);

        return "index";
    }

    @RequestMapping(value = "/populate", method = RequestMethod.GET)
    public String populate(Model model) {

        String result = "Database Populated!";
        try {
            ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
            populator.addScript(new ClassPathResource("static/data.sql"));
            dbAccess(populator);
        } catch (ScriptStatementFailedException e) {
            result = "Sorry, your database is already populated, maybe you need to clear it before re-population?";
        }
        model.addAttribute("result", result);

        return "index";
    }

    private void dbAccess(ResourceDatabasePopulator populator) {
        Connection connection = DataSourceUtils.getConnection(dataSource);
        populator.populate(connection);
        DataSourceUtils.releaseConnection(connection, dataSource);

    }

}
