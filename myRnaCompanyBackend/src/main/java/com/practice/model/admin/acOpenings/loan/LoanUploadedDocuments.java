/**
 * 
 */
package com.practice.model.admin.acOpenings.loan;

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
 * @author SAMEER KADGAYE
 * @version 0.1
 * 
 *          Created Date : 22/11/2021
 * 
 *          Updated Date : 24/01/2022
 * 
 *          Updated By : SUMIT KANASKAR
 *
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "Tab_LoanUploadedDocuments", schema = "rnas")
public class LoanUploadedDocuments {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long loanUploadDocId;
	private String description;

	private String fileName;
	private String filePath;
	private String fileSize;
	private String fileContentType;
}
