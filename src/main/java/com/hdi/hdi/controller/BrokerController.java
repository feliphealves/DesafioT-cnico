package com.hdi.hdi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hdi.hdi.dto.BrokerDTO;
import com.hdi.hdi.entities.BrokerDetail;
import com.hdi.hdi.services.BrokerService;

@RestController
public class BrokerController {

	@Autowired
	BrokerService brokerService;

	@GetMapping("/")
	public ResponseEntity<BrokerDTO> validateBroker(@RequestParam Long document) {

		BrokerDTO broker = brokerService.brokerValidation(document);

		return new ResponseEntity<BrokerDTO>(broker, HttpStatus.OK);

	}
	
	@PutMapping("/")
	public ResponseEntity<BrokerDetail> updateBroker(@RequestParam Long document) {

		BrokerDetail detail = brokerService.updateBroker(document);

		return ResponseEntity.ok(detail);
	}

}
