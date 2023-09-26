package com.example.demo.service;

import com.example.demo.model.Movie;
import com.example.demo.model.User;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;

import java.util.List;
import java.util.UUID;

public interface MovieService {
    Movie saveMovieToDb(Movie movie);

    List<Movie> getAllMovies(Pageable pageable);

    void collectMoviesFromExternalSource();

    void addMovieToFavorites(User user, Movie movieId);

    void removeMovieFromFavorites(User user,Movie movie);

    List<Movie> notInFavoritesMoviesInfo(Authentication authentication);

    List<Movie> FavoritesMoviesInfo(Authentication authentication);

}
