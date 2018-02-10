package ua.vampirenostra.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.vampirenostra.library.entity.Country;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, Long> {
    List<Country> findByCountryNameContainingIgnoreCase(String... searchString);
}
