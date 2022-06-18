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
 *          Created Date : 19/11/2021
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
@Table(name = "Tab_CustomerMaster_Address", schema = "rnas")
public class CustomerAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerAddressId;

	private String addressType;

	private String correspondenceFlag;

	private Boolean status;

	private String address;
	// private String addressOL;
	private Integer pinCode;
	private String country;

	private Integer stateId;
	private String stateName;

	private Integer districtId;
	private String districtName;

	private Integer tahasilId;
	private String tahasilName;

	private Integer villageId;
	private String villageName;

	private String phoneNo1;
	private String phoneNo2;

	private String email;

	private Long idCustomerMaster;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customerMasterId")
	private CustomerMaster customerMaster;

}
