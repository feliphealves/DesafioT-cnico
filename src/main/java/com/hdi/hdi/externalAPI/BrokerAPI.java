package com.hdi.hdi.externalAPI;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.hdi.hdi.entities.Broker;
import com.hdi.hdi.entities.BrokerDetail;

@Component
public class BrokerAPI {

	RestTemplate template = new RestTemplate();

	// Get brokers
	public Broker[] getBrokers() {

		UriComponents uri = UriComponentsBuilder.newInstance()
				.scheme("https")
				.host("607732991ed0ae0017d6a9b0.mockapi.io")
				.path("/insurance/v1/broker")
				.build();
		
		Broker[] brokers = template.getForEntity(uri.toUriString(), Broker[].class).getBody();
		
		return brokers; 
	}
	
	public BrokerDetail getBrokerDetail(String code) {
		
		UriComponents uri = UriComponentsBuilder.newInstance()
				.scheme("https")
				.host("607732991ed0ae0017d6a9b0.mockapi.io")
				.path("/insurance/v1/brokerData/" + code)
				.build();
		
		BrokerDetail detail = template.getForEntity(uri.toUriString(), BrokerDetail.class).getBody();
		
		return detail;
	 
	}
	
	public void updateBrokerStatus(BrokerDetail detail) {
		
		UriComponents uri = UriComponentsBuilder.newInstance()
				.scheme("https")
				.host("607732991ed0ae0017d6a9b0.mockapi.io")
				.path("/insurance/v1/brokerData/" + detail.getCode())
				.build();
		Map<String, Boolean> param = new HashMap<>();
		param.put("code", detail.getActive());
		template.put(uri.toUriString(),detail,param);
		
	}
}
