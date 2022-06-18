/**
 * 
 */
package com.practice.model.admin.acOpenings.loan;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
@ToString
@Table(name = "Tab_LoanOperatorDetails", schema = "rnas")
public class LoanOperatorDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long loanOperatorDetailsId;

	private Long idLoanAccount;

	// Particulars of the Applicant / Operator Starts
	private String operationMode;
	private Long customerCode;
	private Long memberNo;
	private String accountName;
	private String addressDetails;
	private Integer signatureId;
	private String activeFlag;
	private Boolean loanOperatorStatus;
	private Boolean signatureAuthority;
	private Boolean signatureMustFlag;
	// Particulars of the Applicant / Operator Ends

	@JsonBackReference
	// @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "loanAccountId")
	private LoanAccount loanAccount;

}
