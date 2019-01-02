/**
 * @author Vijay.Chauhan
 *
 */
package com.consMang.transaction.product.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity(name = "ProductMasterModel")
@Table(name = "TM_PRODUCT")
public class ProductMasterModel implements Serializable {

	private static final long serialVersionUID = 467623201L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PRODUCT_ID")
	private long productId;

	@Column(name = "PRODUCT_NAME")
	private String productName;
	
	@Column(name = "CODE")
	private String productCode;
	
	@Column(name = "RATE")
	private Double productRate;
	
	@Column(name="CREATED_ON")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar createdOn;


	@Column(name="MODIFIED_ON")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar modifiedOn;
	
	@Column(name="STATUS")
	private String status;

	/**
	 * @return the productId
	 */
	public long getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(long productId) {
		this.productId = productId;
	}

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @return the productCode
	 */
	public String getProductCode() {
		return productCode;
	}

	/**
	 * @param productCode the productCode to set
	 */
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	/**
	 * @return the productRate
	 */
	public Double getProductRate() {
		return productRate;
	}

	/**
	 * @param productRate the productRate to set
	 */
	public void setProductRate(Double productRate) {
		this.productRate = productRate;
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

	/**
	 * @return the modifiedOn
	 */
	public Calendar getModifiedOn() {
		return modifiedOn;
	}

	/**
	 * @param modifiedOn the modifiedOn to set
	 */
	public void setModifiedOn(Calendar modifiedOn) {
		this.modifiedOn = modifiedOn;
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
	

	
}
