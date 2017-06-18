package com.ged.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ged.bean.UserForm;
import com.ged.dto.UserDTO;
import com.ged.metier.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping( value = "/user/{id}", method = RequestMethod.GET )
    public List<UserDTO> getUserById( @PathVariable Long id ) {    	
        return userService.findAllUsers().stream().map(user -> new UserDTO(user)).collect(Collectors.toList());
    }
	
	@RequestMapping( value = "/users", method = RequestMethod.GET )
    public List<UserDTO> getAllUser() {    	
        return userService.findAllUsers().stream().map(user -> new UserDTO(user)).collect(Collectors.toList());
    }
	
	@RequestMapping( value = "/user/create", method = RequestMethod.POST )
    public ResponseEntity<?> createUser(@RequestBody UserForm userForm) {    	
         userService.createUser(userForm);
         return new ResponseEntity(HttpStatus.CREATED);
    }
}
