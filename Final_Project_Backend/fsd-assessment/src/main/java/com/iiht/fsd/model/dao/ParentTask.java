package com.iiht.fsd.model.dao;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.domain.Persistable;

/**
 * Parent_Task entity class
 * 
 * @author Syed Habib
 * @version 1.0
 */
@Entity
public class ParentTask implements Persistable<Long> {

	@Id
	@GenericGenerator(name = "gen3", strategy = "increment")
	@GeneratedValue(generator = "gen3")
	private Long parentId;

	private String parentTask;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "project_id")
	private Project project;

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getParentTask() {
		return parentTask;
	}

	public void setParentTask(String parentTask) {
		this.parentTask = parentTask;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@Override
	public Long getId() {
		return this.parentId;
	}

	@Override
	public boolean isNew() {
		return (null == this.parentId);
	}

}
