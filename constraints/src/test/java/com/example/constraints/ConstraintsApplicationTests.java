package com.example.constraints;

import com.example.constraints.controllers.dto.UserDTO;
import com.example.constraints.helpers.UserDTOHelper;
import com.example.constraints.repositories.UserRepository;
import com.example.constraints.validators.annotations.UsernameUnique;
import java.util.Set;
import javax.validation.ConstraintViolation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.SpringConstraintValidatorFactory;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class ConstraintsApplicationTests {

	@MockBean
	UserRepository userRepository;
	private LocalValidatorFactoryBean validator;
	@Autowired
	private WebApplicationContext webApplicationContext;

	@BeforeEach
	public void setUp() {
		SpringConstraintValidatorFactory springConstraintValidatorFactory
				= new SpringConstraintValidatorFactory(webApplicationContext.getAutowireCapableBeanFactory());
		validator = new LocalValidatorFactoryBean();
		validator.setConstraintValidatorFactory(springConstraintValidatorFactory);
		validator.setApplicationContext(webApplicationContext);
		validator.afterPropertiesSet();
	}

	@Test
	public void shouldCreateUserForNonExistingUsername() {
		// given
		UserDTO userDTO = UserDTOHelper.getNextUserDto();
		// when
		when(userRepository.existsUserByUserName(userDTO.getName())).thenReturn(false);
		Set<ConstraintViolation<UserDTO>> constraintViolations =
				validator.validate(userDTO);

		// then
		assertEquals(0, constraintViolations.size());
	}

	@Test
	public void shouldFailCreateUserForExistingUsername() {
		// given
		String userName = "test-user";
		UserDTO userDTO = UserDTOHelper.getNextUserDto();
		// when
		userDTO.setUserName(userName);
		when(userRepository.existsUserByUserName(userName)).thenReturn(true);
		Set<ConstraintViolation<UserDTO>> constraintViolations =
				validator.validate(userDTO);

		// then
		assertEquals(1, constraintViolations.size());
		constraintViolations.forEach(userDTOConstraintViolation -> {
			assertEquals(userDTOConstraintViolation.getMessage(), "Username already exists");
		});
	}

}
