package com.ged.service;

import com.ged.dto.TypeDocumentDTO;
import com.ged.dto.TypeDocumentTypeMetadonneeDTO;
import com.ged.dto.TypeDossierDTO;
import com.ged.dto.TypeDossierTypeDocumentDTO;
import com.ged.dto.TypeDossierTypeMetadonneeDTO;
import com.ged.dto.TypeMetadonneeDTO;
import com.ged.entities.TypeDocument;
import com.ged.entities.TypeDocumentTypeMetadonnee;
import com.ged.entities.TypeDossier;
import com.ged.entities.TypeDossierTypeDocument;
import com.ged.entities.TypeDossierTypeMetadonnee;
import com.ged.entities.TypeMetadonnee;

public interface DtoService {
	
	public TypeDocument transformTypeDocumentDTO (TypeDocumentDTO tDTO);
	
	public TypeDossier transformTypeDossierDT0 (TypeDossierDTO tDTO);
	
	public TypeMetadonnee transformTypeMetadonneeDTO (TypeMetadonneeDTO tDTO);
	
	public TypeDossierTypeMetadonnee transformTypeDossierTypeMetadonnee (TypeDossierTypeMetadonneeDTO tDTO);
	
	public TypeDossierTypeDocument transformTypeDossierTypeDocument (TypeDossierTypeDocumentDTO tDTO);
	
	public TypeDocumentTypeMetadonnee transformTypeDocumentTypeMetadonnee(TypeDocumentTypeMetadonneeDTO tDTO);

}
