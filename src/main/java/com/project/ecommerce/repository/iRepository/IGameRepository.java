package com.project.ecommerce.repository.iRepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.ecommerce.model.Game;

public interface IGameRepository extends JpaRepository<Game,Integer>{
	
	
	Optional<?> findDistincByNameContaining(String name);

}
