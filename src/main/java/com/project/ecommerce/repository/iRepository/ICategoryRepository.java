package com.project.ecommerce.repository.iRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.ecommerce.model.Category;

public interface ICategoryRepository extends JpaRepository<Category, Integer>{

}
