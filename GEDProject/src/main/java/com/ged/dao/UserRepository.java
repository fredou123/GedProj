package com.ged.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ged.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

	public User findByLogin(String login);
}
