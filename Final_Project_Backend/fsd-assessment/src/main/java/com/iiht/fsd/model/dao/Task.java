package com.iiht.fsd.model.dao;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.domain.Persistable;

/**
 * TASK entity class
 * 
 * @author Syed Habib
 * @version 1.0
 */
@Entity
@DynamicUpdate
public class Task implements Persistable<Long> {

	@Id
	@GenericGenerator(name = "gen4", strategy = "increment")
	@GeneratedValue(generator = "gen4")
	private Long taskId;

	private String task;
	private LocalDate startDate;
	private LocalDate endDate;
	private Integer priority;
	private String status;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "parent_id")
	private ParentTask parentTask;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "project_id")
	private Project project;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User user;

	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
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

	public ParentTask getParentTask() {
		return parentTask;
	}

	public void setParentTask(ParentTask parentTask) {
		this.parentTask = parentTask;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	@Override
	public Long getId() {
		return this.taskId;
	}

	@Override
	public boolean isNew() {
		return (null == this.taskId);
	}
}
