package Repo;

import Domain.Book;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public interface BookRepository extends CrudRepository<Book, Long> {
//
////    Book findByTitleIgnoreCase(String title);
//
//}
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    //
}
