package com.ged.metier.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ged.dao.UserRepository;
import com.ged.dto.UserDTO;
import com.ged.entities.User;

@Service
public class UserServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User userByLogin = userRepository.findByLogin(username);
		
		return buildUserDetails(userByLogin);
	}
	
	private UserDetails buildUserDetails(User user){
		UserDTO userDTO = new UserDTO(user);
		return userDTO;
	}

}
