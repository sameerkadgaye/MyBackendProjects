/**
 * 
 */
package com.practise.controller;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.practise.model.Employee;
import com.practise.model.Project;
import com.practise.repository.EmployeeRepository;
import com.practise.repository.ProjectRepository;

/**
 * @author Sameer Kadgaye
 *
 */
@Controller
public class ProjectController {

	/**
	 * 
	 */
	public ProjectController() {
	}

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private ProjectRepository projectRepository;

	@GetMapping("/employee/{employeeId}/project")
	public String getProjectPage(@PathVariable() Long employeeId, Model model) {
		try {
			Employee employee = this.employeeRepository.findById(employeeId).get();
			if (employee != null) {
				model.addAttribute("company", employee.getCompany());
				model.addAttribute("employee", employee);
				return "companyPages/employeePages/projectPages/projectView";
			}
		} catch (Exception e) {
			model.addAttribute("error", "Employee Does Not Exists !!");
		}
		return "errorPages/error";
	}

	@GetMapping("/employee/{employeeId}/project/new")
	public String getProjectViewPage(@PathVariable() Long employeeId, Model model) {
		try {
			Employee employee = this.employeeRepository.findById(employeeId).get();
			if (employee != null) {
				model.addAttribute("company", employee.getCompany());
				model.addAttribute("employee", employee);
				model.addAttribute("newProject", true);
				return "companyPages/employeePages/projectPages/projectNew";
			}
		} catch (Exception e) {
			model.addAttribute("error", "Employee Does Not Exists !!");
		}
		return "errorPages/error";
	}

	@PostMapping("/employee/project/save")
	public String saveProjects(@RequestParam("data") String data, @RequestParam("employeeId") Long employeeId,
			Model model) {
		Employee employee = this.employeeRepository.findById(employeeId).get();
		Gson gson = new Gson();
		Type listType = new TypeToken<ArrayList<Project>>() {
		}.getType();
		List<Project> projects = gson.fromJson(data, listType);
		projects.forEach(project -> {
			project.setEmployee(employee);
		});
		employee.setProject(projects);
		this.employeeRepository.save(employee);
		return "redirect:/employee/" + employeeId + "/project";
	}

	@PostMapping("/employee/project/edit")
	public String updateProject(@RequestParam("editValues") String editValues[], Model model) {
		Employee employee = this.employeeRepository.findById(Long.valueOf(editValues[0])).get();
		Project project = new Project();
		project.setProjectId(Long.valueOf(editValues[1]));
		project.setProjectName(editValues[2]);
		project.setStatus(editValues[3]);
		project.setDescription(editValues[4]);
		project.setEmployee(employee);
		this.projectRepository.save(project);

		model.addAttribute("company", employee.getCompany());
		model.addAttribute("employee", employee);
		return "redirect:/employee/"+Long.valueOf(editValues[0])+"/project";
	}

	@GetMapping("/employee/project/edit/{projectId}")
	public String getEmployeeEditPage(@PathVariable("projectId") Long projectId, Model model) {
		System.out.println("Edit Employee Heated");
		Project project = this.projectRepository.findById(projectId).get();
		Long tempEmployeeId = project.getEmployee().getEmployeeId();
		Employee employee = this.employeeRepository.findById(tempEmployeeId).get();

		model.addAttribute("company", employee.getCompany());
		model.addAttribute("employee", employee);
		model.addAttribute("editProject", true);
		model.addAttribute("project", this.projectRepository.findById(projectId).get());
		return "companyPages/employeePages/projectPages/projectNew";
	}

	@GetMapping("/employee/project/delete/{projectId}")
	public String getEmployeeDeletePage(@PathVariable("projectId") Long projectId, Model model) {
		Project project = this.projectRepository.findById(projectId).get();
		Long tempEmployeeId = project.getEmployee().getEmployeeId();
		project.setEmployee(null);

		this.projectRepository.delete(project);
		return "redirect:/employee/" + tempEmployeeId + "/project";
	}
}
