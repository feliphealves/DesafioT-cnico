package com.hdi.hdi.exception;

public class ActivedBrokerException extends RuntimeException  {

	private static final long serialVersionUID = 1L;

	public ActivedBrokerException(String msg) {
		super(msg);
	}
	
	public static void throwActivedBrokerError(Boolean condition, String msg) {
		if (condition) {
			throw new ActivedBrokerException(msg);
		}
	}
	
	
	
	
}