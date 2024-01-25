package com.project.ecommerce.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.ecommerce.model.Category;
import com.project.ecommerce.repository.CategoryRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CategoryService {

	private final CategoryRepository categoryRepository;
	
	public Category createC(Category category) {
		return categoryRepository.save(category);
	}
	
	public Optional<Category> findCategory(Integer id) {
		return categoryRepository.findById(id);
	}
	
	public boolean validation(Integer id) {
		return categoryRepository.existsById(id);
	}
	
	public Category updateData(Integer id, Category category) {
		return categoryRepository.update(id, category);
	}
	
}
