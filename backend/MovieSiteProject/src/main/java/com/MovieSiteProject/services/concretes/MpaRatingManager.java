package com.MovieSiteProject.services.concretes;

import com.MovieSiteProject.dataAccess.MpaRatingRepository;
import com.MovieSiteProject.entities.concretes.MpaRating;
import com.MovieSiteProject.entities.dtos.MpaRatingDTO;
import com.MovieSiteProject.entities.mapper.Mappers;
import com.MovieSiteProject.exceptions.NotFoundException;
import com.MovieSiteProject.services.abstracts.MpaRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MpaRatingManager implements MpaRatingService {
    private final MpaRatingRepository mpaRatingRepository;

    @Autowired
    public MpaRatingManager(MpaRatingRepository mpaRatingRepository){
        this.mpaRatingRepository = mpaRatingRepository;
    }

    @Override
    public MpaRatingDTO getMpaById(int mpaRatingId) {
        MpaRating mpaRating = mpaRatingRepository.getByMpaRatingId(mpaRatingId);
        if(mpaRating == null){
            throw new NotFoundException("Rating id is not correct");
        }

        Mappers mappers = new Mappers();
        return mappers.convertMpaRatingToDTO(mpaRatingRepository.getByMpaRatingId(mpaRatingId));
    }
}
