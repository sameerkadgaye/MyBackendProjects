package com.practice.model.admin.acOpenings.acTransaction;

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
 *          Created Date : 02/12/2021
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
@Table(name = "Tab_AccTransaction", schema = "rnas")
public class AccTransaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long acTrnId;
	private Long customerCode;
	private Long accountNo;
	private Double amount;
	private String tranType;
	private String mode;
	private Long glId;
	private Long refNo;
	private Long chequeNo;
	private String docNo;
	@Temporal(TemporalType.DATE)
	private Date chequeDate;
	@Temporal(TemporalType.DATE)
	private Date receiptDate;
	private String approval;
	private Boolean status;
	private String enterBy;
	//@Temporal(TemporalType.DATE)
	private String enterDate;
	private String ipAddress;
	private String macAddress;
	private String userId;

}
