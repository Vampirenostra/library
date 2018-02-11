package ua.vampirenostra.library.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.vampirenostra.library.service.PublisherService;
import ua.vampirenostra.library.entity.Publisher;
import ua.vampirenostra.library.repository.PublisherRepository;

import java.util.List;

@Service
public class PublisherServiceImpl implements PublisherService {
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
