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

@Entity(name = "DistrictModel")
@Table(name = "TM_DISTRICT")
public class DistrictModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 100000878778L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DISTRICT_ID")
	private Long districtId;

	@Column(name = "DISTRICT_NAME", length = 50)
	private String districtName;
	
	
	@Column(name = "DISTRICT_CODE", length = 10)
	private String districtCode;
	
	
	@ManyToOne
	@JoinColumn(name="STATE_UT_ID")
	private StateUtModel stateUtModel;
	

	public Long getDistrictId() {
		return districtId;
	}

	public void setDistrictId(Long districtId) {
		this.districtId = districtId;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public StateUtModel getStateUtModel() {
		return stateUtModel;
	}

	public void setStateUtModel(StateUtModel stateUtModel) {
		this.stateUtModel = stateUtModel;
	}
	
	
	
	
	public String getDistrictCode() {
		return districtCode;
	}

	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}
}
