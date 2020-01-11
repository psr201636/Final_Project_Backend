package com.iiht.fsd.model.map;

import java.time.LocalDate;

import org.modelmapper.Converter;
import org.modelmapper.PropertyMap;

import com.iiht.fsd.model.dao.Task;
import com.iiht.fsd.model.dto.AddTaskRequest;
import com.iiht.fsd.model.map.converter.LocalDateConverter;

/**
 * AddTaskRequest to Task mapping class
 * 
 * @author Syed Habib
 * @version 1.0
 */
public class AddTaskRequestToTaskMap extends PropertyMap<AddTaskRequest, Task> {

	@Override
	protected void configure() {

		map().setTask(source.getTask());

		Converter<String, LocalDate> dateConv = new LocalDateConverter();
		using(dateConv).map(source.getStartDate()).setStartDate(null);
		using(dateConv).map(source.getEndDate()).setEndDate(null);

		map().setPriority(source.getPriority());
		map().setStatus(source.getStatus());

		map().getParentTask().setParentId(source.getParentId());
		map().getProject().setProjectId(source.getProjectId());
		map().getUser().setUserId(source.getUserId());
	}

}
