package com.example.MovieRating.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Movie {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String movie_name;
    private String caption;
    private String release_date;


}
