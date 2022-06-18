/**
 * 
 */
package com.practice.model.admin.acOpenings.loan;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
 * @author Ashitosh Tabhane
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
@ToString
@Table(name = "Tab_LoanDetails", schema = "rnas")

public class LoanDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long loanDetailsId;
	private Integer receiptNo;
	@Temporal(TemporalType.DATE)
	private Date loanDate;

	private Double loanAmount;
	private Integer loanYear;
	private Integer loanMonth;
	private Integer loanDay;
	private Double interestRate;

	@Temporal(TemporalType.DATE)
	private Date maturityDate;
	private Double approximateMaturityAmount;
	private String yield;
	private Double interestInstallment;
	private String interestPaymentFrequency;
	private Double approximateTotalInterestPayable;
	private String interestProductFrequency;
	private Boolean lienFlag;

	@Temporal(TemporalType.DATE)
	private Date lienDate;
	private String maturityOption;
	private String maturityInterestCondition;
	private Integer branchCode;
	private Integer accountNo;
	private String branchName;
	private String accountName;

	private Boolean status;

	@OneToOne(mappedBy = "loanDetails")
	@JsonBackReference
	private LoanAccount loanAccount;
}
