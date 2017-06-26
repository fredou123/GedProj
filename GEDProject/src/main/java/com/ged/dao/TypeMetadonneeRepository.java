package com.ged.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ged.entities.TypeMetadonnee;

public interface TypeMetadonneeRepository extends JpaRepository<TypeMetadonnee, Long> {
	
	@Modifying
	@Query("update TypeMetadonnee t set t.nom = ?1, t.type =?2 where t.id = ?3")
	public void SetTypeMetadonneeById (String nom,String type,Long id);

}
