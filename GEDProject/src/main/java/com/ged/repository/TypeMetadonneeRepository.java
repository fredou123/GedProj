package com.ged.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ged.entities.TypeMetadonnee;

public interface TypeMetadonneeRepository extends JpaRepository<TypeMetadonnee, Long> {
	
	@Modifying
	@Query("update TypeMetadonnee t set t.nom = ?1 where t.id = ?2")
	public void SetTypeMetadonneeById (String nom,Long id);

}
