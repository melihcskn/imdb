package com.MovieSiteProject.services.abstracts;

import com.MovieSiteProject.entities.dtos.CategoryDTO;

public interface CategoryService {

    CategoryDTO getById(int categoryId);
}
