package com.iiht.fsd.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iiht.fsd.model.dto.AddParentTaskRequest;
import com.iiht.fsd.model.dto.AddProjectRequest;
import com.iiht.fsd.model.dto.AddTaskRequest;
import com.iiht.fsd.model.dto.AddUserRequest;
import com.iiht.fsd.model.dto.ParentTaskDTO;
import com.iiht.fsd.model.dto.ProjectDTO;
import com.iiht.fsd.model.dto.Status;
import com.iiht.fsd.model.dto.TaskDTO;
import com.iiht.fsd.model.dto.UpdateProjectRequest;
import com.iiht.fsd.model.dto.UpdateTaskRequest;
import com.iiht.fsd.model.dto.UpdateUserRequest;
import com.iiht.fsd.model.dto.UserDTO;
import com.iiht.fsd.service.ProjectManagerService;

/**
 * Rest Controller class
 * 
 * @author Syed Habib
 * @version 1.0
 */
@RestController
@RequestMapping("/project-manager/v1")
public class ProjectManagerController {

	private final static Logger LOG = LoggerFactory.getLogger(ProjectManagerController.class);

	@Autowired
	private ProjectManagerService service;

	@PostMapping("/add-user")
	public ResponseEntity<Status> addUser(@Valid @RequestBody AddUserRequest addUserRequest) {

		LOG.info("add user invoked");

		service.addUser(addUserRequest);
		Status status = new Status("SUCCESS", null);

		return new ResponseEntity<>(status, HttpStatus.OK);
	}

	@GetMapping("/users")
	public List<UserDTO> getUsers() {

		LOG.info("get users invoked");

		return service.getUsers();
	}

	@PutMapping("/update-user")
	public ResponseEntity<Status> updateUser(@Valid @RequestBody UpdateUserRequest updateUserRequest) {

		LOG.info("update user invoked for userId: {}", updateUserRequest.getUserId());

		service.updateUser(updateUserRequest);
		Status status = new Status("SUCCESS", null);

		return new ResponseEntity<>(status, HttpStatus.OK);
	}

	@DeleteMapping("/users/delete/{userId}")
	public void deleteUser(@PathVariable Long userId) {

		LOG.info("delete user invoked");

		service.deleteUser(userId);
	}

	@PostMapping("/add-project")
	public ResponseEntity<Status> addProject(@Valid @RequestBody AddProjectRequest addProjectRequest) {

		LOG.info("add project invoked");

		service.addProject(addProjectRequest);
		Status status = new Status("SUCCESS", null);

		return new ResponseEntity<>(status, HttpStatus.OK);
	}

	@GetMapping("/projects")
	public List<ProjectDTO> getProjects() {

		LOG.info("get projects invoked");

		return service.getProjects();
	}

	@GetMapping("/projects/detail")
	public List<ProjectDTO> getProjectsDetail() {

		LOG.info("get projects detail invoked");

		return service.getProjectsDetail();
	}

	@PutMapping("/update-project")
	public ResponseEntity<Status> updateProject(@Valid @RequestBody UpdateProjectRequest updateProjectRequest) {

		LOG.info("update project invoked for userId: {}", updateProjectRequest.getProjectId());

		service.updateProject(updateProjectRequest);
		Status status = new Status("SUCCESS", null);

		return new ResponseEntity<>(status, HttpStatus.OK);
	}

	@PostMapping("/add-parent-task")
	public ResponseEntity<Status> addParentTask(@Valid @RequestBody AddParentTaskRequest addParentTaskRequest) {

		LOG.info("add parent task invoked");

		service.addParentTask(addParentTaskRequest);
		Status status = new Status("SUCCESS", null);

		return new ResponseEntity<>(status, HttpStatus.OK);
	}

	@PostMapping("/add-task")
	public ResponseEntity<Status> addTask(@Valid @RequestBody AddTaskRequest addTaskRequest) {

		LOG.info("add task invoked");

		service.addTask(addTaskRequest);
		Status status = new Status("SUCCESS", null);

		return new ResponseEntity<>(status, HttpStatus.OK);
	}

	@GetMapping("/parent-tasks")
	public List<ParentTaskDTO> getParentTasks() {

		LOG.info("get parent tasks invoked");

		return service.getParentTasks();
	}

	@GetMapping("/tasks")
	public List<TaskDTO> getTasks() {

		LOG.info("get tasks invoked");

		return service.getTasks();
	}

	@GetMapping("/tasks/project/{projectId}")
	public List<TaskDTO> getProjectTasks(@PathVariable Long projectId) {

		LOG.info("get project tasks invoked");

		return service.getProjectTasks(projectId);
	}

	@PutMapping("/update-task")
	public ResponseEntity<Status> updateTask(@Valid @RequestBody UpdateTaskRequest updateTaskRequest) {

		LOG.info("update task invoked for taskId: {}", updateTaskRequest.getTaskId());

		service.updateTask(updateTaskRequest);
		Status status = new Status("SUCCESS", null);

		return new ResponseEntity<>(status, HttpStatus.OK);
	}
}
