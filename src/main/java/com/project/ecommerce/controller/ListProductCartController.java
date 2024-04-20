package com.project.ecommerce.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.ecommerce.ECommerceApplication;
import com.project.ecommerce.model.ListProductCart;
import com.project.ecommerce.model.dto.ListProductcartDto;
import com.project.ecommerce.service.ListProductCartService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/productcart")
public class ListProductCartController {

	private final ListProductCartService productCartService;

	private static Logger log = LoggerFactory.getLogger(ECommerceApplication.class);

	// Metodo para agregar un producto al carrito
	@PostMapping("/addproduct")
	public ResponseEntity<?> createLisTP(@RequestBody ListProductCart listProductCart) {

		try {
			ListProductCart productIn = productCartService.createListP(listProductCart);
			if (productIn == null) {
				return ResponseEntity.badRequest()
						.body("Error al intentar agregar el producto al carrito no hay stock suficiente");
			} else {
				
				return ResponseEntity.ok(productIn);
			}
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Error: " + e.getMessage());
		}
	}

	// Metodo para obtener todos los productos del carrito de un cliente
	@GetMapping("/getproductCart/{idCart}")
	public ResponseEntity<?> getProductByIdCart(@PathVariable(name = "idCart") Integer idCart) {
		try {

			List<ListProductcartDto> getList = productCartService.getListP(idCart);
			log.info("getList {}", getList);
			if(getList.isEmpty()) {
				return ResponseEntity.badRequest().body("No se encontre productos para este cliente");
			}else {
				return ResponseEntity.ok(getList);
			}

		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getLocalizedMessage());
		}

	}
	
	//Metodo para actualizar la cantida de un producto dentro del carrito de compras
	@PutMapping("/updateQuantity")
	public ResponseEntity<?> updateQuantity (@RequestBody ListProductCart productcart){
		
		try {
			
			ListProductCart updateQ = productCartService.upPQuantiy(productcart);
			return ResponseEntity.ok(updateQ);
		}catch(Exception e) {
			return ResponseEntity.badRequest().body("Error: no se puede actualizar cantidad");
			
		}
		
	}

}
