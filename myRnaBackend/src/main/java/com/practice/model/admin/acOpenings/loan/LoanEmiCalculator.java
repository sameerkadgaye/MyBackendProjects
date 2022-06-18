/**
 * 
 */
package com.practice.model.admin.acOpenings.loan;

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
 * 
 *         Updated Date : 24/01/2022
 * 
 *         Updated By : SUMIT KANASKAR
 *
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "Tab_LoanEmiCalculator", schema = "rnas")
public class LoanEmiCalculator {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long loanEmiCalculatorId;

	@Temporal(TemporalType.DATE)
	private Date FromDate;

	private Double principleAmount;

	private Double interestPercent;

	private Double tdsPercent;

	private Double principleRepayment;

	@Temporal(TemporalType.DATE)
	private Date date;

	private Double totalInterestAmount;

	private Double tdsAmount;

	private Double interestAmt;
	private Double principalReceived;
	private Double principalRepayment;
	private Double balance;
	private Double emiPayment;

	@OneToOne(mappedBy = "loanEmiCalculator")
	@JsonBackReference
	private LoanAccount loanAccount;
}
