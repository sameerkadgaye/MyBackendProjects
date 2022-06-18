/**
 * 
 */
package com.practice.model.admin.acOpenings.deposit;

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
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.JsonNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
@ToString
@Table(name = "Tab_DepositOperatorDetails", schema = "rnas")
public class DepositOperatorDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long depositOperatorDetailsId;

	// Particulars of the Applicant / Operator Starts
	@Transient
	private JsonNode operationModeValueObj;
	private String operationModeValue;
	private String operationMode;
	//private Long memberNo;
	private String operatorName;
	private String addressDetails;
	//private Integer signatureId;
	private Long signatureId;
	private String activeFlag;
	private String signatureAuthority;
	private String signatureMustFlag;
	// Particulars of the Applicant / Operator Ends

	@JsonBackReference
	//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "depositAccountId")
	private DepositAccount depositAccount;

	private Boolean status;
	
	private String enterBy;
	@Temporal(TemporalType.DATE)
	private Date enterDate;
	private String ipAddress;
	private String macAddress;
	private String username;
}
