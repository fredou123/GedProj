package com.ged.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ged.dto.TypeDossierTypeDocumentDTO;
import com.ged.entities.TypeDossierTypeDocument;
import com.ged.metier.TypeDossierTypeDocumentMetier;

@RestController
public class TypeDossierTypeDocumentController {
	
	@Autowired
	private TypeDossierTypeDocumentMetier metier;
	
	@RequestMapping( value = "/typeDossierTypeDocuments", method = RequestMethod.POST )
    public TypeDossierTypeDocumentDTO SaveDocument( @RequestBody TypeDossierTypeDocumentDTO t ) {
    	
        return metier.saveTypeDossierTypeDocument(t);
    }

	@RequestMapping( value = "/typeDossierTypeDocuments/{id}", method = RequestMethod.GET )
    public TypeDossierTypeDocument getTypeDossierTypeDocument( @PathVariable Long id ) {
    	
        return metier.getTypeDossierTypeDocument(id);
    }
	
	@RequestMapping( value = "/typeDossierTypeDocuments", method = RequestMethod.GET )
    public List<TypeDossierTypeDocumentDTO> getTypeDossierTypeDocument() {
    	
        return metier.getAllTypeDossierTypeDocument();
    }
	
	@RequestMapping( value = "/typeDossierTypeDocuments", method = RequestMethod.DELETE )
	public TypeDossierTypeDocument deleteTypeDossierTypeDocument(TypeDossierTypeDocument t){
		return metier.deleteTypeDossierTypeDocument(t);
	}

}
