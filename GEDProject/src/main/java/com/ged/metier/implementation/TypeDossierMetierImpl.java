package com.ged.metier.implementation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ged.dao.TypeDossierRepository;
import com.ged.dto.TypeDossierDTO;
import com.ged.dto.TypeDossierTypeDocumentDTO;
import com.ged.dto.TypeDossierTypeMetadonneeDTO;
import com.ged.entities.TypeDossier;
import com.ged.entities.TypeDossierTypeDocument;
import com.ged.entities.TypeDossierTypeMetadonnee;
import com.ged.metier.DtoMetier;
import com.ged.metier.TypeDossierMetier;
import com.ged.metier.TypeDossierTypeDocumentMetier;
import com.ged.metier.TypeDossierTypeMetadonneeMetier;

@Service
public class TypeDossierMetierImpl implements TypeDossierMetier {

	@Autowired
	private TypeDossierRepository repository;
	@Autowired
	private TypeDossierTypeMetadonneeMetier metier1;
	@Autowired
	private TypeDossierTypeDocumentMetier metier2;
	@Autowired
	private DtoMetier dto;

	@Override
	public TypeDossier getTypeDossier(Long id) {
		return repository.findOne(id);
	}

	@Override
	@Transactional
	public TypeDossierDTO saveTypeDossier(TypeDossierDTO typeDossierDto) {
		
		TypeDossier d = dto.transformTypeDossierDT0(typeDossierDto);
		d.setDate_creation(new Date());
		d.setDate_last_modification(new Date());
		TypeDossier dBase = repository.save(d);
		
		if (dBase.getTypeDossierTypeMetadonnees()!=null){
			for (TypeDossierTypeMetadonnee t : dBase.getTypeDossierTypeMetadonnees()){
				t.setTypeDossier(dBase);
				TypeDossierTypeMetadonneeDTO m = new TypeDossierTypeMetadonneeDTO(t);
				metier1.saveTypeDossierTypeMetadonnee(m);
			}
		}
		
		if (dBase.getTypeDossierTypeDocuments()!=null){
			for (TypeDossierTypeDocument t : dBase.getTypeDossierTypeDocuments()){
				t.setTypeDossier(dBase);
				TypeDossierTypeDocumentDTO m = new TypeDossierTypeDocumentDTO(t);
				metier2.saveTypeDossierTypeDocument(m);
			}
		}
		TypeDossierDTO dtoObj = new TypeDossierDTO(dBase);
		
		return dtoObj;
	}

	@Override
	@Transactional
	public TypeDossier deleteTypeDossier(TypeDossier typeDossier) {
		if (typeDossier.getTypeDossierTypeDocuments()!= null){
			for (TypeDossierTypeDocument t : typeDossier.getTypeDossierTypeDocuments()){
				metier2.deleteTypeDossierTypeDocument(t);
				typeDossier.setTypeDossierTypeDocuments(null);}
		}
		if (typeDossier.getTypeDossierTypeMetadonnees()!= null){
			for (TypeDossierTypeMetadonnee t : typeDossier.getTypeDossierTypeMetadonnees()){
				metier1.deleteTypeDossierTypeMetadonnee(t);
				typeDossier.setTypeDossierTypeMetadonnees(null);
				
			}
		}
		repository.delete(typeDossier);
		return typeDossier;
	}

	@Override
	public List<TypeDossierDTO> getAllTypeDossiers() {
		Collection<TypeDossier> allDossier = repository.findAll();
		List<TypeDossierDTO> listAllDossiers = new ArrayList<TypeDossierDTO>();
		for (TypeDossier t : allDossier){
			listAllDossiers.add(new TypeDossierDTO(t));
		}
		return listAllDossiers;
	}

	@Override
	@Transactional
	public void SetTypeDossierById(String nom, Long id) {
		repository.SetTypeDossierById(nom, id);
		
	}

	@Override
	@Transactional
	public void deleteSelectedTypeDossier(Collection<TypeDossier> c) {
		for (TypeDossier td : c){
			this.deleteTypeDossier(td);
		}
		
	}

	@Override
	public Collection<TypeDossier> getListTypeDossierById(Collection<Long> ids) {
		return repository.findAll(ids);
	}
	
	
}
