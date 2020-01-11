package com.iiht.fsd.model.dto;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Add User Request DTO class
 * 
 * @author Syed Habib
 * @version 1.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddUserRequest {

	@NotBlank
	private String firstName;

	@NotBlank
	private String lastName;

	@NotBlank
	private String employeeId;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

}
