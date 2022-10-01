package koulu.bookstore.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/add") 
	public String handleAdd(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", crepository.findAll());
		return "addbook";
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping(value = "/save")
	public String handleSave(@Valid Book book, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("categories", crepository.findAll());
			System.out.println("Validation error in handleSave");
			return "addbook";
		}
		repository.save(book);
		return "redirect:booklist";
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping(value = "/delete/{id}")
	public String handleDelete(@PathVariable("id") Long bookId) {
		repository.deleteById(bookId);
		return "redirect:../booklist";
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping(value = "/edit/{id}")
	public String handleEdit(@PathVariable("id") Long bookId, Model model) {
		model.addAttribute("book", repository.findById(bookId));
		model.addAttribute("categories", crepository.findAll());
		return "editbook";
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping(value = "/saveEdit")
	public String handleSaveEdit(@Valid Book book, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("categories", crepository.findAll());
			System.out.println("Validation error in handleSaveEdit");
			return "editbook";
		}
		repository.save(book);
		return "redirect:booklist";
	}
}
