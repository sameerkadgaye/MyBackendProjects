package com.practice.model.admin.masters.otherMaster;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

/**
 * @author PALASH KHARWADE
 * @version 0.1
 * 
 *          Created Date : 29/10/2021
 * 
 *          Updated Date : 11/09/2021
 * 
 *          Updated By :
 * 
 *          Msg :
 *
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = { "stateMaster", "talukaMaster" })
@Table(name = "Tab_District", schema = "rnas")
public class DistrictMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long districtId;

	private Integer districtCode;
	private String districtName;

//	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@Singular
	@JoinColumn(name = "stateId")
	private StateMaster stateMaster;

	@JsonBackReference
	@Singular
	@OneToMany(mappedBy = "districtName", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<TalukaMaster> talukaMaster;

	public Boolean status;

	@Transient
	private int stateValue;

	private String enterBy;
	@Temporal(TemporalType.DATE)
	private Date enterDate;
	private String ipAddress;
	private String macAddress;
	private String userId;
}
