package com.driver;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")
public class MovieController {

    //Make an instance of MovieService
    @Autowired     //is used so that we don't write the new line
    MovieService movieService;

    //MOVIE
    @PostMapping("/add-movie") //end-point
    public ResponseEntity addMovie (@RequestBody Movie movie){   //ResponseEntity<String>
        movieService.addMovie(movie);
        return new ResponseEntity("New movie added successfully", HttpStatus.CREATED);
          }

     //DIRECTOR

    @PostMapping("/add-director") //end-point
    public ResponseEntity addDirector (@RequestBody Director director){   //ResponseEntity<String>
        movieService.addDirector(director);
        return new ResponseEntity("New director added successfully", HttpStatus.CREATED);
    }


    //PAIR AN EXISTING MOVIE AND DIRECTOR
    @PutMapping("/add-movie-director-pair")
    public ResponseEntity addMovieDirectorPair (@RequestParam("movie") String movie, @RequestParam("director") String director){
        movieService.createMovieDirectorPair(movie, director);
        return new ResponseEntity("New movie-Director pair added successfully",HttpStatus.CREATED);
    }

    @GetMapping("/get-movie-by-name/{name}") //the name here and at path variable should be same otherwise it will not work
    public ResponseEntity<Movie> getMovieByName(@PathVariable String name){ //@PathVariable("name")String movieName
        Movie movie = movieService.findMovie(name);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @GetMapping("/get-director-by-name/{name}") //the name here and at path variable should be same otherwise it will not work
    public ResponseEntity<Director> getDirectorByName(@PathVariable String name){ //@PathVariable("name")String movieName
        Director director = movieService.findDirector(name);
        return new ResponseEntity<>(director, HttpStatus.OK);
    }


    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity <List<String>> getMoviesByDirectorName(@PathVariable String director){
     List<String> movies = movieService.findMoviesFromDirector(director); //they want us to return movie name not whole movie so we will not do List<Movie>movies
     return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping("/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies(){
        List<String> movies = movieService.findAllMovies();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }


    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam String director){
     movieService.deleteDirector(director);
     return new ResponseEntity<>(director +"removed successfully", HttpStatus.OK);
    }

    @DeleteMapping("/delete-all-directors") //catch is you have to delete movies corresponding to it
    public ResponseEntity<String> deleteAllDirectors(){
        movieService.deleteAllDirectors();
        return new ResponseEntity<>("All directors deleted successfully", HttpStatus.OK);
    }

}


