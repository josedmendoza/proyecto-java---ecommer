package com.project.ecommerce.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.ecommerce.service.BillProductService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("billproduct")
public class BillProductController {

	private final BillProductService billPService;	

	
	@GetMapping("/getbill/{id}")
	public ResponseEntity<?> getbillProduct (@PathVariable(name = "id") Integer idBill){
		
		Optional<?> findBill = billPService.findId(idBill);
		if(findBill.isPresent()) {
			return ResponseEntity.ok(findBill);
		}else {
			return ResponseEntity.badRequest().body("No se encontro la fuctura solicitada ");
		}
		
	}

}
