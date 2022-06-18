package com.practice.model.admin.masters.otherMaster;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

/**
 * @author Anurag Ninawe
 *
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = { "user", "userbranchList" })
@Table(name = "Tab_UserCompany", schema = "rnas")
public class UserCompany {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userCompanyId;
	private Long selectedCompanyId;

	private Boolean status;

	@OneToOne(mappedBy = "userCompany")
	@JsonBackReference
	private User user;

	@OneToMany(mappedBy = "userCompany", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@Singular
	@JsonManagedReference
	private List<UserBranch> userbranchList;

}
