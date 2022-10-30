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
    public ResponseEntity addMovie(@RequestBody Movie movie){
        movieService.addMovie(movie);
        return new ResponseEntity<>("Success",HttpStatus.ACCEPTED);
    }

    @PostMapping("/add-director")
    public ResponseEntity addDirector(@RequestBody Director director){
        movieService.addDirector(director);
        return new ResponseEntity<>("Success",HttpStatus.CREATED);
}

    @PutMapping("/add-movie-director-pair")
    public ResponseEntity addMovieDirectorPair(@RequestParam String movieName,@RequestParam String directorName){
       movieService.addMovieDirectorPair(movieName,directorName);
       return new ResponseEntity<>("Success",HttpStatus.CREATED);
    }

      @GetMapping("/get-movie-by-name/{name}")
      public ResponseEntity getMovieByName(@PathVariable String name){
        return new ResponseEntity<>(movieService.getMovieByName(name),HttpStatus.ACCEPTED);
      }

      @GetMapping("/get-director-by-name/{name}")
      public ResponseEntity getDirectorByName(@PathVariable String name){
        return new ResponseEntity<>(movieService.getDirectorByName(name),HttpStatus.ACCEPTED);
      }

      @GetMapping("/get-movies-by-director-name/{director}")
       public ResponseEntity getMoviesByDirectorName(@PathVariable String name){
       return new ResponseEntity<>(movieService.getMoviesByDirectorName(name),HttpStatus.ACCEPTED);
      }

      @GetMapping("/get-all-movies")
      public ResponseEntity findAllMovies(){
        return new ResponseEntity<>(movieService.findAllMovies(),HttpStatus.ACCEPTED);
      }

      @DeleteMapping("/delete-director-by-name")
      public ResponseEntity deleteDirectorByName(@RequestParam String name){
        movieService.deleteDirectorByName(name);
        return new ResponseEntity("Success",HttpStatus.ACCEPTED);
      }

      @DeleteMapping("/delete-all-directors")
         public ResponseEntity deleteAllDirectors(){
          movieService.deleteAllDirectors();
         return new ResponseEntity("Success",HttpStatus.ACCEPTED);
      }
}
