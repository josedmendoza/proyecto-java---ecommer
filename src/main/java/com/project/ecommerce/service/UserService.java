package com.project.ecommerce.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.project.ecommerce.ECommerceApplication;
import com.project.ecommerce.model.User;
import com.project.ecommerce.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {

	private final UserRepository userRepository;
	
	private static Logger log = LoggerFactory.getLogger(ECommerceApplication.class);

	public User createU(User user) {
		log.info("Usuario que se va agregar a la DB {}", user);
		return userRepository.create(user);
	}

	public Optional<User> findU(Integer dni) {
		return userRepository.findByID(dni);
	}

	public boolean existsUser(Integer dni) {
		return userRepository.existsById(dni);
	}

	public User updateUser(Integer dni, User user) {
		return userRepository.updateUserById(dni, user);
	}

}
