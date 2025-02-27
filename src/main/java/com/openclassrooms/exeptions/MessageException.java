package com.openclassrooms.exeptions;

public class MessageException {
	
	private String message;

	public MessageException(String errors) {
		this.message = errors;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
