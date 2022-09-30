package koulu.bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import koulu.bookstore.domain.Book;
import koulu.bookstore.domain.BookRepository;

@RestController
public class BookRestController {
	
	@Autowired
	private BookRepository repository;
	
	@GetMapping(value = "/books")
	public List<Book> handleGetRest() {
		return (List<Book>) repository.findAll();
	}
	
	@GetMapping(value = "/book/{id}")
	public Optional<Book> handleGetByID(@PathVariable("id") Long bookId) {
		return repository.findById(bookId);
	}
}
