/**
 * 
 */
package com.practice.model.admin.masters.otherMaster;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author palash.kharwade
 *
 */

@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString(exclude = "menus")
@Table(name = "Tab_selectedModules", schema = "rnas")
public class SelectedModule {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer selectedModuleId;

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

	@Column(name = "seq_no")
	private Integer seqNo;

	@Column(name = "user_id")
	private Integer userId;

	private String colorCode;

	private String moduleIcon;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "Tab_select_module_menus",schema = "rnas", joinColumns = {
			@JoinColumn(name = "selectedModuleId") }, inverseJoinColumns = { @JoinColumn(name = "menuId") })
	private Set<MenuMaster> menus = new HashSet<>();

	/**
	 * @param selectedModuleId
	 * @param admmModSource
	 * @param admmModuleCode
	 * @param admmModuleName
	 * @param admmStatus
	 * @param ipAddress
	 * @param lastUpdate
	 * @param macAddress
	 * @param reportServerName
	 * @param seqNo
	 * @param userId
	 * @param colorCode
	 * @param moduleIcon
	 * @param menus
	 */
	public SelectedModule(Integer selectedModuleId, String admmModSource, String admmModuleCode, String admmModuleName,
			Boolean admmStatus, String ipAddress, Date lastUpdate, String macAddress, String reportServerName,
			Integer seqNo, Integer userId, String colorCode, String moduleIcon, Set<MenuMaster> menus) {
		super();
		this.selectedModuleId = selectedModuleId;
		this.admmModSource = admmModSource;
		this.admmModuleCode = admmModuleCode;
		this.admmModuleName = admmModuleName;
		this.admmStatus = admmStatus;
		this.ipAddress = ipAddress;
		this.lastUpdate = lastUpdate;
		this.macAddress = macAddress;
		this.reportServerName = reportServerName;
		this.seqNo = seqNo;
		this.userId = userId;
		this.colorCode = colorCode;
		this.moduleIcon = moduleIcon;
		this.menus = menus;
	}

	/**
	 * 
	 */
	public SelectedModule() {
		super();
	}

	/**
	 * @return the selectedModuleId
	 */
	public Integer getSelectedModuleId() {
		return selectedModuleId;
	}

	/**
	 * @param selectedModuleId the selectedModuleId to set
	 */
	public void setSelectedModuleId(Integer selectedModuleId) {
		this.selectedModuleId = selectedModuleId;
	}

	/**
	 * @return the admmModSource
	 */
	public String getAdmmModSource() {
		return admmModSource;
	}

	/**
	 * @param admmModSource the admmModSource to set
	 */
	public void setAdmmModSource(String admmModSource) {
		this.admmModSource = admmModSource;
	}

	/**
	 * @return the admmModuleCode
	 */
	public String getAdmmModuleCode() {
		return admmModuleCode;
	}

	/**
	 * @param admmModuleCode the admmModuleCode to set
	 */
	public void setAdmmModuleCode(String admmModuleCode) {
		this.admmModuleCode = admmModuleCode;
	}

	/**
	 * @return the admmModuleName
	 */
	public String getAdmmModuleName() {
		return admmModuleName;
	}

	/**
	 * @param admmModuleName the admmModuleName to set
	 */
	public void setAdmmModuleName(String admmModuleName) {
		this.admmModuleName = admmModuleName;
	}

	/**
	 * @return the admmStatus
	 */
	public Boolean getAdmmStatus() {
		return admmStatus;
	}

	/**
	 * @param admmStatus the admmStatus to set
	 */
	public void setAdmmStatus(Boolean admmStatus) {
		this.admmStatus = admmStatus;
	}

	/**
	 * @return the ipAddress
	 */
	public String getIpAddress() {
		return ipAddress;
	}

	/**
	 * @param ipAddress the ipAddress to set
	 */
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	/**
	 * @return the lastUpdate
	 */
	public Date getLastUpdate() {
		return lastUpdate;
	}

	/**
	 * @param lastUpdate the lastUpdate to set
	 */
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	/**
	 * @return the macAddress
	 */
	public String getMacAddress() {
		return macAddress;
	}

	/**
	 * @param macAddress the macAddress to set
	 */
	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}

	/**
	 * @return the reportServerName
	 */
	public String getReportServerName() {
		return reportServerName;
	}

	/**
	 * @param reportServerName the reportServerName to set
	 */
	public void setReportServerName(String reportServerName) {
		this.reportServerName = reportServerName;
	}

	/**
	 * @return the seqNo
	 */
	public Integer getSeqNo() {
		return seqNo;
	}

	/**
	 * @param seqNo the seqNo to set
	 */
	public void setSeqNo(Integer seqNo) {
		this.seqNo = seqNo;
	}

	/**
	 * @return the userId
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * @return the menus
	 */
	public Set<MenuMaster> getMenus() {
		return menus;
	}

	/**
	 * @param menus the menus to set
	 */
	public void setMenus(Set<MenuMaster> menus) {
		this.menus = menus;
	}

	/**
	 * @return the moduleIcon
	 */
	public String getModuleIcon() {
		return moduleIcon;
	}

	/**
	 * @param moduleIcon the moduleIcon to set
	 */
	public void setModuleIcon(String moduleIcon) {
		this.moduleIcon = moduleIcon;
	}

	/**
	 * @return the colorCode
	 */
	public String getColorCode() {
		return colorCode;
	}

	/**
	 * @param colorCode the colorCode to set
	 */
	public void setColorCode(String colorCode) {
		this.colorCode = colorCode;
	}

	@Override
	public String toString() {
		return "SelectedModule [selectedModuleId=" + selectedModuleId + ", admmModSource=" + admmModSource
				+ ", admmModuleCode=" + admmModuleCode + ", admmModuleName=" + admmModuleName + ", admmStatus="
				+ admmStatus + ", ipAddress=" + ipAddress + ", lastUpdate=" + lastUpdate + ", macAddress=" + macAddress
				+ ", reportServerName=" + reportServerName + ", seqNo=" + seqNo + ", userId=" + userId + ", colorCode="
				+ colorCode + ", moduleIcon=" + moduleIcon + ", menus=" + menus + "]";
	}

}
