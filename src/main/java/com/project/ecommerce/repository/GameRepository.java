package com.project.ecommerce.repository;

import java.util.Optional;


import org.springframework.stereotype.Repository;

import com.project.ecommerce.model.Game;
import com.project.ecommerce.repository.iRepository.IGameRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class GameRepository {
	
	private final IGameRepository iGameRepository;
	
	
	public Game save(Game game) {
		return iGameRepository.save(game);
	}
	
	public Optional<Game> findbyId(Integer id) {
		return iGameRepository.findById(id);
	}
	
	public Game updateById(Integer id, Game game) {
		Game find = iGameRepository.findById(id).orElseThrow();
		find.setName(game.getName());
		find.setDescription(game.getDescription());
		find.setPrice(game.getPrice());
		find.setStock(game.getStock());
		find.setReleaseDate(game.getReleaseDate());
		return iGameRepository.save(find);
	}
	
	public Game updateStockLPC(Integer id, Integer stock) {
		Game find = iGameRepository.findById(id).orElseThrow();
		find.setStock(stock);
		return iGameRepository.save(find);
	}
	
	
	public Optional<?> findName(String name){
		return iGameRepository.findDistincByNameContaining(name);
	}
	
	public boolean existsId(Integer id) {
		return iGameRepository.existsById(id);
	}
	
	public Integer getstockGame(Integer idGame) {
		return iGameRepository.getStockG(idGame);
	}
	
	public Integer getStockSubs(Integer idSubs) {
		return iGameRepository.getStockS(idSubs);
	}
	

	
	

}
