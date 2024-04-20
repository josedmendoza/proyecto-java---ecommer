package com.project.ecommerce.repository;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.ecommerce.ECommerceApplication;
import com.project.ecommerce.model.Game;
import com.project.ecommerce.model.ListProductCart;
import com.project.ecommerce.model.Subscription;
import com.project.ecommerce.repository.iRepository.IListProductCart;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class ListProductCartRepository {

	private final IListProductCart iListProductCart;
	private final GameRepository gameRepository;
	private final SubscriptionRepository subscriptionRepository;

	private static Logger log = LoggerFactory.getLogger(ECommerceApplication.class);


	public ListProductCart saveListProduct(ListProductCart listProductCart) {
		return iListProductCart.save(listProductCart);
	}

	public List<ListProductCart> getList() {
		return iListProductCart.findAllById(null);
	}

	public Optional<ListProductCart> findById(Integer id) {
		return iListProductCart.findById(id);
	}
	

	//Metodo para actualizar cantidad del producto en el carrito cuando se agrega un producto existente 
	public ListProductCart updatePCartE(ListProductCart productCart) {

		Game game = productCart.getGame();
		Integer idCart = productCart.getShoppingCart().getIdCart();
		Subscription subs = productCart.getSubscription();
		Integer quantity = productCart.getQuantity();
		Integer newStock = 0;

		if (game != null) {
			Integer idListPCartG = iListProductCart.idListProductCartG(game.getIdGame(), idCart);
			ListProductCart listPCart = iListProductCart.findById(idListPCartG).orElseThrow();
			Optional<Game> findp = gameRepository.findbyId(game.getIdGame());
			Integer updateQ = listPCart.getQuantity() + quantity;
			newStock = findp.get().getStock() - quantity;
			Float priceG = findp.get().getPrice();
			Float price = updateQ * priceG;
			listPCart.setQuantity(updateQ);
			listPCart.setPrice(price);
			gameRepository.updateStockLPC(game.getIdGame(), newStock);
			return iListProductCart.save(listPCart);

			
		} else if(subs != null) {
			Integer idListPCartS = iListProductCart.idListProductCartS(subs.getIdSubscription(), idCart);
			ListProductCart listPCart = iListProductCart.findById(idListPCartS).orElseThrow();
			Optional<Subscription> findp = subscriptionRepository.findById(subs.getIdSubscription());
			Integer updateQ = listPCart.getQuantity() + quantity;
			newStock = findp.get().getStock() - quantity;
			Float priceS = findp.get().getPrice();
			Float price = updateQ * priceS;
			listPCart.setPrice(price);
			listPCart.setQuantity(updateQ);
			subscriptionRepository.updateStockLPC(subs.getIdSubscription(), newStock);
			return iListProductCart.save(listPCart);

		}
		
		return productCart;
	}
	
	// metodo para eliminar los productos que estan en el carrito segun el idcart luego de que se genera la factura
	@Transactional
	public void delete(Integer idCart) {
		iListProductCart.deleteListByCart(idCart);
		}

	public Boolean existsGame(ListProductCart productCart) {
		Integer IdGame = productCart.getGame().getIdGame();
		boolean game = iListProductCart.existsById(IdGame);
		return game;
	}

	public Boolean existsSubs(ListProductCart productCart) {
		Integer IdSubs = productCart.getSubscription().getIdSubscription();
		boolean game = iListProductCart.existsById(IdSubs);
		return game;
	}

	public Boolean existListPCartG ( Integer shoppingC, Integer idGame) {
		Integer idListPCart = iListProductCart.idListProductCartG(idGame, shoppingC);
		if(idListPCart != null) {
			boolean existListPCart = iListProductCart.existsById(idListPCart);
			return existListPCart;
		}else {
			return false;
		}
	}
	
	public Boolean existListPCartS ( Integer shoppingC, Integer idSubs) {
		Integer idListPCart = iListProductCart.idListProductCartS(idSubs, shoppingC);
		if(idListPCart != null) {
			boolean existListPCart = iListProductCart.existsById(idListPCart);
			return existListPCart;
		}else {
			return false;
		}
	
	}
	


}
