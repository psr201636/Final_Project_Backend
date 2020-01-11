package com.iiht.fsd.model.dto;

/**
 * Status DTO class
 * 
 * @author Syed Habib
 * @version 1.0
 */
public class Status {

	private String status;
	private String message;

	public Status(String status, String message) {
		this.status = status;
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
