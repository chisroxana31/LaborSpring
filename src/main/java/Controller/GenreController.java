package Controller;

import Domain.Genre;
import Service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/genres")
public class GenreController {

    @Autowired
    private GenreService genreService;

    @GetMapping("/getAll")
    public List<Genre> getAllGenres() {
        return genreService.getAllGenres();
    }

    @GetMapping("/{genreId}")
    public Genre getGenreById(@PathVariable Long genreId) {
        return genreService.getGenreById(genreId);
    }

    @PostMapping("/add")
    public void addGenre(@RequestBody Genre genre) {
        genreService.addGenre(genre);
    }

    @PutMapping("/update/{genreId}")
    public void updateGenre(@PathVariable Long genreId, @RequestBody Genre updatedGenre) {
        genreService.updateGenre(genreId, updatedGenre);
    }

    @GetMapping("/findByName/{name}")
    public List<Genre> getGenresByName(@PathVariable String name) {
        return genreService.getGenresByName(name);
    }

    // Add other CRUD operations and business logic...

    @DeleteMapping("/delete/{genreId}")
    public void deleteGenre(@PathVariable Long genreId) {
        genreService.deleteGenre(genreId);
    }
}