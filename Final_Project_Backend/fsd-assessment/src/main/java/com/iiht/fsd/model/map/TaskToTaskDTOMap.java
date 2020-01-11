package com.iiht.fsd.model.map;

import java.time.LocalDate;

import org.modelmapper.Converter;
import org.modelmapper.PropertyMap;

import com.iiht.fsd.model.dao.Task;
import com.iiht.fsd.model.dto.TaskDTO;
import com.iiht.fsd.model.map.converter.StringLocalDateConverter;

/**
 * AddTaskRequest to Task mapping class
 * 
 * @author Syed Habib
 * @version 1.0
 */
public class TaskToTaskDTOMap extends PropertyMap<Task, TaskDTO> {

	@Override
	protected void configure() {

		map().setTaskId(source.getTaskId());
		map().setTask(source.getTask());
		map().setPriority(source.getPriority());
		map().setStatus(source.getStatus());

		Converter<LocalDate, String> dateStrConv = new StringLocalDateConverter();
		using(dateStrConv).map(source.getStartDate()).setStartDate(null);
		using(dateStrConv).map(source.getEndDate()).setEndDate(null);

		map().setParentId(source.getParentTask().getParentId());
		map().setParentTask(source.getParentTask().getParentTask());

		map().setProjectId(source.getProject().getProjectId());
		map().setProject(source.getProject().getProject());

		map().setUserId(source.getUser().getUserId());
	}

}
