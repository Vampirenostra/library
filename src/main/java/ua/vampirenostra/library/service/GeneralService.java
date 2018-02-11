package ua.vampirenostra.library.service;

import java.util.List;

public interface GeneralService<T> {
    T save (T obj);
    T get (long id);
    void delete (Long id);

    List<T> getAll();
    List<T> search (String... searchString);
}
