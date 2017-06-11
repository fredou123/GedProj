package com.ged.dto.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ged.dto.TypeDossierTypeMetadonneeDTO;
import com.ged.dto.service.TypeDossierTypeMetadonneeDtoService;
import com.ged.entities.TypeDossierTypeMetadonnee;
import com.ged.service.TypeDossierService;
import com.ged.service.TypeDossierTypeMetadonneeService;
import com.ged.service.TypeMetadonneeService;

@Service
@Transactional
public class TypeDossierTypeMetadonneeDtoServiceImpl implements TypeDossierTypeMetadonneeDtoService{
	
	@Autowired
	private TypeDossierTypeMetadonneeService metier;
	@Autowired
	private TypeDossierService metierDos;
	@Autowired
	private TypeMetadonneeService metierMeta;
	

	@Override
	public TypeDossierTypeMetadonneeDTO saveTypeDossierTypeMetadonnee(
			TypeDossierTypeMetadonneeDTO value) {
		
		TypeDossierTypeMetadonnee t = new TypeDossierTypeMetadonnee();
		t.setDefaultValue(value.getDefaultValue());
		t.setIsObligatoire(value.getIsObligatoire());
		t.setRegex(value.getRegex());
		t.setTypeDossier(metierDos.getTypeDossier(value.getId()));
		t.setTypeMetadonnee(metierMeta.getTypeMetadonnee(value.getId()));
		t = metier.saveTypeDossierTypeMetadonnee(t);
		TypeDossierTypeMetadonneeDTO m = new TypeDossierTypeMetadonneeDTO(t);
		return m;
	}

	@Override
	public List<TypeDossierTypeMetadonneeDTO> getAllTypeDossierTypeMetadonnee() {
		
		List<TypeDossierTypeMetadonneeDTO> list = new ArrayList<TypeDossierTypeMetadonneeDTO>();
		for (TypeDossierTypeMetadonnee t : metier.getAllTypeDossierTypeMetadonnee()){
			TypeDossierTypeMetadonneeDTO m = new TypeDossierTypeMetadonneeDTO(t);
			list.add(m);
		}
		return list;
	}

}
