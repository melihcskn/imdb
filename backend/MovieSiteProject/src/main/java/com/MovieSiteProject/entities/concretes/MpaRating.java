package com.MovieSiteProject.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Table(name = "movie_mpa_film_ratings")
@Getter
@Setter
public class MpaRating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MPA_rating_id")
    private Integer mpaRatingId;

    @Column(name = "MPA_rating_description")
    private String mpaDescription;

    @Column(name = "MPA_rating_abbreviation")
    private String mpaAbbreviation;

    @Column(name = "MPA_rating_name")
    private String mpaRatingName;

    @OneToMany(mappedBy = "mpaRating")
    @JsonIgnore
    private List<Movie> movies;

    public MpaRating(){}
}
