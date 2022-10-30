package com.driver;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Component
public class MovieRepository {
     HashMap<String,Movie> movies=new HashMap<>();
     HashMap<String,Director> directors=new HashMap<>();

     HashMap<String,List<Movie>> moviesAndDirectors=new HashMap<>();
     void addMovieDirectorPair(String movieName,String directorName){
         if(moviesAndDirectors.containsKey(directorName)){
             List<Movie> existingMovies=moviesAndDirectors.get(directorName);
             existingMovies.add(movies.get(movieName));
             moviesAndDirectors.put(directorName,existingMovies);
         }else{
             List<Movie> newMovies=new ArrayList<>();
             newMovies.add(movies.get(movieName));
             moviesAndDirectors.put(directorName,newMovies);
         }
     }
    List<Movie> getMoviesByDirectorName(String name){
        return moviesAndDirectors.get(name);
    }
    void deleteDirectorByName(String name){
         for(Movie movie:moviesAndDirectors.get(name)){
             movies.remove(movie);
         }
             directors.remove(name);
             moviesAndDirectors.remove(name);
    }
    void deleteAllDirectors(){
        for(String m:moviesAndDirectors.keySet()){
            for(Movie movie:moviesAndDirectors.get(m)){
                movies.remove(movie);
            }
        }
        directors.clear();
        moviesAndDirectors.clear();
    }
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
