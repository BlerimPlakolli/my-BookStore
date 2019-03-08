package com.plakolli.bookstore;


import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

import javax.swing.Spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.plakolli.bookstore.domain.User;

import com.plakolli.bookstore.domain.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {
	
	@Autowired UserRepository repository;
	
	@Test
	public void findByUsername() {
		User users = repository.findByUsername("admin");
		assertThat(users.getUsername().equals("admin"));
	}

}
