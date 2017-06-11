package com.ged.dto.service.implementation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ged.dto.TypeDossierDTO;
import com.ged.dto.TypeDossierPostDTO;
import com.ged.dto.TypeDossierTypeDocumentDTO;
import com.ged.dto.TypeDossierTypeMetadonneeDTO;
import com.ged.dto.service.TypeDossierDtoService;
import com.ged.entities.TypeDossier;
import com.ged.entities.TypeDossierTypeDocument;
import com.ged.entities.TypeDossierTypeMetadonnee;
import com.ged.service.TypeDocumentService;
import com.ged.service.TypeDossierService;
import com.ged.service.TypeMetadonneeService;

@Service
@Transactional
public class TypeDossierDtoServiceImpl implements TypeDossierDtoService {
	
	@Autowired
	private TypeDocumentService metierDoc;
	@Autowired
	private TypeMetadonneeService metierMeta;
	@Autowired
	private TypeDossierService metier;

	@Override
	public TypeDossierDTO getTypeDossier(Long id) {
		TypeDossierDTO tDto = new TypeDossierDTO(metier.getTypeDossier(id));
		return tDto;
	}

	@Override
	public TypeDossierPostDTO saveTypeDossier(TypeDossierPostDTO typeDossierPostDTO) {
		
		TypeDossier d = new TypeDossier();
		d.setNom(typeDossierPostDTO.getNom());
		d.setDate_creation(typeDossierPostDTO.getDate_creation());
		d.setDate_last_modification(typeDossierPostDTO.getDate_last_modification());
		d.setUser_creation(typeDossierPostDTO.getUser_creation());
		d.setUser_last_modification(typeDossierPostDTO.getUser_last_modification());
		
		Collection<TypeDossierTypeMetadonnee> c1 = new ArrayList<TypeDossierTypeMetadonnee>();
		Collection<TypeDossierTypeDocument> c2 = new ArrayList<TypeDossierTypeDocument>();
		
		for (TypeDossierTypeMetadonneeDTO t : typeDossierPostDTO.getTypeDossierTypeMetadonnees()){
			TypeDossierTypeMetadonnee m = new TypeDossierTypeMetadonnee();
			m.setDefaultValue(t.getDefaultValue());
			m.setIsObligatoire(t.getIsObligatoire());
			m.setRegex(t.getRegex());
			m.setTypeMetadonnee(metierMeta.getTypeMetadonnee(t.getTypeMetadonnee()));
			c1.add(m);	
		}
		d.setTypeDossierTypeMetadonnees(c1);
		
		for(TypeDossierTypeDocumentDTO t : typeDossierPostDTO.getTypeDossierTypeDocuments()){
			TypeDossierTypeDocument m = new TypeDossierTypeDocument();
			m.setIsObligatoire(t.getIsObligatoire());
			m.setTypeDocument(metierDoc.getTypeDocument(t.getTypeDocument()));
			c2.add(m);
		}
		d.setTypeDossierTypeDocuments(c2);
		
		d = metier.saveTypeDossier(d);
		TypeDossierPostDTO tDto = new TypeDossierPostDTO(d);
		return tDto;
	}

	@Override
	public List<TypeDossierDTO> getAllTypeDossiers() {
		Collection<TypeDossier> allDocuments =  metier.getAllTypeDossiers();
		List<TypeDossierDTO> list = new ArrayList<TypeDossierDTO>();
		for (TypeDossier t : allDocuments){
			list.add(new TypeDossierDTO(t));
		}
		return list;
	}

	@Override
	public TypeDossierDTO deleteTypeDossier(TypeDossierDTO typeDossierDto) {
		TypeDossier d = metier.getTypeDossier(typeDossierDto.getId());
		d = metier.deleteTypeDossier(d);
		TypeDossierDTO tDto = new TypeDossierDTO(d);
		return tDto;
	}

	@Override
	public void SetTypeDossierById(String nom, Long id) {
		metier.SetTypeDossierById(nom, id);
		
	}

	@Override
	public Collection<TypeDossierDTO> getListTypeDossierById(
			Collection<Long> ids) {
		Collection<TypeDossierDTO> dossiersDto = new ArrayList<TypeDossierDTO>();
		for (TypeDossier t : metier.getListTypeDossierById(ids)){
			TypeDossierDTO m = new TypeDossierDTO(t);
			dossiersDto.add(m);
		}
		return dossiersDto;
	}

	@Override
	public void deleteSelectedTypeDossier(Collection<TypeDossierDTO> c) {
		Collection<TypeDossier> dossiers = new ArrayList<TypeDossier>();
		for (TypeDossierDTO t : c){
			TypeDossier d = metier.getTypeDossier(t.getId());
			dossiers.add(d);
		}
		metier.deleteSelectedTypeDossier(dossiers);
		
	}

}
