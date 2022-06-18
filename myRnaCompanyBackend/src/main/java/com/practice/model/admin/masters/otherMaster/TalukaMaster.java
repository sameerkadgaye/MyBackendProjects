package com.practice.model.admin.masters.otherMaster;

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
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author ANURAG NINAWE
 * @version 0.1
 * 
 *          Created Date : 29/10/2021
 * 
 *          Updated Date : 11/09/2021
 * 
 *          Updated By : Palash Kharwade
 * 
 *          Msg : Palash (Create Relationship with district)
 *
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"districtName"})
@Table(name = "Tab_Taluka", schema = "rnas")
public class TalukaMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private Long talukaId;

	private String talukaCode;

	private String talukaName;

//	@JsonManagedReference
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "districtId")
	private DistrictMaster districtName;

	private Boolean status;
	
	private String enterBy;
	@Temporal(TemporalType.DATE)
	private Date enterDate;
	private String ipAddress;
	private String macAddress;
	private String userId;
}
