package ua.vampirenostra.library.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.vampirenostra.library.dao.PublisherDao;
import ua.vampirenostra.library.entity.Publisher;
import ua.vampirenostra.library.repository.PublisherRepository;

import java.util.List;

@Service
public class PublisherService implements PublisherDao {
    @Autowired
    PublisherRepository publisherRepository;

    @Override
    public Publisher save(Publisher obj) {
        return publisherRepository.save(obj);
    }

    @Override
    public Publisher get(long id) {
        return publisherRepository.getOne(id);
    }

    @Override
    public void delete(Long id) {
        publisherRepository.delete(id);
    }

    @Override
    public List<Publisher> getAll() {
        return publisherRepository.findAll();
    }

    @Override
    public List<Publisher> search(String... searchString) {
        return publisherRepository.findByPublisherNameContainingIgnoreCase(searchString[0]);
    }
}
