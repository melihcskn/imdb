package com.MovieSiteProject.entities.mapper;

import com.MovieSiteProject.entities.concretes.Actor;
import com.MovieSiteProject.entities.concretes.Category;
import com.MovieSiteProject.entities.concretes.Movie;
import com.MovieSiteProject.entities.concretes.MpaRating;
import com.MovieSiteProject.entities.dtos.ActorDTO;
import com.MovieSiteProject.entities.dtos.CategoryDTO;
import com.MovieSiteProject.entities.dtos.MovieDTO;
import com.MovieSiteProject.entities.dtos.MpaRatingDTO;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Mappers {

    public MpaRatingDTO convertMpaRatingToDTO(MpaRating mpaRatingData){
        MpaRatingDTO dto = new MpaRatingDTO();

        dto.setMpaRatingId(mpaRatingData.getMpaRatingId());
        dto.setMpaRatingName(mpaRatingData.getMpaRatingName());
        dto.setMpaAbbreviation(mpaRatingData.getMpaAbbreviation());
        dto.setMpaDescription(mpaRatingData.getMpaDescription());
        dto.setMpaMovies(mpaRatingData.getMovies());

        return dto;
    }
    public ActorDTO convertActorToDTO(Actor actor){
        ActorDTO dto = new ActorDTO();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(actor.getActorBirthDay());

        dto.setActorId(actor.getActorId());
        dto.setActorName(actor.getActorName());
        dto.setActorSurname(actor.getActorSurname());
        dto.setActorBirthDay(calendar);
        dto.setActorBio(actor.getActorBio());
        dto.setMovies(actor.getMovies());
        dto.setActorPoster(actor.getActorPoster());

        return dto;
    }
    public List<ActorDTO> convertActorToDTO(List<Actor> actors){
        List<ActorDTO> dto = new ArrayList<>();

        actors.forEach(actor ->
                dto.add(convertActorToDTO(actor)));
        return dto;
    }

    public MovieDTO convertMovieToDTO(Movie movie){
        MovieDTO dto = new MovieDTO();
        List<String> actors = new ArrayList<>();

        dto.setMovieId(movie.getMovieId());
        dto.setMovieName(movie.getMovieName());
        dto.setMovieReleaseDate(movie.getMovieReleaseDate());
        dto.setMovieMpaRating(movie.getMpaRating().getMpaAbbreviation());
        dto.setMovieCategories(movie.getCategories());
        dto.setMoviePoster(movie.getMoviePoster());

        movie.getActors().forEach(actor ->
        {
            String temp = actor.getActorName() + " " + actor.getActorSurname();
            actors.add(temp);
        });

        dto.setMovieActors(actors);

        return dto;
    }

    public List<MovieDTO> convertMovieToDTO(List<Movie> movies){
        List<MovieDTO> dto = new ArrayList<>();

        movies.forEach(movie->dto.add(convertMovieToDTO(movie)));

        return dto;
    }

    public CategoryDTO convertCategoryToDTO(Category category){
        CategoryDTO dto = new CategoryDTO();

        dto.setCategoryId(category.getCategoryId());
        dto.setCategoryName(category.getCategoryName());
        dto.setMovies(category.getMovies());

        return dto;
    }
}
