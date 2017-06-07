package com.ged.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ged.entities.Document;

public interface DocumentRepository extends JpaRepository<Document, Long> {

}