/**
 * 
 */
package com.practice.model.admin.masters.customerMaster;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
@ToString(exclude = { "customerMaster" })
@Table(name = "Tab_CustomerKycDetails", schema = "rnas")
public class CustomerKycDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerKycDetailsId;

//	private Integer documentId;
	private String documentType;

	private String documentDetails;
	private String otherDocumentDetail;
	private String documentNo;

	@Temporal(TemporalType.DATE)
	private Date expiryDate;
	private String certifiedBy;

	private String compulsoryFlag;

	private Boolean status;

	private Long idCustomerMaster;

	@Lob
	private byte[] documentFile;

	private String documentFileName;
	private String documentFilePath;
	private String documentFileType;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customerMasterId")
	private CustomerMaster customerMaster;

}
