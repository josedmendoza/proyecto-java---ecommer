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
import com.project.ecommerce.model.Game;
import com.project.ecommerce.service.GameServices;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/game")
public class GameController {

	private final GameServices gameService;
	
	private static Logger log =  LoggerFactory.getLogger(ECommerceApplication.class);

	@Operation(description = "Metodo  utilizado para agregar un juego nuevo que no se encuentra en la DB", summary = "Agregar juego")
	@PostMapping(value = "/creategame", consumes = (MediaType.APPLICATION_JSON_VALUE))
	public ResponseEntity<?> createGame(@RequestBody Game game) {
		try {
						
			Optional<?> name = gameService.validationName(game.getName());
			log.info("el nombre del juego a crear es:  {}", name);
			if (name.equals(game.getName())) {
				return ResponseEntity.badRequest().body("Error: Juegos existente no se pudo agregar el nuevo juego");
			} else {
				Game create = gameService.createG(game);
				return ResponseEntity.ok(create);
			}
		} catch (Exception e) {
			String msj = e.getMessage();
			log.info("Error: {}", msj);
			return ResponseEntity.badRequest().body("Error al crear el juego" + msj);
		}
	}

	@Operation(description = "Metodo  utilizado para obtener un juego  que se encuentra en la DB", summary = "buscar juego")
	@GetMapping(value = "getgame/{id}", produces = (MediaType.APPLICATION_JSON_VALUE))
	public ResponseEntity<?> findGame(
			@Parameter(description = "Id del juego", required = true, example = "1,2,3,...")
			@PathVariable(name = "id") Integer idGame) {
		try {
			if (gameService.validationId(idGame) == true) {
				Optional<Game> getGame = gameService.findG(idGame);
				return ResponseEntity.ok(getGame);
			} else {
				return ResponseEntity.badRequest().body("No se encontro el juego con el ID solicitado");
			}
		} catch (Exception e) {
			String msj = e.getMessage();
			return ResponseEntity.badRequest().body("Error:no se pudo ejecutar el metodo" + msj);
		}
	}

	@Operation(description = "Metodo  utilizado para modificar los datos de un juego  que se encuentra en la DB", summary = "Modificar juego")
	@PutMapping("updateGame/{id}")
	public ResponseEntity<?> updateGame(@PathVariable(name = "id") Integer idGame, @RequestBody Game game) {
		try{
			if (gameService.validationId(idGame) == true) {
				Game update = gameService.updateG(idGame, game);
				return ResponseEntity.ok(update);
			} else {
				return ResponseEntity.badRequest().body("Error: no se encontre el juego que se desea actualizar");
			}
		}catch(Exception e){
			String msj = e.getMessage();
			return ResponseEntity.badRequest().body("Error:no se pudo ejecutar el metodo" + msj);
		}
		
	}

}
