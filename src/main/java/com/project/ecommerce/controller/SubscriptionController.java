package com.project.ecommerce.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.ecommerce.model.Subscription;
import com.project.ecommerce.service.SubscriptionService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/Subscription")
public class SubscriptionController {

	private final SubscriptionService subsService;


	@GetMapping("/getSubs/{id}")
	public ResponseEntity<?> getSubscription(@PathVariable(name = "id") int idSubscription) {
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
