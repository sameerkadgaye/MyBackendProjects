package com.practice.model.admin.masters.otherMaster;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = { "districtMaster" })
@Table(name = "Tab_StateMaster", schema = "rnas")
public class StateMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long stateId;
	private String stateName;
	private Integer stateGstCode;
	private String country;

	@OneToMany(mappedBy = "stateMaster", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonBackReference
	@Singular
	private List<DistrictMaster> districtMaster;

	public Boolean status;
	private String enterBy;
	@Temporal(TemporalType.DATE)
	private Date enterDate;
	private String ipAddress;
	private String macAddress;
	private String userId;
}
