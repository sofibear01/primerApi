package com.example.primerApi.controller;

import com.example.primerApi.model.Movie;
import com.example.primerApi.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/{id}")
    public Optional<Movie> findMovieById(@PathVariable("id") Long id){
        return Optional.ofNullable(movieService.findMovieById(id));
    }
    @GetMapping("/all")
    public List<Movie> findAllMovies() {
        return movieService.findAllMovies();
    }

    @PostMapping("/addMovie")
    public Movie addMovie(@RequestBody Movie movie){
        return movieService.addMovie(movie);
    }

    @PutMapping("/update/{id}")
    public Optional<Movie> updateMovie(@PathVariable Long id, @RequestBody Movie movie){
        return movieService.updateMovie(movie, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteMovie(@PathVariable("id") Long id) {
        movieService.deleteMovie(id);
    }
}
