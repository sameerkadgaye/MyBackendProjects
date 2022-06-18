/**
 * 
 */
package com.practice.model.common;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author SAMEER KADGAYE
 * @version 0.1
 * 
 *          Created Date : 28/10/2021
 * 
 *          Updated Date :
 * 
 *          Updated By :
 *
 */
@Entity
@Table(name = "Tab_Student", schema = "rnas")
public class Student {

	/**
	 * 
	 */
	public Student() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer studentId;
	private String studentFirstName;
	private String studentLastName;

	/**
	 * @param studentId
	 * @param studentFirstName
	 * @param studentLastName
	 */
	public Student(Integer studentId, String studentFirstName, String studentLastName) {
		super();
		this.studentId = studentId;
		this.studentFirstName = studentFirstName;
		this.studentLastName = studentLastName;
	}

	/**
	 * @return the studentId
	 */
	public Integer getStudentId() {
		return studentId;
	}

	/**
	 * @param studentId the studentId to set
	 */
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	/**
	 * @return the studentFirstName
	 */
	public String getStudentFirstName() {
		return studentFirstName;
	}

	/**
	 * @param studentFirstName the studentFirstName to set
	 */
	public void setStudentFirstName(String studentFirstName) {
		this.studentFirstName = studentFirstName;
	}

	/**
	 * @return the studentLastName
	 */
	public String getStudentLastName() {
		return studentLastName;
	}

	/**
	 * @param studentLastName the studentLastName to set
	 */
	public void setStudentLastName(String studentLastName) {
		this.studentLastName = studentLastName;
	}

}
