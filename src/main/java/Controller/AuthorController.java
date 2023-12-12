package Controller;

import Domain.Author;
import Repo.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @PostMapping("/add")
    public void addAuthor(@RequestBody Author author) {
        authorRepository.save(author);
    }

    @GetMapping("/findByName/{authorName}")
    public Author findAuthorByName(@PathVariable String authorName) {
        return authorRepository.findByNameIgnoreCase(authorName);
    }

    @GetMapping("/getAll")
    public List<Author> getAllAuthors() {
        return (List<Author>) authorRepository.findAll();
    }

    @GetMapping("/printAll")
    public void printAllAuthors() {
        Iterable<Author> authors = authorRepository.findAll();
        authors.forEach(author -> System.out.println(author.toString()));
    }

    @DeleteMapping("/remove/{authorId}")
    public void removeAuthor(@PathVariable Long authorId) {
        authorRepository.deleteById(authorId);
    }

    //update author
}
