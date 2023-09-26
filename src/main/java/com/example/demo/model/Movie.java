package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import org.springframework.data.annotation.Id;

import java.util.UUID;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    @Column(nullable = false, unique = true)
    private String title;
    @Column(nullable = false, unique = true)
    private String posterPath;
    boolean isFavorites = false;

    public boolean isFavorites() {
        return isFavorites;
    }

    public void setFavorites(boolean favorites) {
        isFavorites = favorites;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPosterPath(String poster_path) {
        this.posterPath = poster_path;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getPosterPath() {
        return posterPath;
    }
}
