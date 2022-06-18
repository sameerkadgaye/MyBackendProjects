/**
 * 
 */
package com.practice.model.common;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "Testing_Tab", schema = "rnas")
//@DynamicInsert
public class Test {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long testId;

	@Column(unique = true)
	//@Min(message = "Test Application No Must be 6 digit", value = 6) //Manaje// Variable Value Hi 6 peksha Jast Pahije
	// @Range(min = 6, max = 10, message = "Test Application No Must be 6 digit")
	//@Length(min = 6, max = 10, message = "Test Application No Must be 6 digit") // manaje yachi length hi 6 peksha jast
																				// hawi ani 10 peksha kami For Only String
	@Range(min = 100000, message = "Test Application No Minimum 100000 pahije")
//	@NotNull
	private Long testApplicationNo;
	
	//@NotNull
	//@Range(min = 100000, message = "testApplicationNo2Test No Minimum 100000 pahije")
	private Long testApplicationNo2Test;

	@NotEmpty
	@Size(min = 2, message = "user name should have at least 2 characters")
	private String fname;

	private String lname;

//	@Column(unique = true)
//	@Column(unique = true, updatable = false)
	// @Size(min = 6, max = 10)
//	@ColumnDefault("100000")
	// @Min(message = "Test Application No Must be 6 digit", value = 6)
//	@Range(min = 6, max = 10, message = "Test Application No Must be 6 digit")
//	@NotNull
//	private Long testApplicationNo;

}
