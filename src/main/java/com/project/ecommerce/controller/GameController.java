package com.project.ecommerce.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.ecommerce.ECommerceApplication;
import com.project.ecommerce.model.Game;
import com.project.ecommerce.service.GameServices;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/game")
public class GameController {

	private final GameServices gameService;
	
	private static Logger log =  LoggerFactory.getLogger(ECommerceApplication.class);


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

	
	@GetMapping(value = "getgame/{id}", produces = (MediaType.APPLICATION_JSON_VALUE))
	public ResponseEntity<?> findGame(@PathVariable(name = "id") Integer idGame) {
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
