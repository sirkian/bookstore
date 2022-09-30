package koulu.bookstore.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import koulu.bookstore.domain.Category;
import koulu.bookstore.domain.CategoryRepository;

@Controller
public class CategoryController {
	
	@Autowired
	private CategoryRepository crepository;
	
	@GetMapping("categorylist")
	public String getCategories(Model model) {
		model.addAttribute("categories", crepository.findAll());
		return "categorylist";
	}
	
	@GetMapping("addcategory")
	public String addCategory(Model model) {
		model.addAttribute("category", new Category());
		return "addcategory";
	}
	
	@PostMapping("saveCategory")
	public String saveCategory(@Valid Category category, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			System.out.println("Validation error in saveCategory!");
			return "addcategory";
		}
		crepository.save(category);
		return "redirect:categorylist";
	}
	
	@GetMapping(value = "/deleteCategory/{id}")
	public String deleteCategory(@PathVariable("id") Long categoryid) {
		crepository.deleteById(categoryid);
		return "redirect:../categorylist";
	}

}
