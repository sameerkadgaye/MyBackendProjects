/**
 * 
 */
package com.smart.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.smart.dao.UserRepository;
import com.smart.helper.Message;
import com.smart.model.User;

/**
 * @author sameer
 *
 */
@Controller
public class HomeController {

	/**
	 * 
	 */
	public HomeController() {
	}

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/base")
	public String basePage(Model model) {
		System.out.println("Inside base handler");
		return "base";
	}

	@GetMapping("/")
	public String homePage(Model model) {
		System.out.println("Inside Home handler");
		model.addAttribute("title", "Home - Smart Contact Manager");
		return "home";
	}

	@GetMapping("/about")
	public String aboutPage(Model model) {
		System.out.println("Inside about handler");
		model.addAttribute("title", "About - Smart Contact Manager");
		return "about";
	}

	@GetMapping("/contact")
	public String contactPage(Model model) {
		System.out.println("Inside contact handler");
		model.addAttribute("title", "contact - Smart Contact Manager");
		return "contact";
	}

	@GetMapping("/signup")
	public String signUpPage(Model model) {
		System.out.println("Inside signup handler");
		model.addAttribute("title", "Register - Smart Contact Manager");
		model.addAttribute("user", new User());
		return "signup";
	}

	@GetMapping("/login")
	public String loginPage(Model model) {
		System.out.println("Inside login handler");
		model.addAttribute("title", "Login - Smart Contact Manager");
		model.addAttribute("user", new User());
		return "login";
	}

	@GetMapping("/login-failed")
	public String loginFailedPage(Model model) {
		System.out.println("Inside login handler");
		model.addAttribute("title", "Login-Failed - Smart Contact Manager");
		model.addAttribute("user", new User());
		return "login-failed";
	}

	@PostMapping("/do_register")
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult,
			@RequestParam(value = "agreement", defaultValue = "false") boolean agreement, Model model,
			HttpSession session) {
		try {
			if (!agreement) {
				System.out.println("You Have Not Agreed THe Terms And Condition");
				throw new Exception("You Have Not Agreed The Terms And Conditions");
			}

			if (bindingResult.hasErrors()) {
				System.out.println("ERROR  ==>>  " + bindingResult.toString());
				;
				model.addAttribute("user", user);
				return "signup";
			}

			user.setRole("ROLE_USER");
			user.setEnabled(true);
			user.setImageUrl("default.png");
			user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

			System.out.println("Agreement ==>>  " + agreement);
			System.out.println("USER ==>>  " + user);
			this.userRepository.save(user);

			model.addAttribute("user", new User());
			// Here we setting our own message in session obj and that msg we access in
			// html->signup.html
			session.setAttribute("message", new Message("Successfully Registered !! ", "alert-success"));
			return "signup";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("user", user);
			// Here we setting our own message in session obj and that msg we access in
			// html->signup.html
			session.setAttribute("message", new Message("Something Went Wrong !! " + e.getMessage(), "alert-danger"));
			return "signup";
		}
	}
}