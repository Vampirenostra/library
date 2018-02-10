package ua.vampirenostra.library.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.vampirenostra.library.dao.AuthorDao;
import ua.vampirenostra.library.entity.Author;
import ua.vampirenostra.library.repository.AuthorRepository;

import java.util.List;

@Service
@Transactional
public class AuthorService implements AuthorDao{

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
