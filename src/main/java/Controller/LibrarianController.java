package Controller;

import Domain.Librarian;
import Repo.LibrarianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/librarians")
public class LibrarianController {

    @Autowired
    private LibrarianRepository librarianRepository;

    @PostMapping("/add")
    public Librarian createLibrarian(@RequestBody Librarian librarian) {

        // You might want to validate or perform additional logic before saving
        return librarianRepository.save(librarian);
    }

    @GetMapping("/getAll")
    public List<Librarian> getAllLibrarians() {
        return librarianRepository.findAll();
    }

    @GetMapping("/{id}")
    public Librarian getLibrarianById(@PathVariable int id) {
        return librarianRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Librarian not found with id: " + id));
    }

    @PutMapping("/{id}")
    public Librarian updateLibrarian(@PathVariable int id, @RequestBody Librarian updatedLibrarian) {
        Librarian existingLibrarian = librarianRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Librarian not found with id: " + id));

        existingLibrarian.setName(updatedLibrarian.getName());
//        existingLibrarian.setEmployee(updatedLibrarian.getEmployee());

        return librarianRepository.save(existingLibrarian);
    }

    @DeleteMapping("/{id}")
    public void deleteLibrarian(@PathVariable int id) {
        librarianRepository.deleteById(id);
    }
}
