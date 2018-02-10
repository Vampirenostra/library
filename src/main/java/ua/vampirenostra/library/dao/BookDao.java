package ua.vampirenostra.library.dao;

import ua.vampirenostra.library.entity.Book;
import ua.vampirenostra.library.entity.Search;

import java.util.List;

public interface BookDao extends GeneralDao<Book> {
    List<Book> search(Search search);
}