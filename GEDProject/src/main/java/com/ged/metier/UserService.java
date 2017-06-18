package com.ged.metier;

import java.util.List;

import com.ged.bean.UserForm;
import com.ged.dto.UserDTO;
import com.ged.entities.User;

public interface UserService {

	public List<User> findAllUsers();

	User finUserById(Long id);

	public void createUser(UserForm userForm);	
	
	
}
