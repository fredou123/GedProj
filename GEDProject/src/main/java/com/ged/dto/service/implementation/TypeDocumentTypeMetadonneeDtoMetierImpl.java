package com.ged.dto.service.implementation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ged.dto.TypeDocumentTypeMetadonneeDTO;
import com.ged.dto.service.TypeDocumentTypeMetadonneeDtoService;
import com.ged.entities.TypeDocumentTypeMetadonnee;
import com.ged.service.TypeDocumentService;
import com.ged.service.TypeDocumentTypeMetadonneeService;
import com.ged.service.TypeMetadonneeService;

@Service
@Transactional
public class TypeDocumentTypeMetadonneeDtoMetierImpl implements TypeDocumentTypeMetadonneeDtoService{
	
	@Autowired
	private TypeDocumentTypeMetadonneeService metierDocMeta;
	@Autowired
	private TypeDocumentService metierDoc;
	@Autowired
	private TypeMetadonneeService metierMeta;

	@Override
	public TypeDocumentTypeMetadonneeDTO saveTypeDocumentTypeMetadonnee(
			TypeDocumentTypeMetadonneeDTO value) {
		TypeDocumentTypeMetadonnee t = new TypeDocumentTypeMetadonnee();
		t.setDefaultValue(value.getDefaultValue());
		t.setIsObligatoire(value.getIsObligatoire());
		t.setRegex(value.getRegex());
		t.setTypeDocument(metierDoc.getTypeDocument(value.getId()));
		t.setTypeMetadonnee(metierMeta.getTypeMetadonnee(value.getId()));
		t = metierDocMeta.saveTypeDocumentTypeMetadonnee(t);
		TypeDocumentTypeMetadonneeDTO m = new TypeDocumentTypeMetadonneeDTO(t);
		return m;
	}

	@Override
	public List<TypeDocumentTypeMetadonneeDTO> getAllTypeDocumentTypeMetadonnee() {
		List<TypeDocumentTypeMetadonneeDTO> list = new ArrayList<TypeDocumentTypeMetadonneeDTO>();
		
		for (TypeDocumentTypeMetadonnee t : metierDocMeta.getAllTypeDocumentTypeMetadonnee()){
			TypeDocumentTypeMetadonneeDTO m = new TypeDocumentTypeMetadonneeDTO(t);
			list.add(m);
		}
		return list;
	}

	@Override
	public TypeDocumentTypeMetadonneeDTO getTypeDocumentTypeMetadonnee(Long id) {
		TypeDocumentTypeMetadonnee d = metierDocMeta.getTypeDocumentTypeMetadonnee(id);
		TypeDocumentTypeMetadonneeDTO mDto = new TypeDocumentTypeMetadonneeDTO(d);
		
		return mDto;
	}

	@Override
	public List<TypeDocumentTypeMetadonneeDTO> getListById(Collection<Long> ids) {
		List<TypeDocumentTypeMetadonneeDTO> cDto = new ArrayList<TypeDocumentTypeMetadonneeDTO>();
		for (TypeDocumentTypeMetadonnee t : metierDocMeta.getListById(ids)){
			TypeDocumentTypeMetadonneeDTO m = new TypeDocumentTypeMetadonneeDTO(t);
			cDto.add(m);
		}
		return cDto;
	}

	@Override
	public TypeDocumentTypeMetadonneeDTO deleteTypeDocumentTypeMetadonnee(
			TypeDocumentTypeMetadonneeDTO t) {
		TypeDocumentTypeMetadonnee d =  metierDocMeta.deleteTypeDocumentTypeMetadonnee(metierDocMeta.getTypeDocumentTypeMetadonnee(t.getId()));
		TypeDocumentTypeMetadonneeDTO m = new TypeDocumentTypeMetadonneeDTO(d);
		return m;
	}

}
