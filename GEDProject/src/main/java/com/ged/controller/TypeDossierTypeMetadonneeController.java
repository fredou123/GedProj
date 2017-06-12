package com.ged.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ged.dto.TypeDossierTypeMetadonneeDTO;
import com.ged.dto.service.TypeDossierTypeMetadonneeDtoService;

@RestController
public class TypeDossierTypeMetadonneeController {
	
	@Autowired
	private TypeDossierTypeMetadonneeDtoService metier;
	
	@RequestMapping( value = "/typeDossierTypeMetadonnees", method = RequestMethod.POST )
    public TypeDossierTypeMetadonneeDTO SaveDocument( @RequestBody TypeDossierTypeMetadonneeDTO t ) {
    	
        return metier.saveTypeDossierTypeMetadonnee(t);
    }
	
	@RequestMapping( value = "/typeDossierTypeMetadonnees", method = RequestMethod.GET )
    public List<TypeDossierTypeMetadonneeDTO> getTypeDossierTypeMetadonnee() {
    	
        return metier.getAllTypeDossierTypeMetadonnee();
    }	
	
	@RequestMapping( value = "/typeDossierTypeMetadonnees/{id}", method = RequestMethod.GET )
    public TypeDossierTypeMetadonneeDTO getTypeDossierTypeMetadonnee( @PathVariable Long id ) {
    	
        return metier.getTypeDossierTypeMetadonnee(id);
    }
	
	@RequestMapping( value = "/typeDossierTypeMetadonnees", method = RequestMethod.DELETE )
	public TypeDossierTypeMetadonneeDTO deleteTypeDossierTypeMetadonnee (@RequestBody TypeDossierTypeMetadonneeDTO t){
		return metier.deleteTypeDossierTypeMetadonnee(t) ;
	}
	
	@RequestMapping( value = "/typeDossierTypeMetadonnees/ids", method = RequestMethod.GET )
	public List<TypeDossierTypeMetadonneeDTO> getListById (@RequestBody List<Long> ids){
		return metier.getListById(ids);
	}

}
