package ua.vampirenostra.library.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import ua.vampirenostra.library.entity.Book;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitleEndsWithIgnoreCase(String search, Sort sort);

    List<Book> findByTitleContainsIgnoreCase(String search, Sort sort);
    Book findByTitle(String title);

}
