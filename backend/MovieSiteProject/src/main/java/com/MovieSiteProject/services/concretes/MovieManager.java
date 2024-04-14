package com.MovieSiteProject.services.concretes;

import com.MovieSiteProject.dataAccess.MovieRepository;
import com.MovieSiteProject.entities.concretes.Movie;
import com.MovieSiteProject.entities.dtos.MovieDTO;
import com.MovieSiteProject.entities.mapper.Mappers;
import com.MovieSiteProject.services.abstracts.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieManager implements MovieService {
    private final MovieRepository movieRepository;
    Mappers mappers = new Mappers();

    @Autowired
    public MovieManager(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    @Override
    public MovieDTO getByMovieId(int movieId) {
        Movie movie = movieRepository.getByMovieId(movieId);
        return mappers.convertMovieToDTO(movie);
    }
    @Override
    public List<MovieDTO> getAll() {
        List<Movie> movies = movieRepository.findAll();
        return mappers.convertMovieToDTO(movies);
    }

    @Override
    public List<MovieDTO> getByMovieNameStartingWith(String movieName) {
        List<Movie> movies = movieRepository.getByMovieNameStartingWith(movieName);
        return mappers.convertMovieToDTO(movies);
    }

    @Override
    public List<MovieDTO> getMovieByMovieNameContains(String movieName) {
        List<Movie> movies = movieRepository.getMovieByMovieNameContains(movieName);
        return mappers.convertMovieToDTO(movies);
    }
}
