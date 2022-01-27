package com.hdi.hdi.services;

import static com.hdi.hdi.exception.ActivedBrokerException.throwActivedBrokerError;
import static com.hdi.hdi.exception.BrokerNotFoundException.throwBrokerNotFoundError;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdi.hdi.dto.BrokerDTO;
import com.hdi.hdi.entities.Broker;
import com.hdi.hdi.entities.BrokerDetail;
import com.hdi.hdi.externalAPI.BrokerAPI;

@Service
public class BrokerServiceImpl implements BrokerService {

	@Autowired
	BrokerAPI api;

	public BrokerDTO brokerValidation(Long document) {

		BrokerDTO brokerResponse = new BrokerDTO();

		// Pegando Corretor
		Broker broker = getBroker(document);
		throwBrokerNotFoundError(broker == null, "Corretor não existe");

		// Validando Corretor
		BrokerDetail detail = api.getBrokerDetail(broker.getCode());
		throwActivedBrokerError(detail.getActive() == false, "Corretor não está ativo");

		// Retornando BrokerDTO válido
		brokerResponse.setName(broker.getName());
		brokerResponse.setDocument(broker.getDocument());
		brokerResponse.setCode(detail.getCode());
		brokerResponse.setCommissionRate(detail.getCommissionRate());
		brokerResponse.setActive(detail.getActive());

		return brokerResponse;
	}

	
	public BrokerDetail updateBroker(Long document) {
		// Pegando Corretor
		Broker broker = getBroker(document);
		throwBrokerNotFoundError(broker == null, "Corretor não existe");

		// Validando Corretor
		BrokerDetail detail = api.getBrokerDetail(broker.getCode());
		
		// Atualizando Corretor
		detail.setActive(!detail.getActive());
		api.updateBrokerStatus(detail);
		
		return detail;
	}

	public Broker getBroker(Long document) {

		for (Broker brokerTemp : api.getBrokers()) {
			if (brokerTemp.getDocument().equals(document)) {
				return brokerTemp;
			}
		}
		return null;

	}

}
