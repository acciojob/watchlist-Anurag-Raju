package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    void addMovie(Movie movie){
        movieRepository.addMovieToDatabase(movie);
    }
    void addDirector(Director director){
        movieRepository.addDirectorToDatabase(director);
    }
    void addMovieDirectorPair(String movieName,String directorName){
        movieRepository.addMovieDirectorPair(movieName,directorName);
    }
    Movie getMovieByName(String name){
       return movieRepository.getMovieByName(name);
    }
    Director getDirectorByName(String name){
       return movieRepository.getDirectorByName(name);
    }


    public List<Movie> getMoviesByDirectorName(String name){
        return movieRepository.getMoviesByDirectorName(name);
    }
    public List<Movie> findAllMovies(){
        return movieRepository.findAllMovies();
    }
    public void deleteDirectorByName(String name){
        movieRepository.deleteDirectorByName(name);
    }
    public void deleteAllDirectors(){
        movieRepository.deleteAllDirectors();
    }
}
