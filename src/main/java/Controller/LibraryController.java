package Controller;

import Domain.Library;
import Service.LibraryService;
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
    private LibraryService libraryService;

    @PostMapping("/add")
    public Library createLibrary(@RequestBody Library library){
        return libraryService.createLibrary(library);
    }

    @GetMapping("/getAll")
    public List<Library> getAllLibraries(){
        return libraryService.getAllLibraries();
    }

    @GetMapping("/{id}")
    public Library getLibraryById(@PathVariable int id) {
        return libraryService.getLibraryById(id);
    }

    @PutMapping("/update/{id}")
    public Library updateLibrary(@PathVariable int id, @RequestBody Library updatedLibrary) {
        libraryService.updateLibrary(id,updatedLibrary);
        return updatedLibrary;
    }

    @DeleteMapping("/{id}")
    public void deleteLibrary(@PathVariable int id) {
        libraryService.deleteLibrary(id);
    }
}
