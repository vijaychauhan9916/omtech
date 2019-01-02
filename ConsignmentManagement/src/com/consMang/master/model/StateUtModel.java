package com.consMang.master.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "StateUtModel")
@Table(name = "TM_STATE")
public class StateUtModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 187767777L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "STATE_ID")
	private Long stateUtId;

	@Column(name = "STATE_NAME", length = 50)
	private String stateUtName;
	
	@Column(name = "STATE_CODE", length = 2)
	private String stateUtCode;

	public Integer getTinNo() {
		return tinNo;
	}

	public void setTinNo(Integer tinNo) {
		this.tinNo = tinNo;
	}

	@Column(name = "TIN_NO", length = 2)
	private Integer tinNo;
	
	public Long getStateUtId() {
		return stateUtId;
	}

	public void setStateUtId(Long stateUtId) {
		this.stateUtId = stateUtId;
	}

	public String getStateUtName() {
		return stateUtName;
	}

	public void setStateUtName(String stateUtName) {
		this.stateUtName = stateUtName;
	}

	
	public String getStateUtCode() {
		return stateUtCode;
	}

	public void setStateUtCode(String stateUtCode) {
		this.stateUtCode = stateUtCode;
	}

	public Set<DistrictModel> getDistrictModelSet() {
		return districtModelSet;
	}

	public void setDistrictModelSet(Set<DistrictModel> districtModelSet) {
		this.districtModelSet = districtModelSet;
	}

	@OneToMany(mappedBy = "stateUtModel", cascade = CascadeType.ALL,fetch =FetchType.LAZY)
	private Set<DistrictModel> districtModelSet;
	
}
