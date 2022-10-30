package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("movies")
public class MovieController {
    @Autowired
    MovieService movieService;

    @PostMapping("/add-movie")
    public ResponseEntity addMovie(@RequestBody Movie movie){
        movieService.addMovie(movie);
        return new ResponseEntity<>("Movie Successfully added",HttpStatus.CREATED);
    }

    @PostMapping("/add-director")
    public ResponseEntity addDirector(@RequestBody Director director){
        movieService.addDirector(director);
        return new ResponseEntity<>("Director Successfully added",HttpStatus.CREATED);
}

    @PutMapping("/add-movie-director-pair")
    public ResponseEntity addMovieDirectorPair(@RequestParam String movieName,@RequestParam String directorName){
       movieService.addMovieDirectorPair(movieName,directorName);
       return new ResponseEntity<>("Successfully paired",HttpStatus.CREATED);
    }

      @GetMapping("/get-movie-by-name/{name}")
      public ResponseEntity<Movie> getMovieByName(@PathVariable String name){
        return new ResponseEntity<>(movieService.getMovieByName(name),HttpStatus.ACCEPTED);
      }

      @GetMapping("/get-director-by-name/{name}")
      public ResponseEntity<Director> getDirectorByName(@PathVariable String name){
        return new ResponseEntity<>(movieService.getDirectorByName(name),HttpStatus.ACCEPTED);
      }

      @GetMapping("/get-movies-by-director-name/{director}")
       public ResponseEntity<List<Movie>> getMoviesByDirectorName(@PathVariable String name){
       return new ResponseEntity<>(movieService.getMoviesByDirectorName(name),HttpStatus.ACCEPTED);
      }

      @GetMapping("/get-all-movies")
      public ResponseEntity<List<Movie>> findAllMovies(){
        return new ResponseEntity<>(movieService.findAllMovies(),HttpStatus.ACCEPTED);
      }

      @DeleteMapping("/delete-director-by-name")
      public ResponseEntity deleteDirectorByName(@RequestParam String name){
        movieService.deleteDirectorByName(name);
        return new ResponseEntity("Successfully deleted the movies by director name",HttpStatus.ACCEPTED);
      }

      @DeleteMapping("/delete-all-directors")
         public ResponseEntity deleteAllDirectors(){
          movieService.deleteAllDirectors();
         return new ResponseEntity("Successfully all the directors and there movies",HttpStatus.ACCEPTED);
      }
}
