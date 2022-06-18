package com.practice.model.admin.masters.otherMaster;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ASHWINI SHEBE
 * @version 0.1
 * 
 *          Created Date : 16/11/2021
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
@Table(name = "Tab_DocMaster", schema = "rnas")
public class DocumentMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long docId;
	private String docType;
	private String docName;
	private String imgStatus;
	private String priority;
	private String compulsary;
	private Boolean status = false;
	
}
