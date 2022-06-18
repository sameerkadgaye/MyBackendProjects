/**
 * 
 */
package com.practice.model.admin.acOpenings.deposit;

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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author SAMEER KADGAYE
 * @version 0.1
 * 
 *          Created Date : 22/11/2021
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
@Table(name = "Tab_DepositUploadedDocuments", schema = "rnas")
public class DepositUploadedDocuments {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long despositUploadDocId;

	private String documentType; // address, other & id proof
	private String documentDetails;
	private String otherDocumentDetail;
	private String documentNo;

	@Temporal(TemporalType.DATE)
	private Date expiryDate;

	private String certifiedBy;

	private String compulsoryFlag;

	private String documentFile;
	private String documentFileName;
	private String documentFilePath;
	private String documentFileType;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "depositAccountId")
	private DepositAccount depositAccount;

	private Boolean deleteStatus;
	private String enterBy;
	@Temporal(TemporalType.DATE)
	private Date enterDate;
	private String ipAddress;
	private String macAddress;
	private String userId;
}
