package Controller;

import Domain.Librarian;
import Service.LibrarianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/librarians")
public class LibrarianController {

    @Autowired
    private LibrarianService librarianService;

    @PostMapping("/add")
    public Librarian createLibrarian(@RequestBody Librarian librarian) {
        return librarianService.createLibrarian(librarian);
    }

    @GetMapping("/getAll")
    public List<Librarian> getAllLibrarians() {
        return librarianService.getAllLibrarians();
    }

    @GetMapping("/{id}")
    public Librarian getLibrarianById(@PathVariable int id) {
        return librarianService.getLibrarianById(id);
    }

    @PutMapping("/update/{id}")
    public Librarian updateLibrarian(@PathVariable int id, @RequestBody Librarian updatedLibrarian) {
        return librarianService.updateLibrarian(id, updatedLibrarian);
    }

    @DeleteMapping("/{id}")
    public void deleteLibrarian(@PathVariable int id) {
        librarianService.deleteLibrarian(id);
    }
}