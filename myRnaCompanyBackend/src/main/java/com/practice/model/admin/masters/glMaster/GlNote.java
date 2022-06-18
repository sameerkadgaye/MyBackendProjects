package com.practice.model.admin.masters.glMaster;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author ASHWINI SHEBE
 * @version 0.1
 * 
 *          Created Date : 26/11/2021
 * 
 *          Updated Date :
 * 
 *          Updated By :
 *
 */


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "Tab_FaNoteMst", schema = "rnas")
public class GlNote {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long noteId;
	private Integer noteCode;
	private String noteName;
	private String noteType;
	private String noteSrNo;
	private Integer userId;
	private Date lastUpdate;
	private String ipAddress;
	private String macAddress;
	private Integer companyId;
	private Integer branchId;
	
}
