package com.MovieSiteProject.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "movie")
@Getter
@Setter
public class Movie implements Serializable {

    @Id
    @Column(name = "movie_id")
    private Integer movieId;

    @Column(name = "title")
    private String movieName;

    @Column(name = "release_date")
    private Date movieReleaseDate;

    @Column(name = "runtime")
    private Integer movieRuntime;

    @Column(name = "plot")
    private String movieDescription;

    @Column(name = "poster")
    private String moviePoster;

    @ManyToMany
    @JoinTable(name = "movie_actor",
                joinColumns = {@JoinColumn(referencedColumnName = "movie_id")},
                inverseJoinColumns = {@JoinColumn(referencedColumnName = "actor_id")},
                foreignKey = @ForeignKey(name = "fk_movie_actor_movie_id"),
                inverseForeignKey = @ForeignKey(name = "fk_movie_actor_actor_id")
    )
    @JsonIgnore
    private List<Actor> actors = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "movie_category",
                joinColumns = {@JoinColumn(referencedColumnName = "movie_id")},
                inverseJoinColumns = {@JoinColumn(referencedColumnName = "category_id")},
                foreignKey = @ForeignKey(name = "fk_movie_category_movie_id"),
                inverseForeignKey = @ForeignKey(name = "fk_movie_category_category_id")
    )
    @JsonIgnore
    private List<Category> categories = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "MPA_rating_id",
                foreignKey = @ForeignKey(name = "fk_movie_mpa_rating"))
    private MpaRating mpaRating;

    public Movie() {
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o==null || !(o instanceof Movie))
            return false;
        Movie movie = (Movie)o;

        if(movieId == movie.getMovieId()) return true;
        if(movieId == null) return false;

        return movieId.equals(movie.getMovieId());
    }

    @Override
    public int hashCode() {
        if(movieId != null){
            return movieId.hashCode();
        } else{
            return super.hashCode();
        }
    }
}
