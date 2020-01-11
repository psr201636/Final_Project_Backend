package com.iiht.fsd.model.dto;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Add Task Request DTO class
 * 
 * @author Syed Habib
 * @version 1.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddTaskRequest {

	@NotNull
	private String task;

	private Long parentId;

	@NotNull
	private Long projectId;

	@NotNull
	private Long userId;

	@NotNull
	private String startDate;

	@NotNull
	private String endDate;

	@NotNull
	private Integer priority;

	@NotNull
	private String status;

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
