package com.iiht.fsd.model.dto;

/**
 * Parent Task DTO class
 * 
 * @author Syed Habib
 * @version 1.0
 */
public class ParentTaskDTO {

	private Long parentId;
	private String task;
	private Long projectId;

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

}
