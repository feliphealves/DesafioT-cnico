package com.hdi.hdi.entities;

public class BrokerDetail {

	private String code;
	private Boolean active;
	private Float commissionRate;
	
	public BrokerDetail() {
		
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Float getCommissionRate() {
		return commissionRate;
	}

	public void setCommissionRate(Float commissionRate) {
		this.commissionRate = commissionRate;
	}
	
}
