package com.ged.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ged.entities.TypeDocument;

public interface TypeDocumentRepository extends JpaRepository<TypeDocument, Long>{
	@Modifying
	@Query("update TypeDocument t set t.nom = ?1 , t.statut =?2 where t.id = ?3")
	public void SetTypeDocumentById (String nom,String statut,Long id);
}
