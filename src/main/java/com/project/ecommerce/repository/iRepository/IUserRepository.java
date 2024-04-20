package com.project.ecommerce.repository.iRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.ecommerce.model.User;


public interface IUserRepository extends JpaRepository<User, Integer> {
	
	@Query(value = "select  user.* from shopping_cart  join user on shopping_cart.dni = user.dni  where ID_SHOPPING_CART = :pIdCart", nativeQuery = true)
	User getUser(@Param(value = "pIdCart") Integer idCart);
	


}
