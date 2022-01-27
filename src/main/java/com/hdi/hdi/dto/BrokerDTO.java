package com.hdi.hdi.dto;

import java.time.LocalDate;

public class BrokerDTO {
	
	private String name;
	private Long document;
	private String code;
	private LocalDate creationDate;
	private Float commissionRate;
	private Boolean active;
	
	public BrokerDTO() {
		this.creationDate = LocalDate.now();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getDocument() {
		return document;
	}

	public void setDocument(Long document) {
		this.document = document;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}

	public Float getCommissionRate() {
		return commissionRate;
	}

	public void setCommissionRate(Float commissionRate) {
		this.commissionRate = commissionRate;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
	
	
}
