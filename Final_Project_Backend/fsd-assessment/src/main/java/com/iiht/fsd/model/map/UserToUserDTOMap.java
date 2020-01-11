package com.iiht.fsd.model.map;

import org.modelmapper.PropertyMap;

import com.iiht.fsd.model.dao.User;
import com.iiht.fsd.model.dto.UserDTO;

/**
 * User to UserDTO mapping class
 * 
 * @author Syed Habib
 * @version 1.0
 */
public class UserToUserDTOMap extends PropertyMap<User, UserDTO> {

	@Override
	protected void configure() {
		map().setUserId(source.getUserId());
		map().setFirstName(source.getFirstName());
		map().setLastName(source.getLastName());
		map().setEmployeeId(source.getEmployeeId());
	}

}
