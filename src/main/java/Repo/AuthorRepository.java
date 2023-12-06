package Repo;

import Domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {

    Author findByNameIgnoreCase(String authorName);

}
