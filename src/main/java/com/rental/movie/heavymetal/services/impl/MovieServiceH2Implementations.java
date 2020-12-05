package com.rental.movie.heavymetal.services.impl;

import com.rental.movie.heavymetal.model.Movie;
import com.rental.movie.heavymetal.repositories.MovieRepository;
import com.rental.movie.heavymetal.services.MovieService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
@Service
public class MovieServiceH2Implementations implements MovieService {

    MovieRepository repository;

    public MovieServiceH2Implementations(MovieRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Movie movie) {
        repository.save(movie);
    }

    @Override
    public Movie getById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Movie> getAll() {
        return new LinkedList<Movie>((Collection<? extends Movie>) repository.findAll());
    }

    @Override
    public void update(Movie movie) {
        repository.save(movie);

    }

    @Override
    public void delete(Integer id) {

        repository.deleteById(id);

    }
}