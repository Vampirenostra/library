package ua.vampirenostra.library.repository;

import org.springframework.boot.actuate.autoconfigure.ShellProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import ua.vampirenostra.library.entity.Author;
import ua.vampirenostra.library.entity.Publisher;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author,Long> {
    List<Author> findByFirstNameContainingIgnoreCase(String...searchString);
}
