/**
 * 
 */
package com.practice.model.admin.masters.customerMaster;

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

/**
 * @author SUMIT KANASKAR
 * @version 0.1
 * 
 *          Created Date : 23/12/2021
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
@Table(name = "Tab_CustomerBankDetails", schema = "rnas")
public class CustomerBankDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerBankDetailsId;

	private String bankName;
	private String bankBranch;
	private String bankAddress;

	private Long bankAccountNo;

	private String bankIFSCCode;
	private String bankMICRCode;

	private String showStatus;
	private Boolean bankStatus;

	private Long idCustomerMaster;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customerMasterId")
	private CustomerMaster customerMaster;

}
