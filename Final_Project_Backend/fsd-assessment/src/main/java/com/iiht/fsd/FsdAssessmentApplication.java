package com.iiht.fsd;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.iiht.fsd.model.map.AddParentTaskRequestToParentTaskMap;
import com.iiht.fsd.model.map.AddProjectRequestToProjectMap;
import com.iiht.fsd.model.map.AddTaskRequestToTaskMap;
import com.iiht.fsd.model.map.AddUserRequestToUserMap;
import com.iiht.fsd.model.map.ParentTaskToParentTaskDTO;
import com.iiht.fsd.model.map.ProjectToProjectDTOMap;
import com.iiht.fsd.model.map.TaskToTaskDTOMap;
import com.iiht.fsd.model.map.UpdateProjectRequestToProjectMap;
import com.iiht.fsd.model.map.UpdateTaskRequestToTaskMap;
import com.iiht.fsd.model.map.UpdateUserRequestToUserMap;
import com.iiht.fsd.model.map.UserToUserDTOMap;

@SpringBootApplication
public class FsdAssessmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(FsdAssessmentApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {

		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		modelMapper.addMappings(new AddUserRequestToUserMap());
		modelMapper.addMappings(new UserToUserDTOMap());
		modelMapper.addMappings(new UpdateUserRequestToUserMap());

		modelMapper.addMappings(new AddProjectRequestToProjectMap());
		modelMapper.addMappings(new ProjectToProjectDTOMap());
		modelMapper.addMappings(new UpdateProjectRequestToProjectMap());

		modelMapper.addMappings(new AddParentTaskRequestToParentTaskMap());
		modelMapper.addMappings(new AddTaskRequestToTaskMap());
		modelMapper.addMappings(new ParentTaskToParentTaskDTO());
		modelMapper.addMappings(new TaskToTaskDTOMap());
		modelMapper.addMappings(new UpdateTaskRequestToTaskMap());

		return modelMapper;
	}

}
