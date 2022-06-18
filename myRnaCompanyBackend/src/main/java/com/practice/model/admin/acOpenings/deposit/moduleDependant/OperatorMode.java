/**
 * 
 */
package com.practice.model.admin.acOpenings.deposit.moduleDependant;

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
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="tab_Deposit_Operator_Modes", schema = "rnas")
public class OperatorMode {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long operatorMode;
	private String operatorModeName;
	
	private Boolean status;
	private String ipAddress;
	private String macAddress;
}
