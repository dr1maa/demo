package com.example.demo.repository;

import com.example.demo.model.FavoritesMovie;
import com.example.demo.model.Movie;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface FavoriteMovieRepository extends JpaRepository<FavoritesMovie, UUID> {
    List<FavoritesMovie> findAllMoviesByUser(User user);

}
