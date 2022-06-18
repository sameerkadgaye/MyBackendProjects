package com.practice.model.admin.masters.otherMaster;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
import lombok.ToString;

/**
 * The persistent class for the ad_module_mst database table.
 * 
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "ad_module_mst", schema = "rnas")
public class ModuleMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer admmModuleId;

	@Column(name = "admm_mod_source")
	private String admmModSource;

	@Column(name = "admm_module_code")
	private String admmModuleCode;

	@Column(name = "admm_module_name")
	private String admmModuleName;

	@Column(name = "admm_status")
	private Boolean admmStatus;

	@Column(name = "ip_address")
	private String ipAddress;

	@Temporal(TemporalType.DATE)
	@Column(name = "last_update")
	private Date lastUpdate;

	@Column(name = "mac_address")
	private String macAddress;

	@Column(name = "report_server_name")
	private String reportServerName;

	@Column(name = "seq_no", unique = true)
	private Integer seqNo;

	@Column(name = "user_id")
	private Integer userId;

	private String colorCode;

	private String moduleIcon;

//	@JsonBackReference
//	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	@JoinTable(name = "module_menus", joinColumns = {@JoinColumn(name="admmModuleId")}, inverseJoinColumns = {@JoinColumn(name="menuId")})
//	private Set<MenuMaster> menus = new HashSet<>();

	@JsonBackReference
	@OneToMany(mappedBy = "moduleMaster", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<MenuMaster> menuMaster;
}