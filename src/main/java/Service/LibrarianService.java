package Service;

import Domain.Librarian;
import Repo.LibrarianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibrarianService {

    @Autowired
    private LibrarianRepository librarianRepository;


    public Librarian createLibrarian(Librarian librarian) {
        // You might want to validate or perform additional logic before saving
        return librarianRepository.save(librarian);
    }


    public List<Librarian> getAllLibrarians() {
        return librarianRepository.findAll();
    }


    public Librarian getLibrarianById(int id) {
        return librarianRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Librarian not found with id: " + id));
    }


    public Librarian updateLibrarian(int id, Librarian updatedLibrarian) {
        Librarian existingLibrarian = librarianRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Librarian not found with id: " + id));

        existingLibrarian.setName(updatedLibrarian.getName());
        // Set other properties as needed

        return librarianRepository.save(existingLibrarian);
    }


    public void deleteLibrarian(int id) {
        librarianRepository.deleteById(id);
    }
}