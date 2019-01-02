package com.consMang.master.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ColumnTransformer;

import com.consMang.common.util.CommonConstants;

@Entity(name = "UserModel")
@Table(name = "TM_USER")
public class UserModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 467623201L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID")
	private long userId;
	
	@Column(name = "LOGIN_ID")
	@ColumnTransformer(read = "AES_DECRYPT(LOGIN_ID, UNHEX('" + CommonConstants.KEY_ENC_DNC + "'))", write = "AES_ENCRYPT(?, UNHEX('" + CommonConstants.KEY_ENC_DNC + "'))")
	private String loginId;
	
	@Column(name = "PASSWORD")
	@ColumnTransformer(read = "AES_DECRYPT(PASSWORD, UNHEX('" + CommonConstants.KEY_ENC_DNC + "'))", write = "AES_ENCRYPT(?, UNHEX('" + CommonConstants.KEY_ENC_DNC + "'))")
	private String password;
	
	@Column(name = "EMAILID")
	private String emailId;
	
	@Column(name = "MOBILE_NO", length = 10)
	private String mobileNo;
	
	@Column(name = "USER_TYPE")
	private String userType;
	
	@Column(name = "USER_NAME")
	private String userName;
	
	@Column(name = "USER_STATUS")
	private String status;
	

	@Column(name = "DESIGNATION")
	private String designation;
	
	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Column(name="CREATED_ON")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar createdOn;

	/**
	 * @return the userId
	 */
	public long getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(long userId) {
		this.userId = userId;
	}

	/**
	 * @return the loginId
	 */
	public String getLoginId() {
		return loginId;
	}

	/**
	 * @param loginId the loginId to set
	 */
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
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
	 * @return the mobileNo
	 */
	public String getMobileNo() {
		return mobileNo;
	}

	/**
	 * @param mobileNo the mobileNo to set
	 */
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
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

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the createdOn
	 */
	public Calendar getCreatedOn() {
		return createdOn;
	}

	/**
	 * @param createdOn the createdOn to set
	 */
	public void setCreatedOn(Calendar createdOn) {
		this.createdOn = createdOn;
	}
	
	
	
}
