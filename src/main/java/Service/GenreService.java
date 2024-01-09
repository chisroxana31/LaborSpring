package Service;

import Domain.Genre;
import Repo.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService{

    @Autowired
    private GenreRepository genreRepository;


    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }


    public Genre getGenreById(Long genreId) {
        return genreRepository.findById(genreId).orElse(null);
    }


    public void addGenre(Genre genre) {
        genreRepository.save(genre);
    }


    public void updateGenre(Long genreId, Genre updatedGenre) {
        Genre existingGenre = genreRepository.findById(genreId).orElse(null);
        if (existingGenre != null) {
            existingGenre.setName(updatedGenre.getName());
            genreRepository.save(existingGenre);
        }
    }


    public List<Genre> getGenresByName(String name) {
        return genreRepository.findByName(name);
    }


    public void deleteGenre(Long genreId) {
        genreRepository.deleteById(genreId);
    }
}
