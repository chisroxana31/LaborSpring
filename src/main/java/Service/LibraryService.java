package Service;


import Domain.Library;
import Repo.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService{

    @Autowired
    private LibraryRepository libraryRepo;

    public Library createLibrary(Library library) {
        return libraryRepo.save(library);
    }


    public List<Library> getAllLibraries() {
        return libraryRepo.findAll();
    }


    public Library getLibraryById(int id) {
        return libraryRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Library not found with id: " + id));
    }


    public Library updateLibrary(int id, Library updatedLibrary) {
        Library existingLibrary = libraryRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Library not found with id: " + id));
        existingLibrary.setEmployees(updatedLibrary.getEmployees());

        return libraryRepo.save(existingLibrary);
    }

    public void deleteLibrary(int id) {
        libraryRepo.deleteById(id);
    }
}
