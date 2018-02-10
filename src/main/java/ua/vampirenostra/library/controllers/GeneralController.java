package ua.vampirenostra.library.controllers;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.Valid;

public interface GeneralController<T> {
    public String getAll(Model model);

    public String addNew(Model model, T t);

    public String edit(Model model, @PathVariable(name = "id") Long id);

    public String save(Model model, @Valid T t, BindingResult bindingResult);

    public String delete(@PathVariable(name = "id") Long id);
}
