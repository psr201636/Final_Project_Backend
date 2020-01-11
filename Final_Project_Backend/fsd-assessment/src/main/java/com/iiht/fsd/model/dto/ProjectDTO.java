package com.iiht.fsd.model.dto;

/**
 * Project DTO class
 * 
 * @author Syed Habib
 * @version 1.0
 */
public class ProjectDTO {

	private Long projectId;
	private String project;
	private String startDate;
	private String endDate;
	private Integer priority;
	private Long userId;
	private Integer taskCount;
	private Integer completeCount;

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

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

	public Integer getTaskCount() {
		return taskCount;
	}

	public void setTaskCount(Integer taskCount) {
		this.taskCount = taskCount;
	}

	public Integer getCompleteCount() {
		return completeCount;
	}

	public void setCompleteCount(Integer completeCount) {
		this.completeCount = completeCount;
	}

}
