package com.example.MovieRating.service;


import com.example.MovieRating.model.Movie;
import com.example.MovieRating.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepositoryObject;
    public void save(Movie movieObject) {
        movieRepositoryObject.save(movieObject);
    }

    public List<Movie> findAllMovie() {
        return movieRepositoryObject.findAll();
    }

    public Optional<Movie> displaybyid(int id) {
        return movieRepositoryObject.findById(id);
    }

    public String deleteall() {
        movieRepositoryObject.deleteAll();
        return "all record is deleted";
    }
    public String deletebyid(int bid) {
        movieRepositoryObject.deleteById(bid);
        return "record is deleted";
    }

    public String update(int id, Movie movieobj) {
        if(movieRepositoryObject.findById(id)!=null){
            movieRepositoryObject.deleteById(id);
            movieRepositoryObject.save(movieobj);
            return "updated";
        }
        return "id not exist in database";
    }
}
