package Repo;

import Domain.Events;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventsRepository extends JpaRepository<Events, Long> {

    List<Events> findByName(String name);
}
