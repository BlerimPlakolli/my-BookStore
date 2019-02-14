package com.plakolli.bookstore.web;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.plakolli.bookstore.domain.BookRepository;

@Controller
public class BookController {
	
	@Autowired
	private BookRepository bookRepository;
	
	@GetMapping("/index")
	public String test() {
		return "index";
	}
	
	@GetMapping("/booklist")
	public String getAllBooks(Model model) {
		model.addAttribute("books", bookRepository.findAll());
		return "booklist";
	}

}
