package com.ged.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ged.entities.Profil;

public interface ProfilRepository extends JpaRepository<Profil, Long>{
	
	public Profil findByNom(String nom);
}
