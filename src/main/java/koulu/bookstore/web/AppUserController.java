package koulu.bookstore.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import koulu.bookstore.domain.AppUser;
import koulu.bookstore.domain.AppUserRepository;
import koulu.bookstore.domain.SignupForm;

@Controller
public class AppUserController {
	
	@Autowired
	private AppUserRepository userRepository;
	
	@RequestMapping(value="login")
	public String login() {	
		return "login";
	}
	
	@RequestMapping(value = "signup")
	public String addUser(Model model) {
		model.addAttribute("signupform", new SignupForm());
		return "signup";
	}
	
	@PostMapping("saveuser")
	public String saveUser(
			@Valid @ModelAttribute("signupform") SignupForm signupForm, BindingResult bindingResult) {
		
		if (!bindingResult.hasErrors()) {
			if (signupForm.getPassword().equals(signupForm.getPasswordCheck())) {
				String pwd = signupForm.getPassword();
				BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
				String pwdHash = bc.encode(pwd);
				
				AppUser newUser = new AppUser();
				newUser.setPasswordHash(pwdHash);
				newUser.setUsername(signupForm.getUsername());
				newUser.setRole("USER");
				if (userRepository.findByUsername(signupForm.getUsername()) == null) {
					userRepository.save(newUser);
				} else {
					bindingResult.rejectValue("username", "err.username", "Username taken!");
					return "signup";
				}
			} else {
				bindingResult.rejectValue("passwordCheck", "err.pwdCheck", "Passwords don't match!");
				return "signup";
			}
		} else {
			return "signup";
		}	
		return "redirect:login";
	}

}
