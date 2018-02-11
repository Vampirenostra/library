package ua.vampirenostra.library.service;

import ua.vampirenostra.library.entity.Book;
import ua.vampirenostra.library.entity.Search;

import java.util.List;

public interface BookService extends GeneralService<Book> {
    List<Book> search(Search search);
}