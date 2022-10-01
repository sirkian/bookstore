package koulu.bookstore.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import koulu.bookstore.domain.Book;
import koulu.bookstore.domain.BookRepository;

@RestController
public class BookRestController {
	
	@Autowired
	private BookRepository repository;
	
	@GetMapping("/books")
	public Iterable<Book> getBooks() {
		return repository.findAll();
	}
	
	@GetMapping("/books/{id}")
	public Optional<Book> getById(@PathVariable("id") Long bookId) {
		return repository.findById(bookId);
	}
	
	@PostMapping("/books")
	public Book addBook(@RequestBody Book book) {
		return repository.save(book);
	}
	
	@PutMapping("/books/{id}")
	public Book editBook(@RequestBody Book book, @PathVariable Long id) {
		book.setId(id);
		return repository.save(book);
	}
	
	@DeleteMapping("/books/{id}")
	public Iterable<Book> deleteBook(@PathVariable Long id) {
		repository.deleteById(id);
		return repository.findAll();
	}
}
