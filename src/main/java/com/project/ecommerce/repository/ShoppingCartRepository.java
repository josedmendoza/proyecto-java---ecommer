package com.project.ecommerce.repository;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.project.ecommerce.ECommerceApplication;
import com.project.ecommerce.model.ShoppingCart;
import com.project.ecommerce.repository.iRepository.IShoppingCart;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class ShoppingCartRepository {
	
	private final IShoppingCart iShoppingCart;
	
	private static Logger log =  LoggerFactory.getLogger(ECommerceApplication.class);

	
	public ShoppingCart saveSCart(ShoppingCart cart) {
		return iShoppingCart.save(cart);
	}
	
	public ShoppingCart findById(Integer idCart) {
		return iShoppingCart.findById(idCart).orElse(null);
	}
	
	public Boolean existsCart(Integer dni) {
		
		Integer findIdCart = iShoppingCart.existsSCartDni(dni); 
		log.info("findIdCart: {}", findIdCart);
		if(findIdCart != null){
			return iShoppingCart.existsById(findIdCart);
		}else {
			return false;
		}	
	}
	
	
	
//	public Boolean validationCart(Integer dni) {
//		return iShoppingCart.existsSCartDni(dni);
//	}

	
	
}
