package com.iiht.fsd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iiht.fsd.model.dao.Project;

/**
 * Repository for PROJECT table
 * 
 * @author Syed Habib
 * @version 1.0
 */
@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {

	@Query("SELECT new Project(p.projectId, p.project, p.startDate, p.endDate, p.priority, p.user, count(t.taskId), SUM(CASE WHEN t.status = 'COMPLETE' THEN 1 ELSE 0 END)) FROM Project p LEFT JOIN Task t ON p.projectId = t.project.projectId GROUP BY p.projectId")
	public List<Project> getProjectsDetail();
}
