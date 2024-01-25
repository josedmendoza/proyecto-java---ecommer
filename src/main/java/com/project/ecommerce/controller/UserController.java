package com.project.ecommerce.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.ecommerce.ECommerceApplication;
import com.project.ecommerce.model.User;
import com.project.ecommerce.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

	private final UserService userService;

	private static Logger log = LoggerFactory.getLogger(ECommerceApplication.class);

	@PostMapping(value = "/create", consumes = (MediaType.APPLICATION_JSON_VALUE))
	public ResponseEntity<?> createUser(@RequestBody User user) {
		try {

			log.info("Se recibe los datos del usuario a crear {}", user);

			boolean exists = userService.existsUser(user.getDni());
			if (exists == false) {
				User create = userService.createU(user);
				return ResponseEntity.ok(create);
			} else {
				return ResponseEntity.badRequest().body("Error: cliente existente no se puede dar de alta");
			}
		} catch (Exception e) {
			String msj = e.getMessage();
			System.out.println(msj);
			return ResponseEntity.badRequest().body("/Error:" + msj);
		}

	}

	@GetMapping(value = "finduser/{dni}")
	public ResponseEntity<?> findUser(@PathVariable(name = "dni") Integer dni) {
		
		try {
			log.info("El ID del usuario es:  {}", dni);
//			Optional<?> findId = userService.findU(dni);
			if (userService.existsUser(dni) == true) {
				Optional<?> findId = userService.findU(dni);
				log.info("Se verifico que existe el ID y se retorna los datos del usuario correctamente");
				return ResponseEntity.ok(findId);
			} else {
				log.info("No se pudo encontrar los datos del usuario solicitado");
				return ResponseEntity.badRequest().body("ERROR: no se encontro el usuario");
			}
		}catch(Exception e) {
			String msj = e.getMessage();
			return ResponseEntity.badRequest().body("Error:" + msj);
		}
	}

	@PutMapping("update/{dni}")
	public ResponseEntity<?> updateUser(@PathVariable(name = "dni") Integer dni, @RequestBody User user) {
		Optional<?> findId = userService.findU(dni);
		if (findId.isPresent()) {
			User update = userService.updateUser(dni, user);
			return ResponseEntity.ok(update);
		} else {
			return ResponseEntity.badRequest().body("Error: no se encontro el usuario");
		}
	}

}
