package com.driver;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Component
public class MovieRepository {
     HashMap<String,Movie> movies=new HashMap<>();
     HashMap<String,Director> directors=new HashMap<>();
     HashMap<Movie,Director> moviesAndDirectors=new HashMap<>();
    void addMovieToDatabase(Movie movie){
        movies.put(movie.getName(),movie);
    }

    void addDirectorToDatabase(Director director){
        directors.put(director.getName(),director);
    }

    Movie getMovieByName(String name){
        return movies.get(name);
    }
    Director getDirectorByName(String name){
        return directors.get(name);
    }
    List<Movie> findAllMovies(){
        List<Movie> allMovies=new ArrayList<>();
        for(Movie movie:movies.values()){
            allMovies.add(movie);
        }
        return allMovies;
    }
}
