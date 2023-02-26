package com.example.MovieRating.control;

import com.example.MovieRating.model.Comment;
import com.example.MovieRating.model.Movie;
import com.example.MovieRating.repository.CommentRepository;
import com.example.MovieRating.repository.MovieRepository;
import com.example.MovieRating.service.CommentService;
import com.example.MovieRating.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CommentController {
    @Autowired
    CommentService commentServiceObject;
//    @Autowired
//    private MovieRepository movieRepositoryObject;
//    @Autowired
//    MovieService movieServiceObject;


    @PostMapping("/addComment")
    public String addComment(@RequestBody Comment commentObject){
        return commentServiceObject.addcomment(commentObject);
    }
    @RequestMapping(value="/FindAllComment", method=RequestMethod.GET)
    @GetMapping("/FindAllComment")
    public List<Comment> FindAll(){
        return commentServiceObject.findAllComment();
    }


//    @Autowired
//    private CommentRepository commentRepository;
//    @GetMapping("/FindAllComment")
//    public List<Comment> getAllComments() {
//        return commentRepository.findAllComments();
//    }




    @GetMapping("/displayCommentByID/{id}")
    public Optional<Comment> displayCId(@PathVariable int id){
        return commentServiceObject.displaybyid(id);
    }
    @DeleteMapping("/deleteCommentByID/{id}")
    public String deleteCById(@PathVariable int id){
        return commentServiceObject.deletecbyid(id);
    }
}
