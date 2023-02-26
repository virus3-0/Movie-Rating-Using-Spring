package com.example.MovieRating.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comment {
    @JsonProperty("UserID")
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    //put id as same as movieid so user also can see the comment
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
//    @NotBlank
    @JsonProperty("Name")
    private String username;
    @JsonProperty("About Movie")
    private String comment;
    @JsonProperty("Movie-Rate")
    private int rate;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER) //    many= movie, one=user.
    @JoinColumn(name = "movieid")
    private Movie movieObject;

}

