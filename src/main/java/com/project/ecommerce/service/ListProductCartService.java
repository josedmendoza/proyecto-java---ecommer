package com.project.ecommerce.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.project.ecommerce.ECommerceApplication;
import com.project.ecommerce.model.Game;
import com.project.ecommerce.model.ListProductCart;
import com.project.ecommerce.model.Subscription;
import com.project.ecommerce.model.dto.ListProductcartDto;
import com.project.ecommerce.repository.GameRepository;
import com.project.ecommerce.repository.ListProductCartRepository;
import com.project.ecommerce.repository.SubscriptionRepository;
import com.project.ecommerce.repository.iRepository.IListProductCart;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ListProductCartService {

	private final ListProductCartRepository listProductCartRepository;
	private final IListProductCart iListProductCart;
	private final GameRepository gameRepository;
	private final SubscriptionRepository subscriptionRepository;
	private final GameServices gameServices;

	private static Logger log = LoggerFactory.getLogger(ECommerceApplication.class);

	// crear un litProductCard, validar si hay stock disponible del producto y
	// calcular precio en base a la cantida de productos
	public ListProductCart createListP(ListProductCart productCart) {

		if (productCart.getGame() != null) {
			Integer stockG = gameRepository.getstockGame(productCart.getGame().getIdGame());
			boolean existlistPCartG = listProductCartRepository
					.existListPCartG(productCart.getShoppingCart().getIdCart(), productCart.getGame().getIdGame());
			if (stockG >= productCart.getQuantity() && existlistPCartG == false) {
				Optional<Game> findp = gameRepository.findbyId(productCart.getGame().getIdGame());
				Float priceG = findp.get().getPrice();
				Float price = productCart.getQuantity() * priceG;
				productCart.setPrice(price);
				gameServices.updateStockAddP(productCart.getGame().getIdGame(), productCart.getQuantity());
			} else if (stockG >= productCart.getQuantity() && existlistPCartG == true) {
				return listProductCartRepository.updatePCartE(productCart);
			} else {
				return null;
			}
		} else if (productCart.getSubscription() != null) {
			Integer stockS = gameRepository.getStockSubs(productCart.getSubscription().getIdSubscription());
			boolean existlistPCartS = listProductCartRepository.existListPCartS(
					productCart.getShoppingCart().getIdCart(), productCart.getSubscription().getIdSubscription());
			if (stockS >= productCart.getQuantity() && existlistPCartS == false) {
				Optional<Subscription> findp = subscriptionRepository
						.findById(productCart.getSubscription().getIdSubscription());
				Float priceS = findp.get().getPrice();
				Float price = productCart.getQuantity() * priceS;
				productCart.setPrice(price);
			} else if (stockS >= productCart.getQuantity() && existlistPCartS == true) {
				return listProductCartRepository.updatePCartE(productCart);
			} else {
				return null;
			}
		}

		return listProductCartRepository.saveListProduct(productCart);

	}

	// Metodo donde se obtiene todos los productos del carrito de un cliente a
	// traves del idCart y
	// Luego son casteados a productos del carrito DTO para retornar solo los
	// atributos requeridos.
	@JsonIgnoreProperties(value = "idListProductcart")
	public List<ListProductcartDto> getListP(Integer idCart) {
		List<ListProductCart> listProduct = iListProductCart.productByIdCart(idCart);
		List<ListProductcartDto> listPDto = new ArrayList<>();

		for (ListProductCart list : listProduct) {
			ListProductcartDto listDto = new ListProductcartDto();
			listDto.setGameDto(list.getGame());
			listDto.setPriceDto(list.getPrice());
			listDto.setQuantityDto(list.getQuantity());
			listDto.setShoppingCartDto(list.getShoppingCart());
			listDto.setSubscriptionDto(list.getSubscription());

			listPDto.add(listDto);

		}

		return listPDto;
	}
	
	
	//Metodo para actualizar la cantidad de productos del carrito de compras 
	public ListProductCart upPQuantiy (ListProductCart productcart) {
		
		Game game = productcart.getGame();
		Integer idCart = productcart.getShoppingCart().getIdCart();
		Subscription subs = productcart.getSubscription();
		Integer quantityP = productcart.getQuantity();
		Integer newQ = 0;
		Integer newStock = 0;
		
		if (game != null) {
			Integer idListPCartG = iListProductCart.idListProductCartG(game.getIdGame(), idCart);
			log.info(" idListPCartG {}", idListPCartG);
			ListProductCart listPCart = iListProductCart.findById(idListPCartG).orElseThrow();
			Optional<Game> findp = gameRepository.findbyId(game.getIdGame());
			
			if(quantityP > 0) {
				newQ = listPCart.getQuantity() + quantityP;
				newStock = findp.get().getStock() - quantityP;
			}else {
				newQ = listPCart.getQuantity() + quantityP;
				newStock = findp.get().getStock() - quantityP;
			}
			
			listPCart.setQuantity(newQ);
			gameRepository.updateStockLPC(game.getIdGame(), newStock);
			return listProductCartRepository.saveListProduct(listPCart) ;
		} else if(subs != null) {
			Integer idListPCartS = iListProductCart.idListProductCartS(subs.getIdSubscription(), idCart);
			ListProductCart listPCart = iListProductCart.findById(idListPCartS).orElseThrow();
			Optional<Subscription> findp = subscriptionRepository.findById(subs.getIdSubscription());
		
			if(quantityP > 0) {
				newQ = listPCart.getQuantity() + quantityP;
				newStock = findp.get().getStock() - quantityP;
			}else {
				newQ = listPCart.getQuantity() + quantityP;
				newStock = findp.get().getStock() - quantityP;

			}
			
			listPCart.setQuantity(newQ);
			subscriptionRepository.updateStockLPC(subs.getIdSubscription(), newStock);
			return listProductCartRepository.saveListProduct(listPCart) ;
		}else {
			return null;
		}
		
	}

}
