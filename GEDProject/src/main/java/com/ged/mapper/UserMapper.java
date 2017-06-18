package com.ged.mapper;

import org.springframework.stereotype.Component;

import com.ged.bean.UserForm;
import com.ged.entities.User;

@Component
public class UserMapper {

	public User buildUserByUserForm(UserForm userForm) {
		User user = new User();
		user.setAccountNonExpired(true);
		user.setAccountNonLocked(true);
		user.setCredentialsNonExpired(true);
		user.setEnabled(true);
		user.setLogin(userForm.getLogin());
		user.setNom(userForm.getNom());
		user.setPrenom(userForm.getPrenom());
		user.setMdp(userForm.getPassword());
		return user;
	}
}
