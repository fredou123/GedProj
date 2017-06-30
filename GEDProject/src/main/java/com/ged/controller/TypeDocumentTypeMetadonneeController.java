package com.ged.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ged.dto.TypeDocumentTypeMetadonneeDTO;
import com.ged.entities.TypeDocumentTypeMetadonnee;
import com.ged.service.TypeDocumentTypeMetadonneeMetier;

@RestController
public class TypeDocumentTypeMetadonneeController {
	
	@Autowired
	private TypeDocumentTypeMetadonneeMetier metier;
	
	@RequestMapping( value = "/typeDocumentTypeMetadonnees", method = RequestMethod.POST )
    public TypeDocumentTypeMetadonneeDTO SaveTypeDocumentTypeMetadonnee( @RequestBody TypeDocumentTypeMetadonneeDTO t ) {
    	
        return metier.saveTypeDocumentTypeMetadonnee(t);
    }

	@RequestMapping( value = "/typeDocumentTypeMetadonnees/{id}", method = RequestMethod.GET )
    public TypeDocumentTypeMetadonnee getTypeDocumentTypeMetadonnee( @PathVariable Long id ) {
    	
        return metier.getTypeDocumentTypeMetadonnee(id);
    }
	
	@RequestMapping( value = "/typeDocumentTypeMetadonnees", method = RequestMethod.GET )
    public List<TypeDocumentTypeMetadonneeDTO> getTypeDocumentTypeMetadonnee() {
    	
        return metier.getAllTypeDocumentTypeMetadonnee();
    }
	
	@RequestMapping( value = "/typeDocumentTypeMetadonnees", method = RequestMethod.DELETE )
    public TypeDocumentTypeMetadonnee deleteTypeDocumentTypeMetadonnee(@RequestBody TypeDocumentTypeMetadonnee t) {
    	
        return metier.deleteTypeDocumentTypeMetadonnee(t);
    }

}
