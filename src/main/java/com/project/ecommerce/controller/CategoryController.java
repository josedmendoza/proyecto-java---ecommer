package com.project.ecommerce.controller;

import java.util.Optional;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.ecommerce.service.CategoryService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/category")
public class CategoryController {
	
	private final CategoryService categoryService;
	
	
	@GetMapping(value = "/getcategory/{id}", produces = (MediaType.APPLICATION_JSON_VALUE))
	public ResponseEntity<?> getCategory(@PathVariable(name = "id") Integer id) {
		try {
			if(categoryService.validation(id) == true) {
				Optional<?> find = categoryService.findCategory(id);
				return ResponseEntity.ok(find);
			}else {
				return ResponseEntity.badRequest().body("Error: no se encontro la categoria solicitada");
			}
		}catch(Exception e){
			String msj = e.getMessage();
			return ResponseEntity.badRequest().body("Error: no se pudo ejecutar el metodo correctamente" + msj);
		}
	}

}
