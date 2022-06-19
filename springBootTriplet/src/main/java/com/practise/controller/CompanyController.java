package com.practise.controller;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.practise.model.Company;
import com.practise.model.Employee;
import com.practise.repository.CompanyRepository;
import com.practise.repository.EmployeeRepository;

@Controller
public class CompanyController {

	@Autowired
	private CompanyRepository companyRepository;
	@Autowired
	private EmployeeRepository employeeRepository;

	// ==============>>>>>>>>>> COMPANY CONTROLLER <<<<<<<<<<============== \\
	@GetMapping("/company")
	public String getCompanyPage(Model model) {
		// System.out.println("Home heated Successfully");
		model.addAttribute("company", new Company());
		model.addAttribute("newCompany", true);
		return "companyPages/company";
	}

	@PostMapping("/company/save")
	public String saveCompany(@ModelAttribute("company") Company company, HttpServletRequest request, Model model, BindingResult bindingResult) {
		System.out.println("Inside save Controller");
		if (company.getCompanyId() == null) {
			this.companyRepository.save(company);
			System.out.println("Company Data Saved");
			System.out.println(company);
			return "redirect:/company/view";
		} else {
			System.out.println("Inside Company else Block");
			this.companyRepository.save(company);
			System.out.println("Company Data Updated");
			return "redirect:/company/view";
		}
	}

	@GetMapping("/company/view")
	public String getCompanyViewPage(Model model) {
		model.addAttribute("companyList", this.companyRepository.findAll());
		return "companyPages/companyView";
	}

	@GetMapping("/company/delete/{companyId}")
	public String getCompanyDeletePage(@PathVariable("companyId") Long companyId, Model model) {
		this.companyRepository.deleteById(companyId);
		return "redirect:/company/view";
	}

	@GetMapping("/company/edit/{companyId}")
	public String getCompanyEditPage(@PathVariable("companyId") Long companyId, Model model) {
		System.out.println("Edit Company Heated");
		model.addAttribute("newCompany", true);
		// model.addAttribute("newCompany", false);

		model.addAttribute("company", this.companyRepository.findById(companyId));
		return "companyPages/company";
	}

	// ==============>>>>>>>>>> EMPLOYEES CONTROLLER <<<<<<<<<<============== \\
	@PostMapping("/company/employee/save")
	public String saveEmployee(@ModelAttribute("company") Company company, HttpServletRequest request, Model model) {
		System.out.println("Inside Employee save Controller");
		System.out.println("Inside empty List");
		String data = request.getParameter("data");
		System.out.println("Json =====>>> " + data);
		Gson gson = new Gson();
		Type listType = new TypeToken<ArrayList<Employee>>() {
		}.getType();
		List<Employee> employees = gson.fromJson(data, listType);
		employees.forEach(employee -> {
			employee.setCompany(company);
		});
		company.setEmployee(employees);
		this.companyRepository.save(company);
		System.out.println("Employee Data Saved");
		return "redirect:/company/view";
	}

	@GetMapping("/company/employee/edit")
	public String updateEmployee(@RequestParam("companyId") Long companyId, @RequestParam("employeeId") Long employeeId,
			@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {

		Company company = this.companyRepository.findById(companyId).get();
		Employee employee = new Employee();
		employee.setEmployeeId(employeeId);
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setCompany(company);
		this.employeeRepository.save(employee);
		return "redirect:/company/employee/view/" + companyId;
	}

	@GetMapping("/company/employee/new/{companyId}")
	public String getEmployeeNewPage(@PathVariable("companyId") Long companyId, Model model) {
		System.out.println("Employee New heated");
		model.addAttribute("company", this.companyRepository.findById(companyId).get());
		model.addAttribute("newEmployee", true);
		return "companyPages/company";
	}

	@GetMapping("/company/employee/view/{companyId}")
	public String getEmployeeViewPage(@PathVariable("companyId") Long companyId, Model model) {
		System.out.println("Employee View Heated Successfully");
		Company company = this.companyRepository.findById(companyId).get();
//		company.getEmployee().forEach(employee -> {
//			System.out.println(employee.getEmployeeId());
//		});
		model.addAttribute("company", company);
		model.addAttribute("employeeList", company.getEmployee());
		return "companyPages/employeePages/employeeView";
	}

	@GetMapping("/company/employee/edit/{employeeId}")
	public String getEmployeeEditPage(@PathVariable("employeeId") Long employeeId, Model model) {
		System.out.println("Edit Employee Heated");
		model.addAttribute("editEmployee", true);
		model.addAttribute("employee", this.employeeRepository.findById(employeeId).get());
		return "companyPages/company";
	}

	@GetMapping("/company/employee/delete/{employeeId}")
	public String getEmployeeDeletePage(@PathVariable("employeeId") Long employeeId, Model model) {
		Employee employee = this.employeeRepository.findById(employeeId).get();
		Long tempCompanyId = employee.getCompany().getCompanyId();
		employee.setCompany(null);
		this.employeeRepository.delete(employee);
		return "redirect:/company/employee/view/" + tempCompanyId;
	}
}
