package ua.vampirenostra.library.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.vampirenostra.library.entity.Author;
import ua.vampirenostra.library.repository.AuthorRepository;
import ua.vampirenostra.library.service.AuthorService;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    @Override
    public Author save(Author obj) {
        return authorRepository.save(obj);
    }

    @Override
    public Author get(long id) {
        return authorRepository.getOne(id);
    }

    @Override
    public void delete(Long id) {
        authorRepository.delete(id);
    }

    @Override
    public List<Author> getAll() {
        return authorRepository.findAll();
    }

    @Override
    public List<Author> search(String... searchString) {
        return authorRepository.findByFirstNameContainingIgnoreCase(searchString[0]);
    }
}
