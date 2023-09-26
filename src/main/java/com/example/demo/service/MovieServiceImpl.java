
package com.example.demo.service;

import com.example.demo.model.FavoritesMovie;
import com.example.demo.model.Movie;
import com.example.demo.model.User;
import com.example.demo.repository.FavoriteMovieRepository;
import com.example.demo.repository.MovieRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private final MovieRepository movieRepository;
    private final UserRepository userRepository;
    private final FavoriteMovieRepository favoriteMovieRepository;

    public MovieServiceImpl(MovieRepository movieRepository, FavoriteMovieRepository favoriteMovieRepository, UserRepository userRepository) {
        this.movieRepository = movieRepository;
        this.favoriteMovieRepository = favoriteMovieRepository;
        this.userRepository = userRepository;
    }


    @Override
    public Movie saveMovieToDb(Movie movie) {

        if (movie.getTitle() == null || movie.getPosterPath() == null) {
            return null;
        }
        return movieRepository.save(movie);
    }

    @Override
    public List<Movie> getAllMovies(Pageable pageable) {
        return movieRepository.findAll();
    }

    @Override
    public void collectMoviesFromExternalSource() {

    }

    @Override
    public void addMovieToFavorites(User user, Movie movie) {
        favoriteMovieRepository.save(new FavoritesMovie(user, movie));
    }


    @Override
    public void removeMovieFromFavorites(User user,Movie movie) {
        User thisUser = userRepository.findByUserId(user);
        List<FavoritesMovie> existFavoritesMovies = favoriteMovieRepository.findAllMoviesByUser(thisUser);

        if (existFavoritesMovies != null) {
            }
        }
    }

    @Override
    public List<Movie> notInFavoritesMoviesInfo(Authentication authentication) {
        return null;
    }

    @Override
    public List<Movie> FavoritesMoviesInfo(Authentication authentication) {
        return null;
    }


}
