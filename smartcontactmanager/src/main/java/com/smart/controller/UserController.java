/**
 * 
 */
package com.smart.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.smart.dao.ContactRepository;
import com.smart.dao.UserRepository;
import com.smart.helper.Message;
import com.smart.model.Contact;
import com.smart.model.User;

/**
 * @author sameer
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {

	/**
	 * 
	 */
	public UserController() {
	}

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ContactRepository contactRepository;

	@ModelAttribute
	public void getPrinciple(Model model, Principal principle) {
		String userName = principle.getName();
		// System.out.println("USERNAME ====>>>> " + userName);
		model.addAttribute("user", this.userRepository.getUserByUserName(userName));
	}

	// User Dashboard
	@GetMapping("/index")
	public String homePage(Model model, Principal principle) {
		System.out.println("Inside user_dashboard handler");
		model.addAttribute("title", "User Dashboard - Smart Contact Manager");
		return "normal/user_dashboard";
	}

	// Open Add Form Handler
	@GetMapping("/add-contact")
	public String openAddContactPage(Model model, Principal principle) {
		System.out.println("Inside add_contact_form handler");
		model.addAttribute("title", "Conatct Form - Smart Contact Manager");
		model.addAttribute("contact", new Contact());
		return "normal/add_contact_form";
	}

	// processing To add Contact Form
	@PostMapping("/process-contact")
	public String processContact(@ModelAttribute Contact contact,
			@RequestParam("profileImage") MultipartFile multipartFile, Principal principle, HttpSession session) {

		try {

			/*
			 * if (3 > 2) { throw new Exception(); }
			 */

			// Processing to uploading File
			if (multipartFile.isEmpty()) {
				System.out.println("File Is Empty");
				// if the file is empty then our message
				contact.setImage("contact.png");

			} else {
				// Upload the file to our User-defined folder
				contact.setImage(multipartFile.getOriginalFilename());
				File file = new ClassPathResource("static/img").getFile();
				Path path = Paths.get(file.getAbsolutePath() + File.separator + multipartFile.getOriginalFilename());
				Files.copy(multipartFile.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
				System.out.println("Image is Uploaded");
			}

			System.out.println("Inside save");
			User user = this.userRepository.getUserByUserName(principle.getName());
			contact.setUser(user);
			user.getContact().add(contact);
			this.userRepository.save(user);
			System.out.println("Contact Data ==>>" + contact);
			System.out.println("Added To Database");
			session.setAttribute("message", new Message("Your Contact is added !!", "success"));

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			session.setAttribute("message", new Message("Something Went wrong Try Again !!", "danger"));
		}

		return "normal/add_contact_form";
	}

	// view Contacts Handler
	// per page -5[n]
	// current page -0 [page]

	@GetMapping("/show-contacts/{page}")
	public String viewAddedContactPage(@PathVariable("page") Integer page, Model model, Principal principle) {
		System.out.println("Inside add_contact_form handler");
		model.addAttribute("title", "Show Contacts - Smart Contact Manager");
		User user = this.userRepository.getUserByUserName(principle.getName());

		// current-page
		// contact-per-page-5
		Pageable pageable = PageRequest.of(page, 5);

		Page<Contact> contacts = this.contactRepository.findContactsByUser(user.getUserId(), pageable);

		model.addAttribute("contactList", contacts);
		model.addAttribute("currentPage", page);
		model.addAttribute("totalPages", contacts.getTotalPages());

		return "normal/show_contats";
	}

	// Handler For User Person email through Specific Contact details
	@GetMapping("/{cId}/conatct")
	public String viewUserContactPage(@PathVariable("cId") Integer cId, Model model, Principal principle) {
		System.out.println("Inside contact Details handler");

		Optional<Contact> contactOptional = this.contactRepository.findById(cId);
		Contact contact = contactOptional.get();
		User user = this.userRepository.getUserByUserName(principle.getName());

		if (user.getUserId() == contact.getUser().getUserId()) {
			model.addAttribute("contact", contact);
			model.addAttribute("title", contact.getName() + "- Smart Contact Manager");
		}

		return "normal/contact_detail";
	}

	// Delete Contact Handler
	@GetMapping("/delete/{cId}")
	public String deleteContact(@PathVariable("cId") Integer cId, Model model, Principal principle,
			HttpSession session) {
		System.out.println("Inside delete handler");

		Contact contact = this.contactRepository.findById(cId).get();
		// Check assignment
		System.out.println("Contact ==>  " + contact.getcId());

		contact.setUser(null);
		this.contactRepository.delete(contact);
		System.out.println("Delected");
		session.setAttribute("message", new Message("Contact Deleted Successfully", "success"));
		return "redirect:/user/show-contacts/0";
	}

	// OPEN Update form handler
	@PostMapping("/update-contact/{cId}")
	public String openUpdateForm(@PathVariable("cId") Integer cId, Model model) {
		System.out.println("Inside Update open");
		model.addAttribute("title", "Update Contact - Smart Contact Manager");
		model.addAttribute("contact", this.contactRepository.findById(cId).get());
		return "normal/update_form";
	}

	// processing To Update Contact Form
	@PostMapping("/update-contact")
	public String processUpdateContact(@ModelAttribute Contact contact,
			@RequestParam("profileImage") MultipartFile multipartFile, Principal principle, HttpSession session) {

		try {

			// old Contact Details
			Contact oldContactDeatils = this.contactRepository.findById(contact.getcId()).get();

			// Processing to uploading File
			if (!multipartFile.isEmpty()) {
				System.out.println("File Is Not Empty");

				// delete Old Photo
				File deletefilePath = new ClassPathResource("static/img").getFile();
				File forDeleteFileHere = new File(deletefilePath, oldContactDeatils.getImage());
				forDeleteFileHere.delete();
				System.out.println("old File Deleted");

				// update new Photo
				File file = new ClassPathResource("static/img").getFile();
				Path path = Paths.get(file.getAbsolutePath() + File.separator + multipartFile.getOriginalFilename());
				Files.copy(multipartFile.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
				contact.setImage(multipartFile.getOriginalFilename());
				System.out.println("Image is Uploaded");

			} else {
				contact.setImage(oldContactDeatils.getImage());

			}
			User user = this.userRepository.getUserByUserName(principle.getName());
			contact.setUser(user);
			this.contactRepository.save(contact);
			session.setAttribute("message", new Message("Your Contact is Updated ...", "success"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			session.setAttribute("message", new Message("Something Went wrong Try Again !!", "danger"));
		}
		return "redirect:/user/" + contact.getcId() + "/conatct";
	}

}
