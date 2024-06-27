package com.project.ecommerce.service;

import static org.mockito.Mockito.when;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.*;
import static org.junit.jupiter.api.Assertions.*;




import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.project.ecommerce.model.User;
import com.project.ecommerce.repository.UserRepository;

@SpringBootTest
public class UserServiceTest {

	@Autowired
	private UserService userService;
	
	@MockBean
	private UserRepository userRepository;
	
	private User user = new User();
	
	@BeforeEach
	void setUp() {
		
		user.setDni(1);
		user.setFirstName("jose");
		user.setLastName("mendoza");
		user.setAge(23);
		user.setBirthDate(null);
		user.setCreationDate(null);
		user.setDirection("cabildo 111");
		user.setMail("josem@gmail.com");
		user.setTelf(1126456987);
		
	}
	
	@Test
	void testFindUserService() {
		when(userRepository.findByID(anyInt())).thenReturn(Optional.of(user));
		
		Optional<User> findUser = userService.findU(1);

		assertEquals(user, findUser.get());
		
	}
	
	@Test
	void notFoundUser() {
		when(userRepository.findByID(anyInt())).thenReturn(Optional.of(user));
		
		Optional<User> findUser = userService.findU(5);
		
		assertFalse(findUser.isEmpty());
	}
	
}
