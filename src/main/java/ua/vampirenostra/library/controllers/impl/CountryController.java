package ua.vampirenostra.library.controllers.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.vampirenostra.library.controllers.GeneralController;
import ua.vampirenostra.library.dao.impl.CountryService;
import ua.vampirenostra.library.entity.Country;

import javax.validation.Valid;


@Controller
public class CountryController implements GeneralController<Country> {

    @Autowired
    CountryService countryService;

    //Paged
    @RequestMapping(value = "countries", method = RequestMethod.GET)
    public String getAll(Model model) {
        model.addAttribute("countriesList", countryService.getAll());
        return "country/countries";
    }

    @RequestMapping(value = "/countries/add", method = RequestMethod.GET)
    public String addNew(Model model, Country country) {
        model.addAttribute("country", country);
        model.addAttribute("pageName", "Add Country");
        return "country/edit";
    }

    @RequestMapping(value = "/countries/edit/{id}", method = RequestMethod.GET)
    public String edit(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute(countryService.get(id));
        model.addAttribute("pageName", "Edit Country");
        return "country/edit";
    }

    //Functional - no pages
    @RequestMapping(value = "/countries/add", method = RequestMethod.POST)
    public String save(Model model, @Valid Country country, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("pageName", "Edit Country");
            return "country/edit";
        } else {
            countryService.save(country);
        }

        return "redirect:/countries";
    }

    @RequestMapping(value = "/countries/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable(name = "id") Long id) {
        countryService.delete(id);
        return "redirect:/countries";
    }
}