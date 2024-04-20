package com.project.ecommerce.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.project.ecommerce.ECommerceApplication;
import com.project.ecommerce.model.ShoppingCart;
import com.project.ecommerce.model.dto.ShoppingCartDto;
import com.project.ecommerce.repository.ShoppingCartRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ShoppingCartService {

	private final ShoppingCartRepository cartRepository;
	
	private static Logger log =  LoggerFactory.getLogger(ECommerceApplication.class);

	
	public ShoppingCartDto createSCart (ShoppingCart cart) {
		ShoppingCart save = cartRepository.saveSCart(cart);
		ShoppingCartDto saveDto = new ShoppingCartDto();
		saveDto.setIdCart(save.getIdCart());
		saveDto.setUser(save.getUser());
		return saveDto;
	}
	
	public Boolean validationId(Integer dni) {
		
		log.info("dni en service es : {}", dni);

		return cartRepository.existsCart(dni);
	}
	
	public ShoppingCartDto findCart(Integer idCart) {
		
		ShoppingCart find = cartRepository.findById(idCart);
		ShoppingCartDto cart = new ShoppingCartDto();
		cart.setIdCart(idCart);
		cart.setUser(find.getUser());
		return cart;	
		
		
//		return cartRepository.findById(idCart);
	}
	
	
	

}
