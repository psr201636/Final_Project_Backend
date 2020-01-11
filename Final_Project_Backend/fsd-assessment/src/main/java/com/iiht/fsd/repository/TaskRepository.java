package com.iiht.fsd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iiht.fsd.model.dao.Task;

/**
 * Repository for TASK table
 * 
 * @author Syed Habib
 * @version 1.0
 */
@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {

	@Query("SELECT t FROM Task t WHERE t.project.projectId = :projectId")
	public List<Task> findProjectTasks(@Param("projectId") Long projectId);
}
