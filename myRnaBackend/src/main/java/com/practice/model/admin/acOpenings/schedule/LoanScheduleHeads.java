/**
 * 
 */
package com.practice.model.admin.acOpenings.schedule;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;

/**
 * @author palash.kharwade
 *
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Tab_loanScheduleHeads" , schema = "rnas")
public class LoanScheduleHeads {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long transId;
	
	private Long customerCode;
	
	private Long accountNo;
	
	private Long scheduleId;
	
	private Double rateOfInterest;
	
	private Double loanAmt;
	
	private Double periodMonth;
	
	private Double principalInstallment;
	
	private Double tdsPercent;
	
	private Boolean repayOf;
	
	private Boolean open;
	
	private String scheduleType;
	
	private Boolean scheduleStatus;
	
	private String newScheduleStatus;
	
	@Temporal(TemporalType.DATE)
	private Date fromDate;
	
	@Temporal(TemporalType.DATE)
	private Date toDate;
	
	private Boolean status;
	
	@OneToMany(mappedBy = "loanScheduleHeads", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@Singular
	@JsonManagedReference
	private List<LoanScheduleDetails> loanScheduleDetails;

}
