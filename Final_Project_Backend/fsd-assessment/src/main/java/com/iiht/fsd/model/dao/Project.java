package com.iiht.fsd.model.dao;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.domain.Persistable;

/**
 * Project entity class
 * 
 * @author Syed Habib
 * @version 1.0
 */
@Entity
@DynamicUpdate
public class Project implements Persistable<Long> {

	@Id
	@GenericGenerator(name = "gen2", strategy = "increment")
	@GeneratedValue(generator = "gen2")
	private Long projectId;

	private String project;
	private LocalDate startDate;
	private LocalDate endDate;
	private Integer priority;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User user;

	@Transient
	private Integer taskCount;

	@Transient
	private Integer completeCount;

	public Project() {
	}

	public Project(Long projectId, String project, LocalDate startDate, LocalDate endDate, Integer priority, User user, Long taskCount,
			Long completeCount) {
		this.projectId = projectId;
		this.project = project;
		this.startDate = startDate;
		this.endDate = endDate;
		this.priority = priority;
		this.user = user;
		this.taskCount = (null == taskCount) ? null : Math.toIntExact(taskCount);
		this.completeCount = (null == completeCount) ? null : Math.toIntExact(completeCount);
	}

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	@Override
	public Long getId() {
		return this.projectId;
	}

	@Override
	public boolean isNew() {
		return (null == this.projectId);
	}
}
