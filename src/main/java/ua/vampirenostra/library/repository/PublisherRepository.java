package ua.vampirenostra.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.vampirenostra.library.entity.Publisher;

import java.util.List;

public interface PublisherRepository extends JpaRepository<Publisher,Long> {
    List<Publisher> findByPublisherNameContainingIgnoreCase(String...searchString);
}
