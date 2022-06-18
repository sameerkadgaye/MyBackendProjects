/**
 * 
 */
package com.practice.model.admin.acOpenings.deposit;

import java.util.Date;

import javax.persistence.Column;
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
@Table(name = "Tab_DepositDetails", schema = "rnas")
public class DepositDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long depositDetailsId;

	@Column(unique = true)
	private Long receiptNo;

	@Temporal(TemporalType.DATE)
	private Date depositDate;
	private Double depositAmount;
	private Integer depositYear;
	private Integer depositMonth;
	private Integer depositDay;

	private String lienFlag;
	@Temporal(TemporalType.DATE)
	private Date lienDate;
	private Long depositAccountNo;
	private String depositAccountName;

	private Double interestRate;
	private Double tdsRate;

	@Temporal(TemporalType.DATE)
	private Date maturityDate;

	private Double approximateMaturityAmount;
//	private Double interestInstallment;
	private Double principalInstallment;
	private String interestPaymentFrequency;
	private Double approximateTotalInterestPayable;
	private String interestProductFrequency;

	private String maturityOption;
	private String maturityInterestCondition;

	private Boolean status;

	@OneToOne(mappedBy = "depositDetails")
	@JsonBackReference
	private DepositAccount depositAccount;

	private String enterBy;
	@Temporal(TemporalType.DATE)
	private Date enterDate;
	private String ipAddress;
	private String macAddress;
	private String userName;
}
