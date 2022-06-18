/**
 * 
 */
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

/**
 * @author ashitosh.tabhane
 *
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

@ToString(exclude = { "user", "branchList" })

@Table(name = "Tab_ad_company_mst", schema = "rnas")
public class AdCompanyMst {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "adcm_company_id")
	private Integer adcmId;

	@Column(name = "adcm_add")
	private String adcmAdd;

	@Column(name = "adcm_add_ho")
	private String adcmAddHo;

	@Column(name = "adcm_city")
	private String adcmCity;

	@Column(name = "adcm_city_ho")
	private String adcmCityHo;

	@Column(name = "adcm_copreg_no")
	private String adcmCopregNo;

	@Column(name = "adcm_district_id")
	private Integer adcmDistrictId;

	@Column(name = "adcm_district_id_ho")
	private Integer adcmDistrictIdHo;

	@Column(name = "adcm_esi_no")
	private String adcmEsiNo;

	@Column(name = "adcm_facreg_no")
	private String adcmFacregNo;

	@Column(name = "adcm_fax")
	private String adcmFax;

	@Column(name = "adcm_fax_ho")
	private String adcmFaxHo;

	@Column(name = "adcm_gstn_no")
	private String adcmGstnNo;

	@Column(name = "adcm_landmark")
	private String adcmLandmark;

	@Column(name = "adcm_landmark_ho")
	private String adcmLandmarkHo;

	@Column(name = "adcm_legal_name")
	private String adcmLegalName;

	@Column(name = "adcm_mailid1")
	private String adcmMailid1;

	@Column(name = "adcm_mailid1_ho")
	private String adcmMailid1Ho;

	@Column(name = "adcm_mailid2")
	private String adcmMailid2;

	@Column(name = "adcm_mailid2_ho")
	private String adcmMailid2Ho;

	@Column(name = "adcm_name")
	private String adcmName;

	@Column(name = "adcm_other_no")
	private String adcmOtherNo;

	@Column(name = "adcm_pan_no")
	private String adcmPanNo;

	@Column(name = "adcm_parent")
	private Integer adcmParent;

	@Column(name = "adcm_pf_no")
	private String adcmPfNo;

	@Column(name = "adcm_pftax_no")
	private String adcmPftaxNo;

	@Column(name = "adcm_phone1")
	private String adcmPhone1;

	@Column(name = "adcm_phone1_ho")
	private String adcmPhone1Ho;

	@Column(name = "adcm_phone2")
	private String adcmPhone2;

	@Column(name = "adcm_phone2_ho")
	private String adcmPhone2Ho;

	@Column(name = "adcm_pin")
	private Integer adcmPin;

	@Column(name = "adcm_pin_ho")
	private Integer adcmPinHo;

	@Column(name = "adcm_reg_no")
	private String adcmRegNo;

	@Column(name = "adcm_state_id")
	private Integer adcmStateId;

	@Column(name = "adcm_state_id_ho")
	private Integer adcmStateIdHo;

	@Column(name = "adcm_taluka_id")
	private Integer adcmTalukaId;

	@Column(name = "adcm_taluka_id_ho")
	private Integer adcmTalukaIdHo;

	@Column(name = "adcm_tan_no")
	private String adcmTanNo;

	@Column(name = "adcm_tin_no")
	private String adcmTinNo;

	@Column(name = "adcm_trade_name")
	private String adcmTradeName;

	@Temporal(TemporalType.DATE)
	@Column(name = "freeze_date")
	private Date freezeDate;

	@Column(name = "ip_address")
	private String ipAddress;
	
	@Column(name = "state_Name")
	private String stateName;
	
	@Column(name = "district_Name")
	private String districtName;
	
	@Column(name = "taluka_name")
	private String talukaName;
	
	@Column(name = "hostate_Name")
	private String hostateName;
	
	@Column(name = "hodistrict_Name")
	private String hodistrictName;
	
	@Column(name = "hotaluka_name")
	private String hotalukaName;

	@Temporal(TemporalType.DATE)
	@Column(name = "last_update")
	private Date lastUpdate;

	@Column(name = "mac_address")
	private String macAddress;

	@Temporal(TemporalType.DATE)
	@Column(name = "software_install_date")
	private Date softwareInstallDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "software_last_used")
	private Date softwareLastUsed;

	@Temporal(TemporalType.DATE)
	@Column(name = "software_lock_date")
	private Date softwareLockDate;

	private Boolean status;

//	@OneToOne(mappedBy = "adCompanyMst")
//	@JsonBackReference
//	private User user;

	@OneToMany(mappedBy = "adCompanyMst", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@Singular
	@JsonManagedReference
	private List<BranchMaster> branchList;

}