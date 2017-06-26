package com.ged.dto.service.implementation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ged.dto.TypeDocumentTypeMetadonneeDTO;
import com.ged.dto.TypeDossierTypeMetadonneeDTO;
import com.ged.dto.TypeMetadonneeDTO;
import com.ged.dto.TypeMetadonneePostDTO;
import com.ged.dto.service.TypeMetadonneeDtoService;
import com.ged.entities.TypeDocumentTypeMetadonnee;
import com.ged.entities.TypeDossierTypeMetadonnee;
import com.ged.entities.TypeMetadonnee;
import com.ged.service.TypeDocumentService;
import com.ged.service.TypeDossierService;
import com.ged.service.TypeMetadonneeService;

@Service
@Transactional
public class TypeMetadonneeDtoServiceImpl implements TypeMetadonneeDtoService{
	
	@Autowired
	private TypeDocumentService metierDoc;
	@Autowired
	private TypeMetadonneeService metier;
	@Autowired
	private TypeDossierService metierDos;

	@Override
	public TypeMetadonneeDTO getTypeMetadonnee(Long id) {
		
		TypeMetadonneeDTO tDto = new TypeMetadonneeDTO(metier.getTypeMetadonnee(id));
		return tDto;
	}

	@Override
	public TypeMetadonneePostDTO saveTypeMetadonnee(
			TypeMetadonneePostDTO typeMetadonneePostDTO) {
		
		TypeMetadonnee d = new TypeMetadonnee();
		d.setNom(typeMetadonneePostDTO.getNom());
		d.setType(typeMetadonneePostDTO.getType());
		d.setDate_creation(typeMetadonneePostDTO.getDate_creation());
		d.setDate_last_modification(typeMetadonneePostDTO.getDate_last_modification());
		d.setUser_creation(typeMetadonneePostDTO.getUser_creation());
		d.setUser_last_modification(typeMetadonneePostDTO.getUser_last_modification());
		
		Collection<TypeDocumentTypeMetadonnee> c1 = new ArrayList<TypeDocumentTypeMetadonnee>();
		Collection<TypeDossierTypeMetadonnee> c2 = new ArrayList<TypeDossierTypeMetadonnee>();
		
		for (TypeDocumentTypeMetadonneeDTO t : typeMetadonneePostDTO.getTypeDocumentTypeMetadonnees()){
			TypeDocumentTypeMetadonnee m = new TypeDocumentTypeMetadonnee();
			m.setDefaultValue(t.getDefaultValue());
			m.setIsObligatoire(t.getIsObligatoire());
			m.setRegex(t.getRegex());
			m.setTypeDocument(metierDoc.getTypeDocument(t.getTypeDocument()));
			c1.add(m);	
		}
		d.setTypeDocumentTypeMetadonnees(c1);
		
		for(TypeDossierTypeMetadonneeDTO t : typeMetadonneePostDTO.getTypeDossierTypeMetadonnees()){
			TypeDossierTypeMetadonnee m = new TypeDossierTypeMetadonnee();
			m.setIsObligatoire(t.getIsObligatoire());
			m.setTypeDossier(metierDos.getTypeDossier(t.getTypeDossier()));
			c2.add(m);
		}
		d.setTypeDossierTypeMetadonnees(c2);
		
		d = metier.saveTypeMetadonnee(d);
		TypeMetadonneePostDTO tDto = new TypeMetadonneePostDTO(d);
		return tDto;
	}

	@Override
	public List<TypeMetadonneeDTO> getAllTypeMetadonnees() {
		Collection<TypeMetadonnee> allMetadonnees =  metier.getAllTypeMetadonnees();
		List<TypeMetadonneeDTO> list = new ArrayList<TypeMetadonneeDTO>();
		for (TypeMetadonnee t : allMetadonnees){
			list.add(new TypeMetadonneeDTO(t));
		}
		return list;
	}

	@Override
	public TypeMetadonneeDTO deleteTypeMetadonnee(
			TypeMetadonneeDTO typeMetadonneeDto) {
		
		TypeMetadonnee d = metier.getTypeMetadonnee(typeMetadonneeDto.getId());
		d = metier.deleteTypeMetadonnee(d);
		TypeMetadonneeDTO tDto = new TypeMetadonneeDTO(d);
		return tDto;
	}

	@Override
	public void SetTypeMetadonneeById(String nom, String type,Long id) {
		metier.SetTypeMetadonneeById(nom,type, id);
		
	}

	@Override
	public Collection<TypeMetadonneeDTO> getListTypeMetadonneeById(
			Collection<Long> ids) {
		
		Collection<TypeMetadonneeDTO> MetadonneesDto = new ArrayList<TypeMetadonneeDTO>();
		for (TypeMetadonnee t : metier.getListTypeMetadonneeById(ids)){
			TypeMetadonneeDTO m = new TypeMetadonneeDTO(t);
			MetadonneesDto.add(m);
		}
		return MetadonneesDto;
	}

	@Override
	public void deleteSelectedTypeMetadonnee(Collection<TypeMetadonneeDTO> c) {
		Collection<TypeMetadonnee> Metadonnees = new ArrayList<TypeMetadonnee>();
		for (TypeMetadonneeDTO t : c){
			TypeMetadonnee d = metier.getTypeMetadonnee(t.getId());
			Metadonnees.add(d);
		}
		metier.deleteSelectedTypeMetadonnee(Metadonnees);
	}

}
