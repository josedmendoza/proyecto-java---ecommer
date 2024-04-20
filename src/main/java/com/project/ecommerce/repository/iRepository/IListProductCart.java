package com.project.ecommerce.repository.iRepository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.ecommerce.model.ListProductCart;

public interface IListProductCart extends JpaRepository<ListProductCart, Integer> {
	

	
	@Query(value = "SELECT * FROM LIST_PRODUCT_CART"
			+ " WHERE ID_SHOPPING_CART  IN (select ID_SHOPPING_CART from shopping_cart where dni = :pdni)", nativeQuery = true)
	List<ListProductCart> getProductByUser(@Param("pdni") Integer dni);
	
	@Query(value = "select distinct ID_LIST_PRODUCT_CART from list_product_cart where ID_GAME = :pIdGame  && ID_SHOPPING_CART = :pShoppingCart  ", nativeQuery = true)
	Integer idListProductCartG(@Param(value = "pIdGame") Integer idGame,@Param(value = "pShoppingCart") Integer idShoppingcart);
	
	@Query(value = "select distinct ID_LIST_PRODUCT_CART from list_product_cart where ID_SUBSCRIPTION = :pIdSubs  && ID_SHOPPING_CART = :pShoppingCart  ", nativeQuery = true)
	Integer idListProductCartS(@Param(value = "pIdSubs") Integer idSubs,@Param(value = "pShoppingCart") Integer idShoppingcart);
	
	@Query(value = "select * from list_product_cart where ID_SHOPPING_CART = :pIdCart", nativeQuery = true)
	List<ListProductCart> productByIdCart(@Param(value = "pIdCart") Integer idCart);
	
	@Modifying
	@Query(value = "delete from list_product_cart where ID_SHOPPING_CART = :pIdCart", nativeQuery = true)
	void deleteListByCart(@Param(value = "pIdCart") Integer IdCart);

	
	
}

