package ua.vampirenostra.library.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import ua.vampirenostra.library.domain.Country;

public interface CountryDao extends GeneralDao<Country>{
}
