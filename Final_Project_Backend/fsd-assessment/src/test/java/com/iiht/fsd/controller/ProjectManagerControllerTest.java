package com.iiht.fsd.controller;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
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
import com.iiht.fsd.service.ProjectManagerService;

/**
 * 
 * @author Syed Habib
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@WebMvcTest
public class ProjectManagerControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ProjectManagerService service;

	@Autowired
	private ObjectMapper mapper;

	@Test
	public void testGetProjects() throws Exception {

		// given
		ProjectDTO project = new ProjectDTO();
		project.setProjectId(1L);
		project.setProject("FSE");
		project.setPriority(5);

		List<ProjectDTO> projects = Arrays.asList(project);
		given(service.getProjects()).willReturn(projects);

		// when + then
		// @formatter:off

		this.mockMvc.perform(get("/project-manager/v1/projects"))
					.andExpect(content().json("[{'projectId': 1,'project': 'FSE';'priority': 5}]"));
		// @formatter:on;
	}

	@Test
	public void testGetParentTasks() throws Exception {

		// given
		ParentTaskDTO parentTask = new ParentTaskDTO();
		parentTask.setParentId(1L);
		parentTask.setProjectId(1L);
		parentTask.setTask("UI Build");

		List<ParentTaskDTO> parentTasks = Arrays.asList(parentTask);
		given(service.getParentTasks()).willReturn(parentTasks);

		// when + then
		// @formatter:off
		this.mockMvc.perform(get("/project-manager/v1/parent-tasks"))
					.andExpect(content().json("[{'parentId': 1,'task': 'UI Build';'projectId': 1}]"));
		// @formatter:on
	}

	@Test
	public void testGetTasks() throws Exception {

		// given
		TaskDTO task = new TaskDTO();
		task.setTaskId(1L);
		task.setParentId(1L);
		task.setProjectId(1L);
		task.setTask("modal component");

		List<TaskDTO> tasks = Arrays.asList(task);
		given(service.getTasks()).willReturn(tasks);

		// when + then
		// @formatter:off
		this.mockMvc.perform(get("/project-manager/v1/tasks"))
					.andExpect(content().json("[{'taskId': 1,'parentId': 1,'task': 'modal component','projectId': 1}]"));
		// @formatter:on
	}

	@Test
	public void testGetUsess() throws Exception {

		// given
		UserDTO user = new UserDTO();
		user.setFirstName("Syed");
		user.setLastName("Habib");
		user.setUserId(1L);
		user.setEmployeeId("IIHT1007");

		List<UserDTO> users = Arrays.asList(user);
		given(service.getUsers()).willReturn(users);

		// when + then
		// @formatter:off
		this.mockMvc.perform(get("/project-manager/v1/users"))
					.andExpect(content().json("[{'userId': 1,'employeeId': 'IIHT1007','firstName': 'Syed','lastName': 'Habib'}]"));
		// @formatter:on
	}

	@Test
	public void testAddUser() throws Exception {

		AddUserRequest addUserRequest = new AddUserRequest();
		addUserRequest.setFirstName("Syed");
		addUserRequest.setLastName("Habib");
		addUserRequest.setEmployeeId("IIHT1007");

		String json = mapper.writeValueAsString(addUserRequest);

		// when + then
		// @formatter:off
		this.mockMvc.perform(post("/project-manager/v1/add-user")
			       .contentType(MediaType.APPLICATION_JSON)
			       .content(json)
			       .accept(MediaType.APPLICATION_JSON))
			       .andExpect(status().isOk());
		// @formatter:on
	}

	@Test
	public void testAddProject() throws Exception {

		AddProjectRequest addProjectRequest = new AddProjectRequest();
		addProjectRequest.setProject("FSE");
		addProjectRequest.setStartDate("2019-07-15");
		addProjectRequest.setEndDate("2019-12-22");
		addProjectRequest.setPriority(1);
		addProjectRequest.setUserId(1L);

		String json = mapper.writeValueAsString(addProjectRequest);

		// when + then
		// @formatter:off
		this.mockMvc.perform(post("/project-manager/v1/add-project")
			       .contentType(MediaType.APPLICATION_JSON)
			       .content(json)
			       .accept(MediaType.APPLICATION_JSON))
			       .andExpect(status().isOk());
		// @formatter:on
	}

	@Test
	public void addParentTask() throws Exception {

		AddParentTaskRequest addParentTaskRequest = new AddParentTaskRequest();
		addParentTaskRequest.setProjectId(1L);
		addParentTaskRequest.setTask("UI Build");

		String json = mapper.writeValueAsString(addParentTaskRequest);

		// when + then
		// @formatter:off
		this.mockMvc.perform(post("/project-manager/v1/add-parent-task")
			       .contentType(MediaType.APPLICATION_JSON)
			       .content(json)
			       .accept(MediaType.APPLICATION_JSON))
			       .andExpect(status().isOk());
		// @formatter:on
	}

	@Test
	public void addTask() throws Exception {

		AddTaskRequest addTaskRequest = new AddTaskRequest();
		addTaskRequest.setTask("modal component");
		addTaskRequest.setParentId(1L);
		addTaskRequest.setPriority(10);
		addTaskRequest.setStartDate("2019-12-15");
		addTaskRequest.setEndDate("2019-12-20");
		addTaskRequest.setUserId(1L);
		addTaskRequest.setProjectId(1L);
		addTaskRequest.setStatus("IN PROGRESS");

		String json = mapper.writeValueAsString(addTaskRequest);

		// when + then
		// @formatter:off
		this.mockMvc.perform(post("/project-manager/v1/add-task")
			       .contentType(MediaType.APPLICATION_JSON)
			       .content(json)
			       .accept(MediaType.APPLICATION_JSON))
			       .andExpect(status().isOk());
		// @formatter:on
	}

	@Test
	public void deleteUser() throws Exception {

		// when + then
		// @formatter:off
		this.mockMvc.perform(delete("/project-manager/v1/users/delete/{userId}", 11)
					.accept(MediaType.APPLICATION_JSON));
		// @formatter:on
	}

	@Test
	public void testUpdateUser() throws Exception {

		UpdateUserRequest updateUserRequest = new UpdateUserRequest();
		updateUserRequest.setUserId(1L);
		updateUserRequest.setFirstName("Syed");
		updateUserRequest.setLastName("Habib");
		updateUserRequest.setEmployeeId("IIHT1007");

		String json = mapper.writeValueAsString(updateUserRequest);

		// when + then
		// @formatter:off
		this.mockMvc.perform(put("/project-manager/v1/update-user")
			       .contentType(MediaType.APPLICATION_JSON)
			       .content(json)
			       .accept(MediaType.APPLICATION_JSON));
		// @formatter:on
	}

	@Test
	public void testUpdateProject() throws Exception {

		UpdateProjectRequest updateProjectRequest = new UpdateProjectRequest();
		updateProjectRequest.setProjectId(1L);
		updateProjectRequest.setProject("FSE");
		updateProjectRequest.setStartDate("2019-07-15");
		updateProjectRequest.setEndDate("2019-12-22");
		updateProjectRequest.setPriority(1);
		updateProjectRequest.setUserId(1L);

		String json = mapper.writeValueAsString(updateProjectRequest);

		// when + then
		// @formatter:off
		this.mockMvc.perform(put("/project-manager/v1/update-project")
			       .contentType(MediaType.APPLICATION_JSON)
			       .content(json)
			       .accept(MediaType.APPLICATION_JSON));
		// @formatter:on
	}

	@Test
	public void updateTask() throws Exception {

		UpdateTaskRequest updateTaskRequest = new UpdateTaskRequest();
		updateTaskRequest.setTaskId(1L);
		updateTaskRequest.setTask("modal component");
		updateTaskRequest.setParentId(1L);
		updateTaskRequest.setPriority(10);
		updateTaskRequest.setStartDate("2019-12-15");
		updateTaskRequest.setEndDate("2019-12-20");
		updateTaskRequest.setUserId(1L);
		updateTaskRequest.setProjectId(1L);
		updateTaskRequest.setStatus("IN PROGRESS");

		String json = mapper.writeValueAsString(updateTaskRequest);

		// when + then
		// @formatter:off
		this.mockMvc.perform(put("/project-manager/v1/update-task")
			       .contentType(MediaType.APPLICATION_JSON)
			       .content(json)
			       .accept(MediaType.APPLICATION_JSON))
			       .andExpect(status().isOk());
		// @formatter:on
	}
}
