package Controller;

import Domain.Genre;
import Repo.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/genres")
public class GenreController {

    @Autowired
    private GenreRepository genreRepository;

    @GetMapping("/getAll")
    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    @GetMapping("/{genreId}")
    public Genre getGenreById(@PathVariable Long genreId) {
        return genreRepository.findById(genreId).orElse(null);
    }

    @PostMapping("/add")
    public void addGenre(@RequestBody Genre genre) {
        genreRepository.save(genre);
    }

    @PutMapping("/{genreId}")
    public void updateGenre(@PathVariable Long genreId, @RequestBody Genre updatedGenre) {
        Genre existingGenre = genreRepository.findById(genreId).orElse(null);
        if (existingGenre != null) {
            existingGenre.setName(updatedGenre.getName());
            genreRepository.save(existingGenre);
        }
    }

    @GetMapping("/findByName/{name}")
    public List<Genre> getGenresByName(@PathVariable String name) {
        return genreRepository.findByName(name);
    }

    // Add other CRUD operations and business logic...

    @DeleteMapping("/delete/{genreId}")
    public void deleteGenre(@PathVariable Long genreId) {
        genreRepository.deleteById(genreId);
    }
}
