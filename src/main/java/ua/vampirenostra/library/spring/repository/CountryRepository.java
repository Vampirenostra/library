package ua.vampirenostra.library.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.vampirenostra.library.domain.Country;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, Long> {
    List<Country> findByCountryNameContainingIgnoreCase(String countryName);
}
