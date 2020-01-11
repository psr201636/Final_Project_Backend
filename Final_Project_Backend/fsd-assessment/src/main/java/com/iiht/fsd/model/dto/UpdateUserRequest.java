package com.iiht.fsd.model.dto;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Update User Request DTO class
 * 
 * @author Syed Habib
 * @version 1.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateUserRequest {

	@NotNull
	private Long userId;

	private String firstName;
	private String lastName;
	private String employeeId;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

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
