package ua.vampirenostra.library.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ua.vampirenostra.library.service.BookService;
import ua.vampirenostra.library.entity.Book;
import ua.vampirenostra.library.entity.Search;
import ua.vampirenostra.library.repository.BookRepository;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Override
    public Book save(Book obj) {
        return bookRepository.save(obj);
    }

    @Override
    public Book get(long id) {
        return bookRepository.getOne(id);
    }

    @Override
    public void delete(Long id) {
        bookRepository.delete(id);
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> search(Search search) {
        if (search.getSearchType().equals("1")) {
            return bookRepository.findByTitleEndsWithIgnoreCase(search.getSearchString(), new Sort(search.getAscDesc(),
                    search.getFieldSorted()));
        } else {
            return bookRepository.findByTitleContainsIgnoreCase(search.getSearchString(), new Sort(search.getAscDesc(),
                    search.getFieldSorted()));
        }
    }

    //Unnecessary for the moment
    @Override
    public List<Book> search(String... searchString) {
        return null;
    }
}
