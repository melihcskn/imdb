package com.MovieSiteProject.entities.dtos;

import com.MovieSiteProject.entities.concretes.Movie;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Calendar;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
public class ActorDTO {
    private Integer actorId;
    private String actorName;
    private String actorSurname;
    private Calendar actorBirthDay;
    private String actorBio;
    private String actorPoster;
    private List<Movie> movies;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ActorDTO actorDTO)) return false;
        return Objects.equals(actorId, actorDTO.actorId) && Objects.equals(actorName, actorDTO.actorName) && Objects.equals(actorSurname, actorDTO.actorSurname) && Objects.equals(actorBirthDay, actorDTO.actorBirthDay) && Objects.equals(actorBio, actorDTO.actorBio) && Objects.equals(actorPoster, actorDTO.actorPoster) && Objects.equals(movies, actorDTO.movies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actorId, actorName, actorSurname, actorBirthDay, actorBio, actorPoster, movies);
    }
}
