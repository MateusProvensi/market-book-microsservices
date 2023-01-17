package com.provensi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.provensi.model.Book;
import com.provensi.proxy.CambioProxy;
import com.provensi.repository.BookRepository;
import com.provensi.response.Cambio;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Book endpoint")
@RestController
@RequestMapping("/book-service")
public class BookController {

	@Autowired
	private Environment environment;
	
	@Autowired
	private BookRepository repository;

	@Autowired
	private CambioProxy cambioProxy;

	@GetMapping(value = "/{idLivro}/{currency}")
	@Operation(summary = "Find a specific book by your ID")
	private Book findBook(
			@PathVariable("idLivro") Long id,
			@PathVariable("currency") String currency
			) {
		var book = repository.getByIdBook(id);
		
		if (book == null) {
			throw new RuntimeException("Book Not Found");
		}
		
		Cambio cambio = cambioProxy.getCambio(book.getPrice(), "USD", currency);
				
		var port = environment.getProperty("local.server.port");
		
		book.setEnvironment("Book port: " + port + " Cambio Port: " + cambio.getEnviroment());
		book.setPrice(cambio.getConversionValue());
		
		return book;
	}
}
