package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;
    void addMovieDirectorPair(String movieName,String directorName){
        movieRepository.addMovieDirectorPair(movieName,directorName);
    }
    List<Movie> getMoviesByDirectorName(String name){
        return movieRepository.getMoviesByDirectorName(name);
    }
    void deleteDirectorByName(String name){
        movieRepository.deleteDirectorByName(name);
    }
    void deleteAllDirectors(){
        movieRepository.deleteAllDirectors();
    }
    void addMovie(Movie movie){
        movieRepository.addMovieToDatabase(movie);
    }
    void addDirector(Director director){
        movieRepository.addDirectorToDatabase(director);
    }
    Movie getMovieByName(String name){
       return movieRepository.getMovieByName(name);
    }
    Director getDirectorByName(String name){
       return movieRepository.getDirectorByName(name);
    }
    List<Movie> findAllMovies(){
       return movieRepository.findAllMovies();
    }
}
