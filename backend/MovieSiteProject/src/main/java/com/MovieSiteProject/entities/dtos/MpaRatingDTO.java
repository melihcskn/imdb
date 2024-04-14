package com.MovieSiteProject.entities.dtos;

import com.MovieSiteProject.entities.concretes.Movie;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
public class MpaRatingDTO {
    private Integer mpaRatingId;
    private String mpaDescription;
    private String mpaAbbreviation;
    private String mpaRatingName;
    private List<Movie> mpaMovies;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MpaRatingDTO that)) return false;
        return Objects.equals(mpaRatingId, that.mpaRatingId) && Objects.equals(mpaDescription, that.mpaDescription) && Objects.equals(mpaAbbreviation, that.mpaAbbreviation) && Objects.equals(mpaRatingName, that.mpaRatingName) && Objects.equals(mpaMovies, that.mpaMovies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mpaRatingId, mpaDescription, mpaAbbreviation, mpaRatingName, mpaMovies);
    }
}
