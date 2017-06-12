package com.ged.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ged.dto.TypeDocumentTypeMetadonneeDTO;
import com.ged.dto.service.TypeDocumentTypeMetadonneeDtoService;


@RestController
public class TypeDocumentTypeMetadonneeController {
	
	
	@Autowired
	private TypeDocumentTypeMetadonneeDtoService dtoDocMeta;
	
	@RequestMapping( value = "/typeDocumentTypeMetadonnees", method = RequestMethod.POST )
    public TypeDocumentTypeMetadonneeDTO SaveTypeDocumentTypeMetadonnee( @RequestBody TypeDocumentTypeMetadonneeDTO t ) {
    	
        return dtoDocMeta.saveTypeDocumentTypeMetadonnee(t);
    }
	
	@RequestMapping( value = "/typeDocumentTypeMetadonnees", method = RequestMethod.GET )
    public List<TypeDocumentTypeMetadonneeDTO> getTypeDocumentTypeMetadonnee() {
    	
        return dtoDocMeta.getAllTypeDocumentTypeMetadonnee();
    }
	
	@RequestMapping( value = "/typeDocumentTypeMetadonnees/{id}", method = RequestMethod.GET )
    public TypeDocumentTypeMetadonneeDTO getTypeDocumentTypeMetadonnee( @PathVariable Long id ) {
    	
        return dtoDocMeta.getTypeDocumentTypeMetadonnee(id);
    }
	
	@RequestMapping( value = "/typeDocumentTypeMetadonnees", method = RequestMethod.DELETE )
    public TypeDocumentTypeMetadonneeDTO deleteTypeDocumentTypeMetadonnee(@RequestBody TypeDocumentTypeMetadonneeDTO t) {
    	
        return dtoDocMeta.deleteTypeDocumentTypeMetadonnee(t);
    }
	
	@RequestMapping( value = "/typeDocumentTypeMetadonnees/ids", method = RequestMethod.GET )
	public List<TypeDocumentTypeMetadonneeDTO> getListById(Collection<Long> ids) {
		
		return dtoDocMeta.getListById(ids);
	}

}
