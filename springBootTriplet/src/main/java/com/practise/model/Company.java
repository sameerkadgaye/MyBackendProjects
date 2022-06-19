/**
 * 
 */
package com.practise.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author HP
 *
 */
@Entity
@Table(name = "tab_triplet_company")
public class Company {

	/**
	 * 
	 */
	public Company() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long companyId;

	private String companyName;

	@OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
	private List<Employee> employee;

	/**
	 * @param companyId
	 * @param companyName
	 * @param employee
	 */
	public Company(Long companyId, String companyName, List<Employee> employee) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		this.employee = employee;
	}

	/**
	 * @return the companyId
	 */
	public Long getCompanyId() {
		return companyId;
	}

	/**
	 * @param companyId the companyId to set
	 */
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * @return the employee
	 */
	public List<Employee> getEmployee() {
		return employee;
	}

	/**
	 * @param employee the employee to set
	 */
	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Company [companyId=" + companyId + ", companyName=" + companyName + ", employee=" + employee + "]";
	}

}
