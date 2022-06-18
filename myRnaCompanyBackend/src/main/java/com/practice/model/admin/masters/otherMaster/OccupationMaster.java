package com.practice.model.admin.masters.otherMaster;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ANURAG NINAWE
 * @version 0.1
 * 
 *          Created Date : 18/01/2022
 * 
 *
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tab_Occupation_Master", schema = "rnas")
public class OccupationMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private Long  occupationId;

	private String occupationCode;

	private String occupationName;
	
	private String occupationDescription;

	private Boolean status;
	
	private String enterBy;
	@Temporal(TemporalType.DATE)
	private Date enterDate;
	private String ipAddress;
	private String macAddress;
	private String userId;
}
