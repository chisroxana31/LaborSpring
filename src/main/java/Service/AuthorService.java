package Service;

import Domain.Author;
import Repo.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService{

    @Autowired
    private AuthorRepository authorRepository;


    public void addAuthor(Author author) {
        authorRepository.save(author);
    }


    public Author findAuthorByName(String authorName) {
        return authorRepository.findByNameIgnoreCase(authorName);
    }


    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }


    public void removeAuthor(Long authorId) {
        authorRepository.deleteById(authorId);
    }

    // Add update method if needed
}
