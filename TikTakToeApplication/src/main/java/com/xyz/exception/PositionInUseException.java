package com.xyz.exception;

@SuppressWarnings("serial")
public class PositionInUseException extends Exception {

	public PositionInUseException() {
		super();
	}

	public PositionInUseException(String message) {
		super(message);
	}

}
