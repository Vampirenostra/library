package ua.vampirenostra.library.controllers.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.vampirenostra.library.controllers.GeneralController;
import ua.vampirenostra.library.dao.impl.PublisherService;
import ua.vampirenostra.library.entity.Publisher;

import javax.validation.Valid;

@Controller
public class PublisherController implements GeneralController<Publisher> {

    @Autowired
    PublisherService publisherService;

    //Paged
    @RequestMapping(value = "publishers", method = RequestMethod.GET)
    public String getAll(Model model) {
        model.addAttribute("publishersList", publisherService.getAll());
        return "publisher/publishers";
    }

    @RequestMapping(value = "/publishers/add", method = RequestMethod.GET)
    public String addNew(Model model, Publisher publisher) {
        model.addAttribute("publisher", publisher);
        model.addAttribute("pageName", "Add Publisher");
        return "publisher/edit";
    }

    @RequestMapping(value = "/publishers/edit/{id}", method = RequestMethod.GET)
    public String edit(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute(publisherService.get(id));
        model.addAttribute("pageName", "Edit Publisher");
        return "publisher/edit";
    }

    //Functional - no pages
    @RequestMapping(value = "/publishers/add", method = RequestMethod.POST)
    public String save(Model model, @Valid Publisher publisher, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("pageName", "Edit Publisher");
            return "publisher/edit";
        } else {
            publisherService.save(publisher);
            return "redirect:/publishers";
        }
    }

    @RequestMapping(value = "/publishers/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable(name = "id") Long id) {
        publisherService.delete(id);
        return "redirect:/publishers";
    }
}
