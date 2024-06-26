package com.project.ecommerce.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.ecommerce.model.Subscription;
import com.project.ecommerce.service.SubscriptionService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/Subscription")
public class SubscriptionController {

	private final SubscriptionService subsService;

	@Operation(description = "Metodo post utilizado para obtener una suscripcion", summary = "Obtener suscripcione")
	@GetMapping("/getSubs/{id}")
	public ResponseEntity<?> getSubscription(
			@Parameter(description = "Id de la suscripcion", required = true, example = "1 , 2 o 3")
			@PathVariable(name = "id") int idSubscription) {
		try {
			boolean findId = subsService.validation(idSubscription);
			if(findId == true) {
				Optional<Subscription> getSubs = subsService.getSu(idSubscription);
			return ResponseEntity.ok(getSubs);
			}else {
				return ResponseEntity.badRequest().body("Error: no se encotro la suscripcion solicitada");
			}
		}catch(Exception e) {
			return ResponseEntity.badRequest().body("Error al ejecutar el metodo Get" + e.getMessage());
		}
	}
	


}
