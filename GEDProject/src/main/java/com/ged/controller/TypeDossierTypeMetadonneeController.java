package com.ged.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ged.entities.TypeDossierTypeMetadonnee;
import com.ged.service.TypeDossierTypeMetadonneeService;

@RestController
public class TypeDossierTypeMetadonneeController {
	
	@Autowired
	private TypeDossierTypeMetadonneeService metier;
	
	@RequestMapping( value = "/typeDossierTypeMetadonnees", method = RequestMethod.POST )
    public TypeDossierTypeMetadonnee SaveDocument( @RequestBody TypeDossierTypeMetadonnee t ) {
    	
        return metier.saveTypeDossierTypeMetadonnee(t);
    }

	@RequestMapping( value = "/typeDossierTypeMetadonnees/{id}", method = RequestMethod.GET )
    public TypeDossierTypeMetadonnee getTypeDossierTypeMetadonnee( @PathVariable Long id ) {
    	
        return metier.getTypeDossierTypeMetadonnee(id);
    }
	
	@RequestMapping( value = "/typeDossierTypeMetadonnees", method = RequestMethod.GET )
    public List<TypeDossierTypeMetadonnee> getTypeDossierTypeMetadonnee() {
    	
        return metier.getAllTypeDossierTypeMetadonnee();
    }
	
	@RequestMapping( value = "/typeDossierTypeMetadonnees", method = RequestMethod.DELETE )
	public TypeDossierTypeMetadonnee deleteTypeDossierTypeMetadonnee (@RequestBody TypeDossierTypeMetadonnee t){
		return metier.deleteTypeDossierTypeMetadonnee(t);
	}	

}
