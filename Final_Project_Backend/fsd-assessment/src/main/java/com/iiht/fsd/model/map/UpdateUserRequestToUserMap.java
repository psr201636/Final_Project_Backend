package com.iiht.fsd.model.map;

import org.modelmapper.PropertyMap;

import com.iiht.fsd.model.dao.User;
import com.iiht.fsd.model.dto.UpdateUserRequest;

/**
 * AddUserRequest to User mapping class
 * 
 * @author Syed Habib
 * @version 1.0
 */
public class UpdateUserRequestToUserMap extends PropertyMap<UpdateUserRequest, User> {

	@Override
	protected void configure() {

		map().setUserId(source.getUserId());
		map().setFirstName(source.getFirstName());
		map().setLastName(source.getLastName());
		map().setEmployeeId(source.getEmployeeId());
	}

}
