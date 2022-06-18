package com.practice.model.admin.masters.glMaster;

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
@Table(name = "Tab_GlGroupMaster", schema = "rnas")
public class GlGroupMaster {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long groupId;
	private String groupCode;
	private String groupName;
	private String groupType;
	private String groupStatus;
	private Boolean status;
}
