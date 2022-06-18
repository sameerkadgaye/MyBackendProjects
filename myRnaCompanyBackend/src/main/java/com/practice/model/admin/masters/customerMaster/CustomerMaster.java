package com.practice.model.admin.masters.customerMaster;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.practice.model.admin.acOpenings.deposit.DepositAccount;
import com.practice.model.admin.acOpenings.loan.LoanAccount;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

/**
 * @author SUMIT KANASKAR
 * @version 0.1
 * 
 *          Created Date : 19/11/2021
 * 
 *          Updated Date : 27/12/2021
 * 
 *          Updated By : SAMEER KADGAYE
 *
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = { "customerBankDetails", "customerAddress", "customerKycDetails", "depositAccountList",
		"loanAccountList" })
@Table(name = "Tab_CustomerMaster", schema = "rnas")
public class CustomerMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerMasterId;

	@Column(unique = true)
	// @Length(min = 6, max = 10, message = "Customer Code Contains At least 6 And
	// Max 10 Digits")
	// @Range(min = 1, message = "Customer Code Contains At least 1 Digits")
	private Long customerCode;

//	private Integer memberNo;

	@Temporal(TemporalType.DATE)
	private Date customerCreationDate;

	private String memberMaritalTitle;

	private String firstName;
	private String middleName;
	private String lastName;

	private String fullName;

	private String gender;
	private String mobileNo;

	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;

	private Long adhaarNo;
	private String panNo;
	private String voterIdNo;
	private Long rationCardNo;

	private String occupation;
	private String otherOccupation;
	private String education;

	private boolean status;

	private String enterBy;
	@Temporal(TemporalType.DATE)
	private Date enterDate;
	private String ipAddress;
	private String macAddress;
	private String username;

	@OneToMany(mappedBy = "customerMaster", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonManagedReference
	@Singular
	private List<CustomerBankDetails> customerBankDetails;

	@OneToMany(mappedBy = "customerMaster", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonManagedReference
	@Singular
	private List<CustomerAddress> customerAddress;

	@OneToMany(mappedBy = "customerMaster", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonManagedReference
	@Singular
	private List<CustomerKycDetails> customerKycDetails;

	private String signatureFileContentType;
	private String signatureFileName;
	private String signatureFilePath;
	private String signatureFileType;

	private String photoFileContentType;
	private String photoFileName;
	private String photoFilePath;
	private String photoFileType;

	@OneToMany(mappedBy = "customerMaster", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	@JsonManagedReference
	@JsonBackReference
	@Singular
	private List<DepositAccount> depositAccountList;

	@OneToMany(mappedBy = "customerMaster", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonManagedReference
	@Singular
	private List<LoanAccount> loanAccountList;
}
