package com.MovieSiteProject.services.concretes;

import com.MovieSiteProject.dataAccess.CategoryRepository;
import com.MovieSiteProject.entities.concretes.Category;
import com.MovieSiteProject.entities.dtos.CategoryDTO;
import com.MovieSiteProject.entities.mapper.Mappers;
import com.MovieSiteProject.services.abstracts.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryManager implements CategoryService {
    private final CategoryRepository categoryRepository;

    Mappers mappers;

    @Autowired
    public CategoryManager(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
        mappers = new Mappers();
    }
    @Override
    public CategoryDTO getById(int categoryId) {
        Category category = categoryRepository.getCategoryByCategoryId(categoryId);
        return mappers.convertCategoryToDTO(category);
    }

}
