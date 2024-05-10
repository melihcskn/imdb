package com.MovieSiteProject.services.abstracts;

import com.MovieSiteProject.entities.concretes.MpaRating;
import com.MovieSiteProject.entities.dtos.MpaRatingDTO;

import java.util.List;

public interface MpaRatingService {
    MpaRatingDTO getMpaById(int mpaRatingId);

    List<MpaRatingDTO> getAll();

    MpaRatingDTO createMpaRating(MpaRatingDTO mpaRatingDTO);
}
