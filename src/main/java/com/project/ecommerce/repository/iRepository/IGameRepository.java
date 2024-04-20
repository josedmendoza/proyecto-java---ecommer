package com.project.ecommerce.repository.iRepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.ecommerce.model.Game;

public interface IGameRepository extends JpaRepository<Game,Integer>{
	
	
	Optional<?> findDistincByNameContaining(String name);
	
	@Query(value = "SELECT STOCK FROM GAME WHERE ID_GAME = :PIDGAME", nativeQuery = true)
	Integer getStockG(@Param("PIDGAME") Integer idgame);
	
	@Query(value = "SELECT STOCK FROM SUBSCRIPTION WHERE ID_SUBSCRIPTION = :PIDSUBSCRIPTION", nativeQuery = true)
	Integer getStockS(@Param("PIDSUBSCRIPTION") Integer idSubs);

}
