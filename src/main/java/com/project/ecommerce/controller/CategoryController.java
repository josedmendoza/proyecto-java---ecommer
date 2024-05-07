package com.project.ecommerce.controller;

import java.util.Optional;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.ecommerce.service.CategoryService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/category")
public class CategoryController {
	
	private final CategoryService categoryService;
	
	//Metodo para buscar las categorias
	@Operation(description = "Metodo  utilizado para obtener las categorias  que se encuentra en la DB", summary = "Obtenger categorias")
	@GetMapping(value = "/getcategory/{id}", produces = (MediaType.APPLICATION_JSON_VALUE))
	public ResponseEntity<?> getCategory(
			@Parameter(description = "Id de la cateogoria", required = true, example = "1,2,3,...")
			@PathVariable(name = "id") Integer id) {
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
