package com.iiht.fsd.model.map;

import java.time.LocalDate;

import org.modelmapper.Converter;
import org.modelmapper.PropertyMap;

import com.iiht.fsd.model.dao.Project;
import com.iiht.fsd.model.dto.AddProjectRequest;
import com.iiht.fsd.model.map.converter.LocalDateConverter;

/**
 * AddProjectRequest to Project mapping class
 * 
 * @author Syed Habib
 * @version 1.0
 */
public class AddProjectRequestToProjectMap extends PropertyMap<AddProjectRequest, Project> {

	@Override
	protected void configure() {

		map().setProject(source.getProject());
		map().setPriority(source.getPriority());
		map().getUser().setUserId(source.getUserId());

		Converter<String, LocalDate> dateConv = new LocalDateConverter();
		using(dateConv).map(source.getStartDate()).setStartDate(null);
		using(dateConv).map(source.getEndDate()).setEndDate(null);
	}

}
