package com.MovieSiteProject.api.controllers;

import com.MovieSiteProject.entities.dtos.MpaRatingDTO;
import com.MovieSiteProject.services.abstracts.MpaRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/mpaRatings")
public class MpaRatingController {
    private final MpaRatingService mpaRatingService;

    @Autowired
    public MpaRatingController(MpaRatingService mpaRatingService){
        this.mpaRatingService = mpaRatingService;
    }

    @GetMapping(path = "/{id}")
    public MpaRatingDTO getDtoByMpaRatingId(@PathVariable("id") int mpaRatingId){
        return mpaRatingService.getMpaById(mpaRatingId);
    }
}
