package ua.vampirenostra.library.controllers.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.vampirenostra.library.controllers.GeneralController;
import ua.vampirenostra.library.service.impl.AuthorServiceImpl;
import ua.vampirenostra.library.service.impl.CountryServiceImpl;
import ua.vampirenostra.library.entity.Author;
import ua.vampirenostra.library.entity.Sex;

import javax.validation.Valid;

@Controller
public class AuthorController implements GeneralController<Author> {
    AuthorServiceImpl authorServiceImpl;
    CountryServiceImpl countryServiceImpl;

    @Autowired
    public AuthorController(AuthorServiceImpl authorServiceImpl, CountryServiceImpl countryServiceImpl) {
        this.authorServiceImpl = authorServiceImpl;
        this.countryServiceImpl = countryServiceImpl;
    }

    //Paged
    @RequestMapping(value = "authors", method = RequestMethod.GET)
    public String getAll(Model model) {
        model.addAttribute("authorsList", authorServiceImpl.getAll());
        return "author/authors";
    }

    @RequestMapping(value = "/authors/add", method = RequestMethod.GET)
    public String addNew(Model model, Author author) {
        model.addAttribute("sexes", Sex.values());
        model.addAttribute("countriesList", countryServiceImpl.getAll());
        model.addAttribute("pageName", "Add Author");

        return "author/edit";
    }

    @RequestMapping(value = "/authors/edit/{id}", method = RequestMethod.GET)
    public String edit(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute(authorServiceImpl.get(id));
        model.addAttribute("sexes", Sex.values());
        model.addAttribute("countriesList", countryServiceImpl.getAll());
        model.addAttribute("pageName", "Edit Author");

        return "author/edit";
    }

    //Functional - no pages
    @RequestMapping(value = "/authors/add", method = RequestMethod.POST)
    public String save(Model model, @Valid Author author, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("sexes", Sex.values());
            model.addAttribute("countriesList", countryServiceImpl.getAll());
            model.addAttribute("pageName", "Edit Author");

            return "author/edit";
        } else {
            authorServiceImpl.save(author);
        }

        return "redirect:/authors";
    }

    @RequestMapping(value = "/authors/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable(name = "id") Long id) {
        authorServiceImpl.delete(id);
        return "redirect:/authors";
    }
}
