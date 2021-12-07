package com.example.mongodemo.controller;

import com.example.mongodemo.model.Movie;
import com.example.mongodemo.repository.MovieRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping
    public Iterable<Movie> get() {
        return movieRepository.findAll();
    }

    @PostMapping
    public Movie create(@RequestBody Movie movie) {
        return movieRepository.save(movie);
    }

    @GetMapping("/{id}")
    public Optional<Movie> read(@PathVariable String id) {
        return movieRepository.findById(id);
    }

    @GetMapping("/by-title")
    public List<Movie> findByTitle(@RequestParam String title) {
        return movieRepository.findMovieByTitleContains(title);
    }
    @DeleteMapping("/{id}")
    public void delete( @PathVariable String id) {
        movieRepository.deleteById(id);
    }

    @GetMapping("/inject")
    public void inject() {
        Movie movie = new Movie();
        movie.setId("12DD");
        movie.setTitle("Matrix");
        movie.setYear(2001);
        Movie movie1 = new Movie();
        movie1.setId("R2D2");
        movie1.setTitle("Star wars");
        movie1.setYear(1988);
        movieRepository.save(movie);
        movieRepository.save(movie1);
    }
}
