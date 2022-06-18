/**
 * 
 */
package com.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.email.model.EmailRequest;
import com.email.model.EmailResponse;
import com.email.service.EmailService;

/**
 * @author sameer
 *
 */
@RestController
@CrossOrigin
public class EmailController {

	/**
	 * 
	 */
	public EmailController() {
	}

	@Autowired
	private EmailService emailService;

	@GetMapping("/welcome")
	public String welcome() {

		return "Hello This is my email API";
	}

	@PostMapping("/sendemail")
	public ResponseEntity<?> sendemailController(@RequestBody EmailRequest emailRequest) {

		boolean sendEmailResult = this.emailService.sendEmail(emailRequest.getSubject(), emailRequest.getMessage(),
				emailRequest.getTo());

		if (sendEmailResult) {
			System.out.println(emailRequest);
			return ResponseEntity.ok(new EmailResponse("Email is sent successfully..."));
		} else {
			System.out.println(emailRequest);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new EmailResponse("Email not sent..."));
		}

	}
}
