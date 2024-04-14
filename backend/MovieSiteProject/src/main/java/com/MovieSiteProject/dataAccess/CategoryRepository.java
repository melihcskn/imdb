package com.MovieSiteProject.dataAccess;

import com.MovieSiteProject.entities.concretes.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
    Category getCategoryByCategoryId(int categoryId);
}
