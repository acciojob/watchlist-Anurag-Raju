package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("movies")
public class MovieController {
    @Autowired
    MovieService movieService;

    @PostMapping("/add-movie")
    ResponseEntity addMovie(@RequestBody Movie movie){
        movieService.addMovie(movie);
        return new ResponseEntity<>("Success",HttpStatus.ACCEPTED);
    }

    @PostMapping("/add-director")
    ResponseEntity addDirector(@RequestBody Director director){
        movieService.addDirector(director);
        return new ResponseEntity<>("Success",HttpStatus.CREATED);
}

    @PutMapping("/add-movie-director-pair")
    ResponseEntity addMovieDirectorPair(@RequestParam("movieName") String movieName,@RequestParam("directorName") String directorName){
       movieService.addMovieDirectorPair(movieName,directorName);
       return new ResponseEntity<>("Success",HttpStatus.CREATED);
    }

      @GetMapping("/get-movie-by-name/{name}")
      ResponseEntity getMovieByName(@PathVariable String name){
        return new ResponseEntity<>(movieService.getMovieByName(name),HttpStatus.ACCEPTED);
      }

      @GetMapping("/get-director-by-name/{name}")
      ResponseEntity getDirectorByName(@PathVariable String name){
        return new ResponseEntity<>(movieService.getDirectorByName(name),HttpStatus.ACCEPTED);
      }

      @GetMapping("/get-movies-by-director-name/{director}")
       ResponseEntity getMoviesByDirectorName(@PathVariable String name){
       return new ResponseEntity<>(movieService.getMoviesByDirectorName(name),HttpStatus.ACCEPTED);
      }

      @GetMapping("/get-all-movies")
      ResponseEntity findAllMovies(){
        return new ResponseEntity<>(movieService.findAllMovies(),HttpStatus.ACCEPTED);
      }

      @DeleteMapping("/delete-director-by-name")
      ResponseEntity deleteDirectorByName(@RequestParam String name){
        movieService.deleteDirectorByName(name);
        return new ResponseEntity("Success",HttpStatus.ACCEPTED);
      }

      @DeleteMapping("/delete-all-directors")
         ResponseEntity deleteAllDirectors(){
          movieService.deleteAllDirectors();
         return new ResponseEntity("Success",HttpStatus.ACCEPTED);
      }
}
