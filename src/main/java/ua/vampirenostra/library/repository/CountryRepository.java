package ua.vampirenostra.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.vampirenostra.library.entity.Country;
import ua.vampirenostra.library.entity.Publisher;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country,Long> {
    List<Country> findByFirstNameContainingIgnoreCase(String...searchString);
}
