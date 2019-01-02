package com.consMang.transaction.product.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author vijay.chauhan
 *
 */
@Entity(name="PackingTypeModel")
@Table(name="TM_PACKING_TYPE")
public class PackingTypeModel implements Serializable{
	
	private static final long serialVersionUID = 1l;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "PACKING_TYPE_ID")
	private Long packingTypeId;

	@Column(name="CODE")
	private String code;
	
	@Column(name="DESCRIPTION")
	private String description;

	public Long getPackingTypeId() {
		return packingTypeId;
	}

	public void setPackingTypeId(Long packingTypeId) {
		this.packingTypeId = packingTypeId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
