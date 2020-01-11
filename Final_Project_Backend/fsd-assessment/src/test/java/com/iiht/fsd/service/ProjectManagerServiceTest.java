package com.iiht.fsd.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

import com.iiht.fsd.model.dao.ParentTask;
import com.iiht.fsd.model.dao.Project;
import com.iiht.fsd.model.dao.Task;
import com.iiht.fsd.model.dao.User;
import com.iiht.fsd.model.dto.AddParentTaskRequest;
import com.iiht.fsd.model.dto.AddProjectRequest;
import com.iiht.fsd.model.dto.AddTaskRequest;
import com.iiht.fsd.model.dto.AddUserRequest;
import com.iiht.fsd.model.dto.UpdateProjectRequest;
import com.iiht.fsd.model.dto.UpdateTaskRequest;
import com.iiht.fsd.model.dto.UpdateUserRequest;
import com.iiht.fsd.repository.ParentTaskRepository;
import com.iiht.fsd.repository.ProjectRepository;
import com.iiht.fsd.repository.TaskRepository;
import com.iiht.fsd.repository.UserRepository;

/**
 * Service Test class
 * 
 * @author Syed Habib
 * @version 1.0
 */
@RunWith(MockitoJUnitRunner.class)
public class ProjectManagerServiceTest {

	@Mock
	private ProjectRepository projectRepository;

	@Mock
	private UserRepository userRepository;

	@Mock
	private ParentTaskRepository parentTaskRepository;

	@Mock
	private TaskRepository taskRepository;

	@Mock
	private ModelMapper modelMapper;

	@InjectMocks
	private ProjectManagerService service;

	@Before
	public void setUp() throws SQLException {
		Mockito.when(projectRepository.findAll()).thenReturn(getAllProjectsMockReturn());
		Mockito.when(userRepository.findAll()).thenReturn(getAllUsersMockReturn());
		Mockito.when(parentTaskRepository.findAll()).thenReturn(getAllParentTasksMockReturn());
		Mockito.when(taskRepository.findAll()).thenReturn(getAllTasksMockReturn());
	}

	@Test
	public void testGetProjects() {

		int actSize = service.getProjects().size();
		int expSize = 2;

		assertThat(actSize).isEqualTo(expSize);
	}

	@Test
	public void testGetUsers() {

		int actSize = service.getUsers().size();
		int expSize = 1;

		assertThat(actSize).isEqualTo(expSize);
	}

	@Test
	public void testGetParentTasks() {

		int actSize = service.getParentTasks().size();
		int expSize = 1;

		assertThat(actSize).isEqualTo(expSize);
	}

	@Test
	public void testGetTasks() {

		int actSize = service.getTasks().size();
		int expSize = 1;

		assertThat(actSize).isEqualTo(expSize);
	}

	@Test
	public void testAddUser() {

		AddUserRequest addUserRequest = new AddUserRequest();
		addUserRequest.setFirstName("Syed");
		addUserRequest.setLastName("Habib");
		addUserRequest.setEmployeeId("IIHT1007");

		service.addUser(addUserRequest);
	}

	@Test
	public void testUpdateUser() {

		UpdateUserRequest updateUserRequest = new UpdateUserRequest();
		updateUserRequest.setUserId(1L);
		updateUserRequest.setFirstName("Syed");
		updateUserRequest.setLastName("Habib");
		updateUserRequest.setEmployeeId("IIHT1007");

		service.updateUser(updateUserRequest);
	}

	@Test
	public void testDeleteUser() {

		service.deleteUser(1L);
	}

	@Test
	public void testAddProject() {

		AddProjectRequest addProjectRequest = new AddProjectRequest();
		addProjectRequest.setProject("FSE");
		addProjectRequest.setStartDate("2019-07-15");
		addProjectRequest.setEndDate("2019-12-22");
		addProjectRequest.setPriority(1);
		addProjectRequest.setUserId(1L);

		service.addProject(addProjectRequest);
	}

	@Test
	public void testUpdateProject() {

		UpdateProjectRequest updateProjectRequest = new UpdateProjectRequest();
		updateProjectRequest.setProjectId(1L);
		updateProjectRequest.setProject("FSE");
		updateProjectRequest.setStartDate("2019-07-15");
		updateProjectRequest.setEndDate("2019-12-22");
		updateProjectRequest.setPriority(1);
		updateProjectRequest.setUserId(1L);

		service.updateProject(updateProjectRequest);
	}

	@Test
	public void testAddParentTask() {

		AddParentTaskRequest addParentTaskRequest = new AddParentTaskRequest();
		addParentTaskRequest.setProjectId(1L);
		addParentTaskRequest.setTask("UI Build");

		service.addParentTask(addParentTaskRequest);
	}

	@Test
	public void testAddTask() {

		AddTaskRequest addTaskRequest = new AddTaskRequest();
		addTaskRequest.setTask("modal component");
		addTaskRequest.setParentId(1L);
		addTaskRequest.setPriority(10);
		addTaskRequest.setStartDate("2019-12-15");
		addTaskRequest.setEndDate("2019-12-20");
		addTaskRequest.setUserId(1L);
		addTaskRequest.setProjectId(1L);
		addTaskRequest.setStatus("IN PROGRESS");

		service.addTask(addTaskRequest);
	}

	@Test
	public void testUpdateTask() {

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

		service.updateTask(updateTaskRequest);
	}

	public List<Project> getAllProjectsMockReturn() {

		Project proj1 = new Project();
		proj1.setProjectId(1L);
		proj1.setProject("FSE");
		proj1.setPriority(5);
		proj1.setStartDate(LocalDate.now());
		proj1.setEndDate(LocalDate.now());

		Project proj2 = new Project();
		proj2.setProjectId(2L);
		proj2.setProject("Capsule");
		proj2.setPriority(15);
		proj1.setStartDate(LocalDate.now());
		proj1.setEndDate(LocalDate.now());

		List<Project> projects = Arrays.asList(proj1, proj2);
		return projects;
	}

	public List<User> getAllUsersMockReturn() {

		User user = new User();
		user.setUserId(1L);
		user.setFirstName("Syed");
		user.setLastName("Habib");
		user.setEmployeeId("IIHT1007");

		List<User> users = Arrays.asList(user);
		return users;
	}

	public List<ParentTask> getAllParentTasksMockReturn() {

		ParentTask parentTask = new ParentTask();
		parentTask.setParentId(1L);
		parentTask.setParentTask("Assessment");

		List<ParentTask> parentTasks = Arrays.asList(parentTask);
		return parentTasks;
	}

	public List<Task> getAllTasksMockReturn() {

		Task task = new Task();
		task.setTaskId(1L);
		task.setTask("Backend");
		task.setStartDate(LocalDate.now());
		task.setEndDate(LocalDate.now());
		task.setPriority(20);

		List<Task> parentTasks = Arrays.asList(task);
		return parentTasks;
	}
}
