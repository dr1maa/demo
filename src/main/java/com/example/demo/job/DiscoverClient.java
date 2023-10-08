package com.example.demo.job;


import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class DiscoverClient {
    private static final String ACCEPT = "accept";
    private static final String APPLICATION_JSON = "application/json";
    private static final String AUTHORIZATION = "authorization";
    private static final String API_KEY = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJmZTgwN2Y3Zjg1OThkNjZhMDZlY2Y3NTRiZGY5ZWUxZCIsInN1YiI6IjY0ZjIzNjBiZTBjYTdmMDBhZTM5YmRiYiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.UFkHevBZYjleei8IIez043l0kHUK8s2Eenxu-_4tt7c";
    private static final String BASE_URL = "https://api.themoviedb.org/3/discover/movie?include_adult=false&include_video=false&language=en-US&page=1&sort_by=popularity.desc";
    public final OkHttpClient client;

    public DiscoverClient() {
        this.client = new OkHttpClient();
    }

    public Response fetchMoviesFromAllPages() {
        for (int page = 1; page <= 5; page++) {
            try {
                String url = BASE_URL + "?api_key=" + API_KEY + "&page=" + page;

                Request request = new Request.Builder()
                        .url(url)
                        .get()
                        .addHeader(ACCEPT, APPLICATION_JSON)
                        .addHeader(AUTHORIZATION, API_KEY)
                        .build();

                return client.newCall(request).execute();
            } catch (
                    IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public Response fetchMoviesFromPage(int page) {
        try {
            String url = BASE_URL + "?api_key=" + API_KEY + "&page=" + page;

            Request request = new Request.Builder()
                    .url(url)
                    .get()
                    .addHeader(ACCEPT, APPLICATION_JSON)
                    .addHeader(AUTHORIZATION, API_KEY)
                    .build();

            return client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}