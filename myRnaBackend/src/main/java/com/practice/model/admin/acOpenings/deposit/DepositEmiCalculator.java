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
//@ToString
@Table(name = "Tab_DepositEmiCalculator", schema = "rnas")
public class DepositEmiCalculator {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long depositEmiCalculatorId;

	@Temporal(TemporalType.DATE)
	private Date fromDate;

	@Temporal(TemporalType.DATE)
	private Date toDate;

	private Double principleAmount;
	private Double interestPercent;
	private Double tdsPercent;
	private Double principleRepayment;

//	@Temporal(TemporalType.DATE)
//	private Date date;
//
//	private Double totalInterestAmount;
//	private Double tdsAmount;
//	private Double interestAmt;
//	private Double principalReceived;
//	private Double principalRepayment;
//	private Double balance;
//	private Double emiPayment;

	@OneToOne(mappedBy = "depositEmiCalculator")
	@JsonBackReference
	private DepositAccount depositAccount;

//	@JsonBackReference
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "depositAccountId")
//	private DepositAccount depositAccount;

	private Boolean status;
	private String enterBy;
	@Temporal(TemporalType.DATE)
	private Date enterDate;
	private String ipAddress;
	private String macAddress;
	private String userId;
}
