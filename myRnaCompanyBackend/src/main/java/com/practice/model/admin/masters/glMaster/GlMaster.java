package com.practice.model.admin.masters.glMaster;

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
import lombok.ToString;

/**
 * @author ASHWINI SHEBE
 * @version 0.1
 * 
 *          Created Date : 25/11/2021
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
@Table(name = "Tab_GlMaster", schema = "rnas")
public class GlMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long glId;
	private String glType;
	private Integer groupName;
	private Integer subGroupName;
	private Integer subSubGroupName;
	private String glCode;
	private String glName;
	private Integer note;
	private Integer contraNote;
	
	@Temporal(TemporalType.DATE)
	private Date glOpenDate;
	private String glTypefilter;
	private String glStatus;
	private String subledger;
	private Boolean status;
}
