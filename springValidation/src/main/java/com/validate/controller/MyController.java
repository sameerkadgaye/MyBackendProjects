/**
 * 
 */
package com.validate.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.validate.model.LoginData;

/**
 * @author sameer
 *
 */
@Controller
public class MyController {

	/**
	 * 
	 */
	public MyController() {
	}

	@GetMapping("/form")
	public String getForm(Model model) {
		System.out.println("Inside form");
		model.addAttribute("loginData", new LoginData());

		return "form";
	}

	// Handler For the Process form
	@PostMapping("/process")
	public String handlerForm(@Valid @ModelAttribute("loginData") LoginData loginData, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			System.out.println(bindingResult);

			return "form";
		} else {
			System.out.println(loginData);
			return "success";
		}
	}

}
