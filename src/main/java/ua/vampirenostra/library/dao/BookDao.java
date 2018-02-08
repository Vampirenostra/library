package ua.vampirenostra.library.dao;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import ua.vampirenostra.library.domain.Book;
import ua.vampirenostra.library.domain.Search;

import java.util.List;

public interface BookDao extends GeneralDao<Book> {
    List<Book> search(Search search);
}
