package com.practice.model.admin.masters.otherMaster;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author DOLLY RAUT
 * @version 0.1
 * 
 *          Created Date : 11/11/2021
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


@Table(name = "Tab_PinCodeMaster", schema = "rnas")
public class PinCodeMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "pinCodeId")
	private Integer pinCodeId;
	
	@Column(name = "pinCode")
	private Integer pinCode;
	
	@Column(name = "postOfficeName")
	private String postOfficeName;
	
	@Column(name = "area")
	private String area;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "stateId")
	private String stateId;
	
	@Column(name = "stateName")
	private String stateName;
	
	@Column(name = "talukaId")
	private Integer talukaId;
	
	@Column(name = "talukaName")
	private String talukaName;
	
	@Column(name = "districtId")
	private Integer districtId;
	
	@Column(name = "districtName")
	private String districtName;
	
	@Column(name = "status")
	private Boolean status;

	@Override
	public String toString() {
		return "PinCodeMaster [pinCodeId=" + pinCodeId + ", pinCode=" + pinCode + ", postOfficeName=" + postOfficeName
				+ ", area=" + area + ", city=" + city + ", stateId=" + stateId + ", stateName=" + stateName
				+ ", talukaId=" + talukaId + ", talukaName=" + talukaName + ", districtId=" + districtId
				+ ", districtName=" + districtName + ", status=" + status + "]";
	}

}
