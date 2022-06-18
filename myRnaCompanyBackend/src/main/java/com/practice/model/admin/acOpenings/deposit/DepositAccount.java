/**
 * 
 */
package com.practice.model.admin.acOpenings.deposit;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.practice.model.admin.masters.customerMaster.CustomerMaster;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
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
@ToString(exclude = { "depositOperatorDetailsList", "depositDetails", "depositNomineeDetails",
		"depositEmiCalculator", "depositUploadedDocuments", "customerMaster" })
@Table(name = "Tab_DepositAccount", schema = "rnas")
public class DepositAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long depositAccountId;
	
//	@Column(unique = true)
	private Long customerCode;

	@Column(unique = true)
//	@Length(min = 9, max = 12, message = "Account Number Contains At least 9 And Max 12 Digits")
//	@Range(min = 100000, message = "Account Number Contains At least 9 And Max 12 Digits")
	@Range(min = 1, message = "Account Number Contains At least 1 Digit")
	private Long accountNo;

	private String accountName;

	@Column(unique = true)
//	@Length(min = 1, max = 10, message = "Application Number Contains At least 1 And Max 10 Digits")
	@Range(min = 1, message = "Application Number Contains At least 1 And Max 10 Digits")
	private Long applicationNo;

	@Temporal(TemporalType.DATE)
	private Date transactionDate;

//	 Deposit Account Starts
	private String glName;
	private String glCode;
	
	@Temporal(TemporalType.DATE)
	private Date effectiveDate;

	// private Long depositAccountNo;
	private String depositAccountType;
	// private String depositAccountName;
	private String occupation;
	private String accountAddress;
	private String accountStatus;
//	Deposit Account Ends

	@OneToMany(mappedBy = "depositAccount", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	//@JsonBackReference
	@Singular
	private List<DepositOperatorDetails> depositOperatorDetailsList;

	@OneToOne(cascade = CascadeType.ALL)
	@JsonManagedReference
	@JoinColumn(name = "depositDetailsId")
	@Singular
	private DepositDetails depositDetails;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonManagedReference
	@JoinColumn(name = "despositNomineeDetailsId")
	@Singular
	private DepositNomineeDetails depositNomineeDetails;
	
//	@OneToMany(mappedBy = "depositAccount", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	@Singular
//	@JsonManagedReference
//	private List<DepositNomineeDetails> depositNomineeDetailsList;

//	@OneToMany(mappedBy = "depositAccount", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	@Singular
//	@JsonManagedReference
//	private List<DepositEmiCalculator> depositEmiCalculators;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonManagedReference
	@JoinColumn(name = "depositEmiCalculatorId")
	@Singular
	private DepositEmiCalculator depositEmiCalculator;

	@OneToMany(mappedBy = "depositAccount", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@Singular
	@JsonManagedReference
	private List<DepositUploadedDocuments> depositUploadedDocuments;

	//@JsonBackReference
	//@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customerMasterId")
	@Singular
	private CustomerMaster customerMaster;

	private Boolean status;
	private String approvedStatusFlag;

	@Temporal(TemporalType.DATE)
	private Date approveDate;

	@Temporal(TemporalType.DATE)
	private Date approveDateTime;

	private String reasonDescription;

	private String enterBy;
	@Temporal(TemporalType.DATE)
	private Date enterDate;
	private String ipAddress;
	private String macAddress;
	private String userId;
}