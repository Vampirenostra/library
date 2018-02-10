package ua.vampirenostra.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.vampirenostra.library.entity.Author;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<Author> findByFirstNameContainingIgnoreCase(String... searchString);
}
