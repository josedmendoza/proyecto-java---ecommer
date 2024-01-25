package com.project.ecommerce.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.project.ecommerce.model.User;
import com.project.ecommerce.repository.iRepository.IUserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public  class UserRepository  {
	
	
	private final  IUserRepository crudRepository;

	public User create(User user) {
		return crudRepository.save(user);
	}
	

	public Optional<User> findByID(Integer dni) {
		return crudRepository.findById(dni);
	}
	
	
	public boolean existsById(Integer dni) {
		return crudRepository.existsById(dni);
	}


	public User updateUserById(Integer dni, User user) {
		 User find = crudRepository.findById(dni).
				 orElseThrow(() -> new RuntimeException());
		find.setFirstName(user.getFirstName());
		find.setLastName(user.getLastName());
		find.setAge(user.getAge());
		find.setDirection(user.getDirection());
		return crudRepository.save(find);
	}
	


}
