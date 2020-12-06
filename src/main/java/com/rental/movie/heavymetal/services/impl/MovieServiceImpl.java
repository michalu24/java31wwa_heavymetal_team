package com.rental.movie.heavymetal.services.impl;

import com.rental.movie.heavymetal.model.Movie;
import com.rental.movie.heavymetal.repositories.MovieRepository;
import com.rental.movie.heavymetal.services.MovieService;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    MovieRepository repository;

    public MovieServiceImpl (MovieRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Movie movie) {
        repository.save(movie);
    }

    @Override
    public Movie getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Movie> getAll() {
        List<Movie> movies = new LinkedList<>();
        repository.findAll().iterator().forEachRemaining(movies::add);
        return movies;
    }

    @Override
    public void update(Movie movie) {
        repository.save(movie);

    }

    @Override
    public void delete(Long id) {

        repository.deleteById(id);

    }

    @Override
    public Optional<Movie> findByTitle(String Title) {
        return repository.findByTitle(Title);
    }

}
