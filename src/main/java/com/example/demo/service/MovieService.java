package com.example.demo.service;

import com.example.demo.model.FavoritesMovie;
import com.example.demo.model.Movie;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;

import java.util.List;
import java.util.UUID;

public interface MovieService {
    Movie saveMovieToDb(Movie movie);

    List<Movie> getAllMovies(Pageable pageable);

    void addMovieToFavorites(Authentication authentication, Movie movie);

    void removeMovieFromFavorites(Authentication authentication,Movie movie);

    List<Movie> notInFavoritesMoviesInfo(Authentication authentication);

    List<FavoritesMovie> FavoritesMoviesInfo(Authentication authentication);

    Movie findMovieById(Movie moveId);
}
