/**
 * 
 */
package com.practice.model.admin.acOpenings.deposit;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author SAMEER KADGAYE
 * @version 0.1
 * 
 *          Created Date : 22/11/2021
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
@Table(name = "Tab_DepositNomineeDetails", schema = "rnas")
public class DepositNomineeDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long despositNomineeDetailsId;

	private String nomineeName;
	private String relation;
	private Integer age;
	private String address;
	private Double percent;
	private Double totalPercent;

//	@JsonBackReference
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "depositAccountId")
//	private DepositAccount depositAccount;

	@OneToOne(mappedBy = "depositNomineeDetails")
	@JsonBackReference
	private DepositAccount depositAccount;

	private Boolean status;
	private String enterBy;
	@Temporal(TemporalType.DATE)
	private Date enterDate;
	private String ipAddress;
	private String macAddress;
	// private String userId;
	private String userName;
}
