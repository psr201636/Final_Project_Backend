package com.iiht.fsd.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.fsd.model.dao.ParentTask;
import com.iiht.fsd.model.dao.Project;
import com.iiht.fsd.model.dao.Task;
import com.iiht.fsd.model.dao.User;
import com.iiht.fsd.model.dto.AddParentTaskRequest;
import com.iiht.fsd.model.dto.AddProjectRequest;
import com.iiht.fsd.model.dto.AddTaskRequest;
import com.iiht.fsd.model.dto.AddUserRequest;
import com.iiht.fsd.model.dto.ParentTaskDTO;
import com.iiht.fsd.model.dto.ProjectDTO;
import com.iiht.fsd.model.dto.TaskDTO;
import com.iiht.fsd.model.dto.UpdateProjectRequest;
import com.iiht.fsd.model.dto.UpdateTaskRequest;
import com.iiht.fsd.model.dto.UpdateUserRequest;
import com.iiht.fsd.model.dto.UserDTO;
import com.iiht.fsd.repository.ParentTaskRepository;
import com.iiht.fsd.repository.ProjectRepository;
import com.iiht.fsd.repository.TaskRepository;
import com.iiht.fsd.repository.UserRepository;

/**
 * Project Management service class
 * 
 * @author Syed Habib
 * @version 1.0
 */
@Service
public class ProjectManagerService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	private ParentTaskRepository parentTaskRepository;

	@Autowired
	private TaskRepository taskRepository;

	/**
	 * Add User method
	 * 
	 * @param addUserRequest
	 */
	public void addUser(final AddUserRequest addUserRequest) {

		User user = modelMapper.map(addUserRequest, User.class);
		userRepository.save(user);
	}

	/**
	 * Get All users
	 * 
	 * @return List<UserDTO>
	 */
	public List<UserDTO> getUsers() {

		List<User> users = (List<User>) userRepository.findAll();

		return users.stream().map(user -> {
			return modelMapper.map(user, UserDTO.class);
		}).collect(Collectors.toList());
	}

	/**
	 * Update user method
	 * 
	 * @param updateUserRequest
	 */
	public void updateUser(final UpdateUserRequest updateUserRequest) {

		User user = modelMapper.map(updateUserRequest, User.class);
		userRepository.save(user);
	}

	/**
	 * Delete user method
	 * 
	 * @param userId
	 */
	public void deleteUser(final Long userId) {
		userRepository.deleteById(userId);
	}

	/**
	 * Add Project method
	 * 
	 * @param addProjectRequest
	 */
	public void addProject(final AddProjectRequest addProjectRequest) {

		Project project = modelMapper.map(addProjectRequest, Project.class);
		projectRepository.save(project);
	}

	/**
	 * Get All projects
	 * 
	 * @return List<ProjectDTO>
	 */
	public List<ProjectDTO> getProjects() {

		List<Project> projects = (List<Project>) projectRepository.findAll();

		return projects.stream().map(project -> {
			return modelMapper.map(project, ProjectDTO.class);
		}).collect(Collectors.toList());
	}

	/**
	 * Get All projects with detail
	 * 
	 * @return List<ProjectDTO>
	 */
	public List<ProjectDTO> getProjectsDetail() {

		List<Project> projects = (List<Project>) projectRepository.getProjectsDetail();

		return projects.stream().map(project -> {
			return modelMapper.map(project, ProjectDTO.class);
		}).collect(Collectors.toList());
	}

	/**
	 * Update project method
	 * 
	 * @param updateProjectRequest
	 */
	public void updateProject(final UpdateProjectRequest updateProjectRequest) {

		Project project = modelMapper.map(updateProjectRequest, Project.class);
		projectRepository.save(project);
	}

	/**
	 * Add Parent Task method
	 * 
	 * @param addParentTaskRequest
	 */
	public void addParentTask(final AddParentTaskRequest addParentTaskRequest) {

		ParentTask parentTask = modelMapper.map(addParentTaskRequest, ParentTask.class);
		parentTaskRepository.save(parentTask);
	}

	/**
	 * Add Task method
	 * 
	 * @param addTaskRequest
	 */
	public void addTask(final AddTaskRequest addTaskRequest) {

		Task task = modelMapper.map(addTaskRequest, Task.class);
		taskRepository.save(task);
	}

	/**
	 * Get All parent tasks
	 * 
	 * @return List<ParentTaskDTO>
	 */
	public List<ParentTaskDTO> getParentTasks() {

		List<ParentTask> parentTasks = (List<ParentTask>) parentTaskRepository.findAll();

		return parentTasks.stream().map(parentTask -> {
			return modelMapper.map(parentTask, ParentTaskDTO.class);
		}).collect(Collectors.toList());
	}

	/**
	 * Get All tasks
	 * 
	 * @return List<TaskDTO>
	 */
	public List<TaskDTO> getTasks() {

		List<Task> tasks = (List<Task>) taskRepository.findAll();

		return tasks.stream().map(task -> {
			return modelMapper.map(task, TaskDTO.class);
		}).collect(Collectors.toList());
	}

	/**
	 * Get Project tasks
	 * 
	 * @param projectId
	 * @return List<TaskDTO>
	 */
	public List<TaskDTO> getProjectTasks(final Long projectId) {

		List<Task> tasks = (List<Task>) taskRepository.findProjectTasks(projectId);

		return tasks.stream().map(task -> {
			return modelMapper.map(task, TaskDTO.class);
		}).collect(Collectors.toList());
	}

	/**
	 * Update Task method
	 * 
	 * @param updateTaskRequest
	 */
	public void updateTask(final UpdateTaskRequest updateTaskRequest) {

		Task task = modelMapper.map(updateTaskRequest, Task.class);
		taskRepository.save(task);
	}
}
