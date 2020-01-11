package com.iiht.fsd.model.map;

import org.modelmapper.PropertyMap;

import com.iiht.fsd.model.dao.ParentTask;
import com.iiht.fsd.model.dto.AddParentTaskRequest;

/**
 * AddParentTaskRequest to ParentTask mapping class
 * 
 * @author Syed Habib
 * @version 1.0
 */
public class AddParentTaskRequestToParentTaskMap extends PropertyMap<AddParentTaskRequest, ParentTask> {

	@Override
	protected void configure() {

		map().setParentTask(source.getTask());
		map().getProject().setProjectId(source.getProjectId());
	}

}
