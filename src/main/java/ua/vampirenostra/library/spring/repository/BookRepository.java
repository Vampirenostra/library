package ua.vampirenostra.library.spring.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import ua.vampirenostra.library.domain.Book;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long> {
    List<Book> findByTitleStartsWithIgnoreCase(String search, Sort sort);
    List<Book> findByTitleContainsIgnoreCase(String search, Sort sort);

}
