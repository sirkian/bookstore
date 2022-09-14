package koulu.bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import koulu.bookstore.domain.Book;
import koulu.bookstore.domain.BookRepository;
import koulu.bookstore.domain.CategoryRepository;

@Controller
public class BookController {
	
		@Autowired
		private BookRepository repository;
		
		@Autowired
		private CategoryRepository crepository;
	
	@RequestMapping(value = {"/", "/booklist"}) 
	public String bookList(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}
	
	@RequestMapping(value = "/add") 
	public String handleAdd(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", crepository.findAll());
		return "addbook";
	}
	
	@PostMapping(value = "/save")
	public String handleSave(Book book) {
		repository.save(book);
		return "redirect:booklist";
	}
	
	@GetMapping(value = "/delete/{id}")
	public String handleDelete(@PathVariable("id") Long bookId) {
		repository.deleteById(bookId);
		return "redirect:../booklist";
	}
	
	@GetMapping(value = "/edit/{id}")
	public String handleEdit(@PathVariable("id") Long bookId, Model model) {
		model.addAttribute("book", repository.findById(bookId));
		model.addAttribute("categories", crepository.findAll());
		return "editbook";
	}	
	
	// REST SERVICES
	
	@GetMapping(value = "/books")
	public @ResponseBody List<Book> handleGetRest() {
		return (List<Book>) repository.findAll();
	}
	
	@GetMapping(value = "/book/{id}")
	public @ResponseBody Optional<Book> handleGetByID(@PathVariable("id") Long bookId) {
		return repository.findById(bookId);
	}
}
