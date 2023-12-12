package Controller;

import Domain.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import Patterns.LibraryObserver;
import Patterns.LibraryPolicy;
import Repo.LibraryRepository;

import java.util.List;


@RestController
@RequestMapping("/api/libraries")
public class LibraryController {

    @Autowired
    private LibraryRepository libraryRepo;

    @PostMapping
    public Library createLibrary(@RequestBody Library library){
        return libraryRepo.save(library);
    }

    @GetMapping
    public List<Library> getAllLibraries(){
        return libraryRepo.findAll();
    }

    @GetMapping("/{id}")
    public Library getLibraryById(@PathVariable int id) {
        return libraryRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Library not found with id: " + id));
    }

    @PutMapping("/{id}")
    public Library updateLibrary(@PathVariable int id, @RequestBody Library updatedLibrary) {
        Library existingLibrary = libraryRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Library not found with id: " + id));

        // Update the properties of the existing library
//        existingLibrary.setEmployees(updatedLibrary.getEmployees());
//        existingLibrary.setBooks(updatedLibrary.getBooks());
//        existingLibrary.setCustomers(updatedLibrary.getCustomers());
//        existingLibrary.setLibraryPolicy(updatedLibrary.getLibraryPolicy());

        return libraryRepo.save(existingLibrary);
    }

    @DeleteMapping("/{id}")
    public void deleteLibrary(@PathVariable int id) {
        libraryRepo.deleteById(id);
    }
}
