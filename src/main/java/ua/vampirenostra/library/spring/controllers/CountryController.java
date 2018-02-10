package ua.vampirenostra.library.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.vampirenostra.library.dao.impl.CountryService;
import ua.vampirenostra.library.domain.Country;

import javax.validation.Valid;
import java.sql.SQLException;


@Controller
public class CountryController {

    @Autowired
    CountryService countryService;

    //Paged
    @RequestMapping(value = "countries", method = RequestMethod.GET)
    public String countriesAll(Model model){
        model.addAttribute("countriesList", countryService.getAll());
        return "country/countries";
    }

    @RequestMapping(value = "/countries/add", method = RequestMethod.GET)
    public String newCountry(Model model, Country country){
        model.addAttribute("country", country);
        model.addAttribute("pageName","Add Country");
        return "country/edit";
    }

    @RequestMapping(value = "/countries/edit/{id}", method = RequestMethod.GET)
    public String editCountry(Model model, @PathVariable(name = "id")Long id){
        model.addAttribute(countryService.get(id));
        model.addAttribute("pageName","Edit Country");
        return "country/edit";
    }

    //Functional - no pages
    @RequestMapping(value = "/countries/add", method = RequestMethod.POST)
    public String saveCountry(Model model, @Valid Country country, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            model.addAttribute("pageName","Edit Country");
            return "country/edit";
        }
        else {
            countryService.save(country);
        }

        return "redirect:/countries";
    }

    @RequestMapping(value = "/countries/delete/{id}", method = RequestMethod.GET)
    public String deleteCountry (@PathVariable(name = "id") Long id){
        countryService.delete(id);
        return "redirect:/countries";
    }
}