package com.iiht.fsd.model.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Add Project Request DTO class
 * 
 * @author Syed Habib
 * @version 1.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddProjectRequest {

	@NotBlank
	private String project;

	private String startDate;
	private String endDate;

	@NotNull
	private Integer priority;

	@NotNull
	private Long userId;

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
