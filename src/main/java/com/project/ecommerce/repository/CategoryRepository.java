package com.project.ecommerce.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.project.ecommerce.model.Category;
import com.project.ecommerce.repository.iRepository.ICategoryRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class CategoryRepository {

	private final ICategoryRepository iCategoryRepository;
	
	public Category save(Category category){
		return iCategoryRepository.save(category);
	}
	
	public Optional<Category> findById(Integer id) {
		return iCategoryRepository.findById(id);
	}
	
	public boolean existsById(Integer id) {
		return iCategoryRepository.existsById(id);
	}
	
	public Category update(Integer id, Category category) {
		Category find =  iCategoryRepository.findById(id).orElseThrow();
		find.setClassification(category.getClassification());
		return iCategoryRepository.save(find);
	}
	
}
