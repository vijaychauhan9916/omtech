package com.consMang.master.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author vijay.chauhan
 *
 */

@Entity(name = "UserProfileModel")
@Table(name = "TM_USER_PROFILE")
public class UserProfileModel implements Serializable {

	private static final long serialVersionUID = 1l;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_PROF_ID")
	private Long userProfId;

	@Column(name = "NAME")
	private String name;

	@Column(name = "ADDRESS1")
	private String address1;

	@Column(name = "ADDRESS2")
	private String address2;

	@Column(name = "PHONE_NO")
	private String phoneNo;

	@Column(name = "EMAIL_ID")
	private String emailId;

	@Column(name = "COUNTRY")
	private String county;

	@Column(name="PINCODE")
	private String pincode;
	
	@Column(name="USER_TYPE")
	private String userType; 
	
	@ManyToOne
	@JoinColumn(name = "DISTRICT_ID")
	private DistrictModel district;

	@Column(name="USER_STATUS")
	private String userStatus;

	/**
	 * @return the userProfId
	 */
	public Long getUserProfId() {
		return userProfId;
	}

	/**
	 * @param userProfId the userProfId to set
	 */
	public void setUserProfId(Long userProfId) {
		this.userProfId = userProfId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the address1
	 */
	public String getAddress1() {
		return address1;
	}

	/**
	 * @param address1 the address1 to set
	 */
	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	/**
	 * @return the address2
	 */
	public String getAddress2() {
		return address2;
	}

	/**
	 * @param address2 the address2 to set
	 */
	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	/**
	 * @return the phoneNo
	 */
	public String getPhoneNo() {
		return phoneNo;
	}

	/**
	 * @param phoneNo the phoneNo to set
	 */
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/**
	 * @return the county
	 */
	public String getCounty() {
		return county;
	}

	/**
	 * @param county the county to set
	 */
	public void setCounty(String county) {
		this.county = county;
	}

	/**
	 * @return the pincode
	 */
	public String getPincode() {
		return pincode;
	}

	/**
	 * @param pincode the pincode to set
	 */
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	/**
	 * @return the userType
	 */
	public String getUserType() {
		return userType;
	}

	/**
	 * @param userType the userType to set
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}

	/**
	 * @return the district
	 */
	public DistrictModel getDistrict() {
		return district;
	}

	/**
	 * @param district the district to set
	 */
	public void setDistrict(DistrictModel district) {
		this.district = district;
	}

	/**
	 * @return the userStatus
	 */
	public String getUserStatus() {
		return userStatus;
	}

	/**
	 * @param userStatus the userStatus to set
	 */
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	
}
