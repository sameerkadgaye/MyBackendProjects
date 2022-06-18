package com.practice.model.admin.masters.otherMaster;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

/**
 * @author ANURAG NINAWE
 * @version 0.1
 * 
 *          Created Date : 11/11/2021
 * 
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"userCompany"})
@Table(name = "Tab_User_Creation", schema = "rnas")
public class User {

//	public User(User userFront, byte[] bytes) {
//		// TODO Auto-generated constructor stub
//	}


	public User( String imgname, byte[] image) {
		super();
		
		this.imgname = imgname;
		this.image = image;
	}
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	@Column(unique = true)
	private String username;
	private String password;
	private String confirmPassword;

	private Integer mPin;

	private String firstName;
	private String middleName;
	private String lastName;

	private String userMobileNo;
	private String alternateMobileNo;

	private String userEmail;
	private String alternateEmail;

	private String useraddress;

	private String panNo;
	private Long aadharCardNo;

	
	private String occupation;
	private String otherOccupation;
	
	

	private String rol;
	
	private Integer stateId;
	
	private String  stateName;
	
	private Boolean status;

	private String imgname; //file name
	
	private String imgPath; //file name
		
	@Lob
	private byte[] image;// array of bytes, map to a BLOB
		
//	@Type(type="org.hibernate.type.BinaryType")
//	@Column(name = "image")
//	private byte[] image;
	
	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JsonManagedReference
//	@JoinColumn(name = "adcmId")
//	@Singular
//	private AdCompanyMst adCompanyMst;
		

	@OneToOne(cascade = CascadeType.ALL)
	@JsonManagedReference
	@JoinColumn(name = "userCompanyId")
	@Singular
	private UserCompany userCompany;
	
	
}
