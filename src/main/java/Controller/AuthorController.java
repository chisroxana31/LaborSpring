package Controller;

import Domain.Author;
import Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping("/add")
    public void addAuthor(@RequestBody Author author) {
        authorService.addAuthor(author);
    }

    @GetMapping("/findByName/{authorName}")
    public Author findAuthorByName(@PathVariable String authorName) {
        return authorService.findAuthorByName(authorName);
    }

    @GetMapping("/getAll")
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping("/printAll")
    public void printAllAuthors() {
        List<Author> authors = authorService.getAllAuthors();
        authors.forEach(author -> System.out.println(author.toString()));
    }

    @DeleteMapping("/remove/{authorId}")
    public void removeAuthor(@PathVariable Long authorId) {
        authorService.removeAuthor(authorId);
    }

}
