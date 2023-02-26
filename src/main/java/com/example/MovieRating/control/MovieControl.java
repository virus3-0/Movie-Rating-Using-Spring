package com.example.MovieRating.control;

import com.example.MovieRating.model.Comment;
import com.example.MovieRating.model.Movie;
import com.example.MovieRating.repository.MovieRepository;
import com.example.MovieRating.service.CommentService;
import com.example.MovieRating.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MovieControl {
    @Autowired
    MovieService movieServiceObject;

    @Autowired
    private MovieRepository movieRepositoryObject;
    @GetMapping("/")
    public String home(){
        return "HELLO EVERYONE WELCOME TO MOVIE_RATING PROJECT";
    }
    @PostMapping("/add")
    public String add(@RequestBody Movie movieObject){
        movieRepositoryObject.save(movieObject);
        return "Movie added";
    }
    @GetMapping("/FindAll")
    public List<Movie> FindAll(){
        return movieServiceObject.findAllMovie();
    }

    @GetMapping("/displayByID/{id}")
    public Optional<Movie> displayId(@PathVariable int id){
        return movieServiceObject.displaybyid(id);
    }
    @DeleteMapping("/deleteAll")
    public String deleteAll(){
        return movieServiceObject.deleteall();
    }
    @DeleteMapping("/deleteByID/{id}")
    public String deleteId(@PathVariable int id){
        return movieServiceObject.deletebyid(id);
    }
    @PutMapping("/update/{id}")
    public String Update(@PathVariable int id, @RequestBody Movie MovieObject){
        return movieServiceObject.update(id, MovieObject);
    }
}
