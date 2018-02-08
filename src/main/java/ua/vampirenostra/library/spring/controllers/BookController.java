package ua.vampirenostra.library.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ua.vampirenostra.library.dao.impl.AuthorService;
import ua.vampirenostra.library.dao.impl.BookService;
import ua.vampirenostra.library.dao.impl.PublisherService;
import ua.vampirenostra.library.domain.Book;
import ua.vampirenostra.library.domain.Format;
import ua.vampirenostra.library.domain.Search;

import javax.validation.Valid;

@Controller
public class BookController {
    @Autowired
    BookService bookService;
    @Autowired
    PublisherService publisherService;
    @Autowired
    AuthorService authorService;

    //Paged
    @RequestMapping(value = "books", method = RequestMethod.GET)
    public String getBooksList(Model model){
        model.addAttribute("searcher", new Search());
            model.addAttribute(bookService.getAll());
            model.addAttribute("searchDirection", Sort.Direction.values());
        return "book/books";
    }
    @RequestMapping(value = "books", method = RequestMethod.POST)
    public String getSearchedBooksList(Model model,Search searcher){
        model.addAttribute("searcher",searcher);
        model.addAttribute("searchDirection", Sort.Direction.values());
        //Custom search
        model.addAttribute(bookService.search(searcher));

        return "book/books";
    }

    @RequestMapping(value = "/books/add", method = RequestMethod.GET)
    public String newBook(Model model, Book book){
        model.addAttribute("book", book);
        model.addAttribute("authorsAsList", authorService.getAll());
        model.addAttribute("publishersList", publisherService.getAll());
        model.addAttribute("formats", Format.values());
        model.addAttribute("pageName","Add Book");

        return "book/edit";
    }

    @RequestMapping(value = "/books/edit/{id}", method = RequestMethod.GET)
    public String editBook(Model model, @PathVariable(name = "id")Long id){
        model.addAttribute("book",bookService.get(id));
        model.addAttribute("authorsAsList", authorService.getAll());
        model.addAttribute("publishersList", publisherService.getAll());
        model.addAttribute("formats", Format.values());
        model.addAttribute("pageName","Edit Book");

        return "book/edit";
    }

    //Functional - no pages
    @RequestMapping(value = "/books/add", method = RequestMethod.POST)
    public String saveBook(Model model, @Valid Book book, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            model.addAttribute("pageName","Edit Book");
            model.addAttribute("authorsAsList", authorService.getAll());
            model.addAttribute("publishersList", publisherService.getAll());
            model.addAttribute("formats", Format.values());
            return "book/edit";
        }
        else
        bookService.save(book);

        return "redirect:/books";
    }

    @RequestMapping(value = "/books/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable(name = "id")Long id){
        bookService.delete(id);

        return "redirect:/books";
    }
}
