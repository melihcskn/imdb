package com.MovieSiteProject.entities.dtos;

import com.MovieSiteProject.entities.concretes.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
public class MovieDTO {
    private Integer movieId;
    private String movieName;
    private Date movieReleaseDate;
    private String movieMpaRating;
    private String moviePoster;
    private List<String> movieActors;
    private List<Category> movieCategories;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MovieDTO movieDTO)) return false;
        return Objects.equals(movieId, movieDTO.movieId) && Objects.equals(movieName, movieDTO.movieName) && Objects.equals(movieReleaseDate, movieDTO.movieReleaseDate) && Objects.equals(movieMpaRating, movieDTO.movieMpaRating) && Objects.equals(moviePoster, movieDTO.moviePoster) && Objects.equals(movieActors, movieDTO.movieActors) && Objects.equals(movieCategories, movieDTO.movieCategories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieId, movieName, movieReleaseDate, movieMpaRating, moviePoster, movieActors, movieCategories);
    }
}
