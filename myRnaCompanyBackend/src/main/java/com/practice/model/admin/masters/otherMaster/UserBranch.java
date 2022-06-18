package com.practice.model.admin.masters.otherMaster;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author ANURAG NINAWE
 * 
 *         Created Date : 29/11/2021
 *
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = { "userCompany" })
@Table(name = "Tab_UserBranch", schema = "rnas")
public class UserBranch {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userBranchId;
	private Long selectBranchId;
	private Boolean status;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userCompanyId")
	private UserCompany userCompany;

}
