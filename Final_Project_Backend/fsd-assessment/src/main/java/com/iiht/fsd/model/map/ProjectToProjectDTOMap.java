package com.iiht.fsd.model.map;

import java.time.LocalDate;

import org.modelmapper.Converter;
import org.modelmapper.PropertyMap;

import com.iiht.fsd.model.dao.Project;
import com.iiht.fsd.model.dto.ProjectDTO;
import com.iiht.fsd.model.map.converter.StringLocalDateConverter;

/**
 * Project to ProjectDTO mapping class
 * 
 * @author Syed Habib
 * @version 1.0
 */
public class ProjectToProjectDTOMap extends PropertyMap<Project, ProjectDTO> {

	@Override
	protected void configure() {

		map().setProjectId(source.getProjectId());
		map().setProject(source.getProject());
		map().setPriority(source.getPriority());
		map().setUserId(source.getUser().getUserId());

		Converter<LocalDate, String> dateStrConv = new StringLocalDateConverter();
		using(dateStrConv).map(source.getStartDate()).setStartDate(null);
		using(dateStrConv).map(source.getEndDate()).setEndDate(null);

		map().setTaskCount(source.getTaskCount());
		map().setCompleteCount(source.getCompleteCount());
	}

}
