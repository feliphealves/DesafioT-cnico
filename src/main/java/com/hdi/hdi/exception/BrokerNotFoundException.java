package com.hdi.hdi.exception;

public class BrokerNotFoundException extends RuntimeException  {

	private static final long serialVersionUID = 1L;

	public BrokerNotFoundException(String msg) {
		super(msg);
	}
	
	public static void throwBrokerNotFoundError(Boolean condition, String msg) {
		if (condition) {
			throw new BrokerNotFoundException(msg);
		}
	}
	
}
