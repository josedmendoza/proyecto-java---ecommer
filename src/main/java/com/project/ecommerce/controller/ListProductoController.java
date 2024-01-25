package com.project.ecommerce.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.ecommerce.model.ListProduct;
import com.project.ecommerce.service.ListProductService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("listProduct")
public class ListProductoController {
	
	private final ListProductService listProductService;
	
	@GetMapping("getListProduct/{id}")
	public ResponseEntity<?> getListProducto (@PathVariable(name = "id") Integer idListProducto){
		Optional<?> idListP = listProductService.findListById(idListProducto);
		try {
			if(idListP.isPresent()) {
				return ResponseEntity.ok(idListP);
			}else {
				return ResponseEntity.badRequest().body("Error: informa buscada no existe ");
			}

		}catch(Exception e) {
			return ResponseEntity.internalServerError().body("Error: metodo no se ejecuta correctamente " + e.getMessage());
		}
		
	}
	
	@PostMapping("addListProduct")
	public ResponseEntity<?> addListProduct(@RequestBody ListProduct listProduct){
		
		try {
			ListProduct createListProduct = listProductService.createListP(listProduct);
			return ResponseEntity.ok(createListProduct);
		}catch(Exception e){
			return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
		}
		
	}
	
	@GetMapping("getalllistproduct")
	public ResponseEntity<List<ListProduct>> getAllLitsP(){
		return ResponseEntity.ok(listProductService.getList()) ;
	}

}
