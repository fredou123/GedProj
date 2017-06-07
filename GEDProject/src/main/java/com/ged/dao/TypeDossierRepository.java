package com.ged.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ged.entities.TypeDossier;

public interface TypeDossierRepository extends JpaRepository<TypeDossier, Long> {
	@Modifying
	@Query("update TypeDossier t set t.nom = ?1 where t.id = ?2")
	public void SetTypeDossierById (String nom,Long id);
}
