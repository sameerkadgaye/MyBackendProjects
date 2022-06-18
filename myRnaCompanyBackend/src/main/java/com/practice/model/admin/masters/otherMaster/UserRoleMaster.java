/**
 * 
 */
package com.practice.model.admin.masters.otherMaster;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
//@ToString(exclude = {"users", "moduleModList"})
@Table(name = "Tab_userRoleMsts", schema = "rnas")
public class UserRoleMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userRoleId;

	private String userName;
	
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
//	@Singular
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "userRoleMenuId")
	private User users;
	
	
	private boolean status;

//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "userRoleMaster")

//	@OneToMany(cascade={CascadeType.ALL})
//	@Fetch(FetchMode.JOIN)
//	@JoinColumn(name="userRoleId", referencedColumnName="userRoleId")

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
//	@Singular
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "moduleFid", referencedColumnName = "userRoleId")
	private List<SelectedModule> moduleModList = new ArrayList<>();

	private String enterBy;
	@Temporal(TemporalType.DATE)
	private Date enterDate;
	private String ipAddress;
	private String macAddress;
	private String userId;

	

	/**
	 * @param userRoleId
	 * @param userName
	 * @param users
	 * @param status
	 * @param moduleModList
	 * @param enterBy
	 * @param enterDate
	 * @param ipAddress
	 * @param macAddress
	 * @param userId
	 */
	public UserRoleMaster(Integer userRoleId, String userName, User users, boolean status,
			List<SelectedModule> moduleModList, String enterBy, Date enterDate, String ipAddress, String macAddress,
			String userId) {
		super();
		this.userRoleId = userRoleId;
		this.userName = userName;
		this.users = users;
		this.status = status;
		this.moduleModList = moduleModList;
		this.enterBy = enterBy;
		this.enterDate = enterDate;
		this.ipAddress = ipAddress;
		this.macAddress = macAddress;
		this.userId = userId;
	}

	/**
	 * 
	 */
	public UserRoleMaster() {
		super();
	}

	/**
	 * @return the userRoleId
	 */
	public Integer getUserRoleId() {
		return userRoleId;
	}

	/**
	 * @param userRoleId the userRoleId to set
	 */
	public void setUserRoleId(Integer userRoleId) {
		this.userRoleId = userRoleId;
	}

	/**
	 * @return the users
	 */
	public User getUsers() {
		return users;
	}

	/**
	 * @param users the users to set
	 */
	public void setUsers(User users) {
		this.users = users;
	}

	/**
	 * @return the status
	 */
	public boolean isStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}

	/**
	 * @return the moduleModList
	 */
	public List<SelectedModule> getModuleModList() {
		return moduleModList;
	}

	/**
	 * @param moduleModList the moduleModList to set
	 */
	public void setModuleModList(List<SelectedModule> moduleModList) {
		this.moduleModList = moduleModList;
	}

	/**
	 * @return the enterBy
	 */
	public String getEnterBy() {
		return enterBy;
	}

	/**
	 * @param enterBy the enterBy to set
	 */
	public void setEnterBy(String enterBy) {
		this.enterBy = enterBy;
	}

	/**
	 * @return the enterDate
	 */
	public Date getEnterDate() {
		return enterDate;
	}

	/**
	 * @param enterDate the enterDate to set
	 */
	public void setEnterDate(Date enterDate) {
		this.enterDate = enterDate;
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
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "UserRoleMaster [userRoleId=" + userRoleId + ", userName=" + userName + ", users=" + users + ", status="
				+ status + ", moduleModList=" + moduleModList + ", enterBy=" + enterBy + ", enterDate=" + enterDate
				+ ", ipAddress=" + ipAddress + ", macAddress=" + macAddress + ", userId=" + userId + "]";
	}

	

}
