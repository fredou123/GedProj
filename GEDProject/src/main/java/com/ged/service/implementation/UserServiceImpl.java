package com.ged.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ged.bean.UserForm;
import com.ged.dto.UserDTO;
import com.ged.entities.Profil;
import com.ged.entities.User;
import com.ged.mapper.UserMapper;
import com.ged.repository.ProfilRepository;
import com.ged.repository.UserRepository;
import com.ged.service.UserService;

@Service
public class UserServiceImpl implements UserDetailsService, UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ProfilRepository profilRepository;
	
	@Autowired
	private UserMapper userMapper;	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User userByLogin = userRepository.findByLogin(username);		
		return buildUserDetails(userByLogin);
	}
	
	private UserDetails buildUserDetails(User user){
		UserDTO userDTO = new UserDTO(user);
		return userDTO;
	}

	@Override
	public List<User> findAllUsers() {
		return userRepository.findAll();
	}
	
	@Override
	public User finUserById(Long id){
		return userRepository.findOne(id);
	}

	@Override
	public void createUser(UserForm userForm) {
		User user =userMapper.buildUserByUserForm(userForm);
		Profil profil = profilRepository.findByNom("ROLE_USER");
		profil.getUsers().add(user);
		user.getProfils().add(profil);
		userRepository.save(user);
	}
	
}
