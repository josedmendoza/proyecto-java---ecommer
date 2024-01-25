package com.project.ecommerce.repository.iRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.ecommerce.model.User;


public interface IUserRepository extends JpaRepository<User, Integer> {
	
	


}
