package com.project.ecommerce.repository.iRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.ecommerce.model.ShoppingCart;

public interface IShoppingCart extends JpaRepository<ShoppingCart, Integer> {
	
	@Query(value = "SELECT ID_SHOPPING_CART FROM shopping_cart WHERE DNI = :pdni", nativeQuery = true)
	Integer existsSCartDni (@Param("pdni") Integer dni);
	
}
