package com.practice.model.admin.acOpenings.loan;

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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.practice.model.admin.masters.customerMaster.CustomerMaster;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

/**
 * @author ASHITOSH TABHANE
 * @version 0.1
 * 
 *          Created Date : 22/11/2021
 * 
 *          Updated Date : 24/01/2022
 * 
 *          Updated By : SUMIT KANASKAR
 *
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = { "loanOperatorDetails", "loanDetails", "loanGuarantorDetails", "loanEmiCalculator",
		"customerMaster" })
@Table(name = "Tab_LoanAccount", schema = "rnas")
public class LoanAccount {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long loanAccountId;

	private Long customerCode;

	@Column(unique = true)
	@Range(min = 1, message = "Account Number Contains At least 1 Digit")
	private Long accountNo;

	@Column(unique = true)
	@Range(min = 1, message = "Application Number Contains At least 1 And Max 10 Digits")
	private Long applicationNo;

	private String accountType;

	@Temporal(TemporalType.DATE)
	private Date openEffectiveDate;

//	private Long memberNo;
	private String accountName;

	private String memberType;
	private String constitutionOccupation;

	private String loanType;
	private String issueLoanType;
	private String loanPurpose;
	private String recommendedBySociety;
	private String address;

	private String scheme;
	private String interestCalculationFlag;
	private String calculationMode;
	private String ledgerNo;
	private String interestProductFrequency;
	private String interestPaymentFrequency;

	@Temporal(TemporalType.DATE)
	private Date interestStopDate;
	private String interestStopReason;

	private Long introducerCustomerCode;
//	private Long introducerMemberNo;
	private String introducerAddress;

	@Temporal(TemporalType.DATE)
	private Date transactionDate;

	@OneToMany(mappedBy = "loanAccount", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@Singular
	@JsonManagedReference
	private List<LoanOperatorDetails> loanOperatorDetails;

	@OneToOne(cascade = CascadeType.ALL)
	@JsonManagedReference
	@JoinColumn(name = "loanDetailsId")
	@Singular
	private LoanDetails loanDetails;

	@OneToMany(mappedBy = "loanAccount", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@Singular
	@JsonManagedReference
	private List<LoanGuarantorDetails> loanGuarantorDetails;

	@OneToOne(cascade = CascadeType.ALL)
	@JsonManagedReference
	@JoinColumn(name = "loanEmiCalculatorId")
	@Singular
	private LoanEmiCalculator loanEmiCalculator;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customerMasterId")
	private CustomerMaster customerMaster;

	private Boolean status;
	private Boolean approvedStatusFlag;

	@Temporal(TemporalType.DATE)
	private Date approveDate;

	@Temporal(TemporalType.DATE)
	private Date approveDateTime;

	private String enterBy;
	@Temporal(TemporalType.DATE)
	private Date enterDate;
	private String ipAddress;
	private String macAddress;

}
