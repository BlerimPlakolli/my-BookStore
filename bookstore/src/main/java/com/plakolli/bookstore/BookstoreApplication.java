package com.plakolli.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
//import org.springframework.security.core.userdetails.User;

import com.plakolli.bookstore.domain.Book;
import com.plakolli.bookstore.domain.BookRepository;
import com.plakolli.bookstore.domain.Category;
import com.plakolli.bookstore.domain.CategoryRepository;
import com.plakolli.bookstore.domain.User;
import com.plakolli.bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	@Bean
	public CommandLineRunner demoBooStoreData(BookRepository bookRepository, CategoryRepository categoryRepository, UserRepository userRepository) {
		return(args) -> {
			
			categoryRepository.save(new Category("Science"));
			categoryRepository.save(new Category("IT"));
			categoryRepository.save(new Category("Programing"));
			categoryRepository.save(new Category("Comic"));
			
			Book b1 = new Book("Java How to Program (11th Edition)", "Paul J. Deitel", "978-0134743356", 2016, 5.50, categoryRepository.findByName("Programing").get(0));
			Book b2 = new Book("Full Stack Development with spring boot and react", "Juha Hinkula", "078-1-78913-808-5", 2018, 5.50, categoryRepository.findByName("Programing").get(0));
			Book b3 = new Book("Ernest Hemingway", "A farwell to Arms", "1232323-21", 1929, 5.50, categoryRepository.findByName("Programing").get(0));
			Book b4 = new Book("George Orwell", "Animal Farm", "2212343-5", 1945, 5.50, categoryRepository.findByName("Programing").get(0));
			Book b5= new Book("Blerim", "AI Impact", "2344556767", 2019, 5.50, categoryRepository.findByName("Programing").get(0));
			bookRepository.save(b1);
			bookRepository.save(b2);
			bookRepository.save(b3);
			bookRepository.save(b4);
			bookRepository.save(b5);
			
			User user1 = new User("user", "$2a$06$Whi1.R3yWO7iVmjpVLSyh.9wC5etxWV/Vegr0bZQ.wfX1qdDxCpYm", "USER");
			User user2 = new User("admin", "$2a$10$Fi1gDeD2ziNuB6OqdtnCaeN76WL6gWA0BZtW47OFwAx9/KD3JDLjS", "ADMIN");
			userRepository.save(user1);
			userRepository.save(user2);
		};
	}

}

