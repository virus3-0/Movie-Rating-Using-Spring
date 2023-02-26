package com.example.MovieRating.repository;

import com.example.MovieRating.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

//    @Query("SELECT id, comment, rate, movieid from Comment")
//    List<Comment> findAllComments();
}
