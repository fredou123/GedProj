package com.ged.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ged.dto.TypeDossierTypeDocumentDTO;
import com.ged.dto.service.TypeDossierTypeDocumentDtoService;

@RestController
public class TypeDossierTypeDocumentController {
	
	@Autowired
	private TypeDossierTypeDocumentDtoService dtoDosDoc;
	
	@RequestMapping( value = "/typeDossierTypeDocuments", method = RequestMethod.POST )
    public TypeDossierTypeDocumentDTO SaveDocument( @RequestBody TypeDossierTypeDocumentDTO t ) {
    	
        return dtoDosDoc.saveTypeDossierTypeDocument(t);
    }

	@RequestMapping( value = "/typeDossierTypeDocuments/{id}", method = RequestMethod.GET )
    public TypeDossierTypeDocumentDTO getTypeDossierTypeDocument( @PathVariable Long id ) {
    	
        return dtoDosDoc.getTypeDossierTypeDocument(id);
    }
	
	@RequestMapping( value = "/typeDossierTypeDocuments", method = RequestMethod.GET )
    public List<TypeDossierTypeDocumentDTO> getTypeDossierTypeDocument() {
    	
        return dtoDosDoc.getAllTypeDossierTypeDocument();
    }
	
	@RequestMapping( value = "/typeDossierTypeDocuments", method = RequestMethod.DELETE )
	public TypeDossierTypeDocumentDTO deleteTypeDossierTypeDocument(TypeDossierTypeDocumentDTO t){
		return dtoDosDoc.deleteTypeDossierTypeDocument(t);
	}
	
	@RequestMapping( value = "/typeDossierTypeDocuments/ids", method = RequestMethod.GET )
    public List<TypeDossierTypeDocumentDTO> getListById( @RequestBody List<Long> ids ) {
    	
        return dtoDosDoc.getListById(ids);
    }

}
