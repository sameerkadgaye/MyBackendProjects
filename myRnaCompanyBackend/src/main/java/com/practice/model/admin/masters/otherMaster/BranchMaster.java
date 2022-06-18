/**
 * 
 */
package com.practice.model.admin.masters.otherMaster;

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
 * @author ASHWINI SHEBE
 * @version 0.1
 * 
 *          Created Date : 11/11/2021
 * 
 *          Updated Date :
 * 
 *          Updated By : Anurag Ninawe
 *
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = { "adCompanyMst"})
@Table(name = "Tab_BranchMaster", schema = "rnas")
public class BranchMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long branchId;
	private String companyName;
	private String branchName;
	private String gstInNo;
	private String registrationNo;
	private String branchAddress;
	private String branchCity;
	private String landmark;
	private String taluka;
	private String district;
	private String state;
	private Integer pinCode;
	private Integer faxNo;
	private Long phoneNo;
	private Long mobileNo;
	private String emailId;
	private String altEmail;
	private Boolean status;


	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "adcmId")
	private AdCompanyMst adCompanyMst;
	

}
