package com.iiht.fsd.model.map;

import org.modelmapper.PropertyMap;

import com.iiht.fsd.model.dao.ParentTask;
import com.iiht.fsd.model.dto.ParentTaskDTO;

/**
 * ParentTask to ParentTaskDTO mapping class
 * 
 * @author Syed Habib
 * @version 1.0
 */
public class ParentTaskToParentTaskDTO extends PropertyMap<ParentTask, ParentTaskDTO> {

	@Override
	protected void configure() {
		map().setParentId(source.getParentId());
		map().setTask(source.getParentTask());
		map().setProjectId(source.getProject().getProjectId());
	}
}
