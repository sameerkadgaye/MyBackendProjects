package com.practice.controller.common;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class Home {

	@RequestMapping("/welcome")
	public String welcome() {
		String text = "this is private page ";
		text += "this page is not allowed to unauthenticated users";
		return text;
	}

	@RequestMapping("/getusers")
	public String getUser() {
		return "{\"name\":\"sameer\"}";
	}

	@RequestMapping("/signUp")
	public String singUp() {
		String text = "Sign Up Page Heated ";
		return text;
	}

}
