package ua.vampirenostra.library.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.vampirenostra.library.dao.BookDao;
import ua.vampirenostra.library.domain.Book;
import ua.vampirenostra.library.domain.Search;
import ua.vampirenostra.library.spring.repository.BookRepository;

import java.util.List;
@Service
public class BookService implements BookDao {

    @Autowired
    BookRepository bookRepository;

   /* @Autowired
    BookRep bookRep;*/

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
        if (search.getSearchType().equals("1")){
            return bookRepository.findByTitleEndsWithIgnoreCase(search.getSearchString(),new Sort(search.getAscDesc(),search.getFieldSorted()));
        }
        else {
            return bookRepository.findByTitleContainsIgnoreCase(search.getSearchString(),new Sort(search.getAscDesc(),search.getFieldSorted()));
        }
    }

/*  @Override
    public List<Book> search(Search search, Sort sort) {
        return bookRep.findWhithCriteria(search);
    }*/

    //Unnecessary for the moment
    @Override
    public List<Book> search(String... searchString) {
        return null;
    }
}
