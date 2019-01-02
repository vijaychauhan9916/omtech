package com.consMang.master.model;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "EnquiryModel")
@Table(name = "TT_ENQUIRY")
public class EnquiryModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ENQUIRY_ID")
	private Long enquiryId;
	
	@Column(name = "SUBJECT")
	private String subject;
	
	@Column(name = "ENQUIRY_TEXT",length=1500)
	private String enquiryText;
	
	private Calendar createdOn;
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="AUTHORITY_ID")
	private UserModel raisedBy;
	
	@Column(name = "ENQUIRY_REPLY",length=1500)
	private String replyText;
	
	private String emailId;
	
	@Column(name = "FROM_ADDRESS")
	private String fromAddress;
	
	@Column(name = "CC_ADDRESS",length=500)
	private String ccAddress;
	
	@Column(name = "BCC_ADDRESS",length=500)
	private String bccAddress;
	
	@Column(name = "ENQUIRY_NO")
	private String enquiryNo;
	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public Long getEnquiryId() {
		return enquiryId;
	}
	public void setEnquiryId(Long enquiryId) {
		this.enquiryId = enquiryId;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getEnquiryText() {
		return enquiryText;
	}
	public void setEnquiryText(String enquiryText) {
		this.enquiryText = enquiryText;
	}
	public Calendar getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Calendar createdOn) {
		this.createdOn = createdOn;
	}
	public UserModel getRaisedBy() {
		return raisedBy;
	}
	public void setRaisedBy(UserModel raisedBy) {
		this.raisedBy = raisedBy;
	}
	public String getReplyText() {
		return replyText;
	}
	public void setReplyText(String replyText) {
		this.replyText = replyText;
	}
	public String getCcAddress() {
		return ccAddress;
	}
	public void setCcAddress(String ccAddress) {
		this.ccAddress = ccAddress;
	}
	public String getBccAddress() {
		return bccAddress;
	}
	public void setBccAddress(String bccAddress) {
		this.bccAddress = bccAddress;
	}
	public String getFromAddress() {
		return fromAddress;
	}
	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}
	public String getEnquiryNo() {
		return enquiryNo;
	}
	public void setEnquiryNo(String enquiryNo) {
		this.enquiryNo = enquiryNo;
	}
	
	
	
	
}
