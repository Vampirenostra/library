package ua.vampirenostra.library.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.vampirenostra.library.dao.CountryDao;
import ua.vampirenostra.library.entity.Country;
import ua.vampirenostra.library.repository.CountryRepository;

import java.util.List;
@Service
public class CountryService implements CountryDao {
    @Autowired
    CountryRepository countryRepository;

    @Override
    public Country save(Country obj) {
        return countryRepository.save(obj);
    }

    @Override
    public Country get(long id) {
        return countryRepository.getOne(id);
    }

    @Override
    public void delete(Long id) {
        countryRepository.delete(id);
    }

    @Override
    public List<Country> getAll() {
        return countryRepository.findAll();
    }

    @Override
    public List<Country> search(String... searchString) {
        return countryRepository.findByCountryNameContainingIgnoreCase(searchString[0]);
    }
}
