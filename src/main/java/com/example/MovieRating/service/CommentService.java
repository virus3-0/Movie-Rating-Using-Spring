package com.example.MovieRating.service;

import com.example.MovieRating.model.Comment;
import com.example.MovieRating.model.Movie;
import com.example.MovieRating.repository.CommentRepository;
import com.example.MovieRating.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    @Autowired
    CommentRepository commentRepositoryObject;

    @Autowired
    MovieRepository movieRepositoryObject;

    public String addcomment(Comment commentObject) {
        List<Movie> newMovieObject=movieRepositoryObject.findAll();
        try {
            for (int i=1; i<=newMovieObject.size(); i++){
                String movie=newMovieObject.get(i).getMovie_name();
                if (movie.equalsIgnoreCase(commentObject.getMovieObject().getMovie_name())){
                    if (commentObject.getRate() >= 1 && commentObject.getRate() <= 10) {
                        commentRepositoryObject.save(commentObject);
                        return "Comment Added";
                    }
                    else
                        return "Comment not added, rate can only between 1 to 10.";
                }
                }
            }
        catch (Exception exceptionObject) {
            return "Movie Not in the Database.";
        }
            return "Movie Not in the Database.";
    }
    public Optional<Comment> displaybyid(int id) {

        return commentRepositoryObject.findById(id);
    }
    public String deletecbyid(int id) {
        commentRepositoryObject.deleteById(id);
        return "comment is deleted";
    }

    public List<Comment> findAllComment() {
        return commentRepositoryObject.findAll();
    }
}
