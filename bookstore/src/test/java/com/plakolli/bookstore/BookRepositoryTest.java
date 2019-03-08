package com.plakolli.bookstore;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.plakolli.bookstore.domain.Book;
import com.plakolli.bookstore.domain.BookRepository;
import com.plakolli.bookstore.domain.Category;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {
	
	@Autowired
	private BookRepository bRepository;
	
	@Test
	public void findByAuthor() {
		List<Book> books = bRepository.findByAuthor("Blerim");
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getTitle()).isEqualTo("AI Impact");
	}
	
	@Test
	public void createNewBook() {
		Book book = new Book("BGP", "Wendell Odom", "123-453-23-5", 1998, 30, new Category("Fiction"));
		bRepository.save(book);
		assertThat(book.getId()).isNotNull();
	}
	
	@Test
	public void deleteBook() {
		List<Book> books = bRepository.findByAuthor("Blerim");
		assertThat(books).hasSize(1);
		Long bookid = books.get(0).getId();
		bRepository.deleteById(bookid);
		books = bRepository.findByAuthor("Blerim");
		assertThat(books).hasSize(0);
	}
}
