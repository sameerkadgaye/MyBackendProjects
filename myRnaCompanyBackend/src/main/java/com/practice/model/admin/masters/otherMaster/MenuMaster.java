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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
@ToString(exclude = { "modules", "moduleMaster" })
@Table(name = "Tab_menu_mst", schema = "rnas")
public class MenuMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer menuId;

	private Integer seqno;

	private String menuName;

	@Column(unique = true)
	private String path;

	private boolean selectMenu;

	private boolean status;

	private String menuIcon;

	@JsonBackReference
	@Singular
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "menus")
	private Set<SelectedModule> modules = new HashSet<>();

//	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne(fetch = FetchType.EAGER)
//	@JsonManagedReference
	@Singular
	@JoinColumn(name = "admmModuleId")
	private ModuleMaster moduleMaster;

	private String enterBy;
	@Temporal(TemporalType.DATE)
	private Date enterDate;

	private String ipAddress;
	private String macAddress;
	private String userId;
}
