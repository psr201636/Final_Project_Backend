package com.iiht.fsd.model.map;

import org.modelmapper.PropertyMap;

import com.iiht.fsd.model.dao.User;
import com.iiht.fsd.model.dto.AddUserRequest;

/**
 * AddUserRequest to User mapping class
 * 
 * @author Syed Habib
 * @version 1.0
 */
public class AddUserRequestToUserMap extends PropertyMap<AddUserRequest, User> {

	@Override
	protected void configure() {

		map().setFirstName(source.getFirstName());
		map().setLastName(source.getLastName());
		map().setEmployeeId(source.getEmployeeId());
	}

}
