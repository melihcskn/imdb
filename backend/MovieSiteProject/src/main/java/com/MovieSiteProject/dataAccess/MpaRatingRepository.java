package com.MovieSiteProject.dataAccess;

import com.MovieSiteProject.entities.concretes.MpaRating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MpaRatingRepository extends JpaRepository<MpaRating,Integer> {
    MpaRating getByMpaRatingId(int mpaRatingId);
}
