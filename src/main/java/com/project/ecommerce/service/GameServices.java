package com.project.ecommerce.service;


import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.project.ecommerce.ECommerceApplication;
import com.project.ecommerce.model.Game;
import com.project.ecommerce.repository.GameRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class GameServices {
	
	private final GameRepository gameRepository;
	
	private static Logger log = LoggerFactory.getLogger(ECommerceApplication.class);
	
	public Game createG (Game game) {
		log.info("Se ejecuta metodo createG de la capa Service");
		return gameRepository.save(game);
	}
	
	public Optional<Game> findG(Integer idGame) {
		return gameRepository.findbyId(idGame);
	}
	
	public Game updateG(Integer idGame, Game game) {
		return gameRepository.updateById(idGame, game);
	}
	
	public Optional<?> validationName(String name){
		return gameRepository.findName(name);
	}
	
	public boolean validationId(Integer id) {
		return gameRepository.existsId(id);
	}
	
}
