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

/**
 * @author ANURAG NINAWE
 * @version 0.1
 * 
 *          Created Date : 30/12/2021
 * 
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Tab_Recovery_Receipt", schema = "rnas")
public class RecoveryReceipt {
	
   	@Id
   	@GeneratedValue(strategy = GenerationType.IDENTITY)
   	private Long customerId;
   	private long customerCode;
	
//	private Long acTrnId;
//	private Long acId;
   	
	private Long accountNo;
	private String customerName;
	private String principalAmount;
	
	@Temporal(TemporalType.DATE)
	private Date installmentDueDate;
	
	
	private String installmentAmount;
	private long recoveryAmount;
	private long remainingAmount;
	private String balance;
	private String mode;
	private String referenceNumber;
	private String chequeOrDDNumber;
	
	@Temporal(TemporalType.DATE)
	private Date recoveryDate;
	
	private String approval;
	
	
	private String tranType;
//	private Integer chequeNo;
	private Date receiptDate;
	private String docNo;
	@Temporal(TemporalType.DATE)
	private Date chequeDate;
	
	
	
	private Boolean status;
	private String enterBy;
	private String enterDate;
	private String ipAddress;
	private String macAddress;
	private String userId;
	
	
}
