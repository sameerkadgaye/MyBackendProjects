/**
 * 
 */
package com.practice.model.admin.acOpenings.schedule;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author palash.kharwade
 *
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Tab_loanScheduleDetails" , schema = "rnas")
public class LoanScheduleDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long loanScheduleDetailsId;

	@Temporal(TemporalType.DATE)
	private Date transData;

	private Double totalInterestAmt;
	
	private Double tdsPercentAmt;
	
	private Double interestAmt;
	
	private Double principalAmount;
	
	private Double principalRepay;
	
	private Double balance;
	
	private Long accountNo;
	
	private Long customerCode;
	
	private String customerName;
	
	private Long interestRate;
	
	private Long monthPeriod;
	
	private Long scheduleNo;
	
	private String scheduleType;
	
	private String newScheduleStatus;
	
	private String receiptApproveFlag;
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "transId")
	private LoanScheduleHeads loanScheduleHeads;
	

}
