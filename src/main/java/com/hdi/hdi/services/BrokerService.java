package com.hdi.hdi.services;

import com.hdi.hdi.dto.BrokerDTO;
import com.hdi.hdi.entities.Broker;
import com.hdi.hdi.entities.BrokerDetail;

public interface BrokerService {
	
	public Broker getBroker(Long document);
	public BrokerDTO brokerValidation(Long document);
	public BrokerDetail updateBroker(Long document);
	
}
