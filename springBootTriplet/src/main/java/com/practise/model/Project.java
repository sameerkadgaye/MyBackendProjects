/**
 * 
 */
package com.practise.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Sameer Kadgaye
 *
 */
@Entity
@Table(name = "tab_triplet_project")
public class Project {

	/**
	 * 
	 */
	public Project() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long projectId;

	private String projectName;

	private String description;

	private String status;

	@ManyToOne
	private Employee employee;

	/**
	 * @param projectId
	 * @param projectName
	 * @param description
	 * @param status
	 * @param employee
	 */
	public Project(Long projectId, String projectName, String description, String status, Employee employee) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.description = description;
		this.status = status;
		this.employee = employee;
	}

	/**
	 * @return the projectId
	 */
	public Long getProjectId() {
		return projectId;
	}

	/**
	 * @param projectId the projectId to set
	 */
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	/**
	 * @return the projectName
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * @param projectName the projectName to set
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the employee
	 */
	public Employee getEmployee() {
		return employee;
	}

	/**
	 * @param employee the employee to set
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectName=" + projectName + ", description=" + description
				+ ", status=" + status + ", employee=" + employee + "]";
	}

}
