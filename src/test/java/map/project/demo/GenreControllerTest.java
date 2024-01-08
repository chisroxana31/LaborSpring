package map.project.demo;

import Domain.*;
import Repo.GenreRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.mockito.Mockito;

import static org.hamcrest.Matchers.is;

import static org.hamcrest.Matchers.hasSize;


import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@AutoConfigureMockMvc
public class GenreControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private GenreRepository genreRepository;

    @Test
    public void testGetAllGenres() throws Exception {
        List<Genre> genres = Arrays.asList(new Genre(1L, "Fantasy"), new Genre(2L, "Sci-Fi"));
        Mockito.when(genreRepository.findAll()).thenReturn(genres);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/genres/getAll"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name", is("Fantasy")))
                .andExpect(jsonPath("$[1].name", is("Sci-Fi")));
    }
    @Test
    public void testGetGenresByName() throws Exception {
        List<Genre> genres = Arrays.asList(new Genre(1L, "Fantasy"));
        Mockito.when(genreRepository.findByName("Fantasy")).thenReturn(genres);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/genres/findByName/Fantasy"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is("Fantasy")));
    }
    @Test
    public void testUpdateGenre() throws Exception {
        Genre existingGenre = new Genre(1L, "Fantasy");
        Genre updatedGenre = new Genre(1L,"Sci-Fi");
        Mockito.when(genreRepository.findById(1L)).thenReturn(Optional.of(existingGenre));

        mockMvc.perform(MockMvcRequestBuilders.put("/api/genres/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(updatedGenre)))
                .andExpect(status().isOk());
        Mockito.verify(genreRepository).save(existingGenre);
    }
    @Test
    public void testGetGenreById() throws Exception {
        Genre genre = new Genre(1L, "Fantasy");
        Mockito.when(genreRepository.findById(1L)).thenReturn(Optional.of(genre));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/genres/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("Fantasy")));
    }
    @Test
    public void testDeleteGenre() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/genres/delete/{genreId}", 1L))
                .andExpect(status().isOk());
        Mockito.verify(genreRepository).deleteById(1L);
    }
    @Test
    public void testAddGenre() throws Exception {
        Genre newGenre = new Genre(1L,"Mystery");
        mockMvc.perform(MockMvcRequestBuilders.post("/api/genres/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(newGenre)))
                .andExpect(status().isOk());
        Mockito.verify(genreRepository).save(any(Genre.class));
    }
    // Additional tests for other endpoints
}
