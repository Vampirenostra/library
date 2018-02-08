package ua.vampirenostra.library.dao;

import java.util.List;

public interface GeneralDao <T> {
    T save (T obj);
    T get (long id);
    void delete (Long id);

    List<T> getAll();
    List<T> search (String... searchString);
}
