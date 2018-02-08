package ua.vampirenostra.library.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.vampirenostra.library.domain.Publisher;

import java.util.List;

public interface PublisherRepository extends JpaRepository<Publisher,Long> {
    List<Publisher> findByPublisherNameContainingIgnoreCase(String publisherName);
}
