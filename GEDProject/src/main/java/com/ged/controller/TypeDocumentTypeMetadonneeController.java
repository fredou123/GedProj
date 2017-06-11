package com.ged.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ged.dto.TypeDocumentTypeMetadonneeDTO;
import com.ged.dto.service.TypeDocumentTypeMetadonneeDtoService;
import com.ged.service.TypeDocumentTypeMetadonneeService;

@RestController
public class TypeDocumentTypeMetadonneeController {
	
	@Autowired
	private TypeDocumentTypeMetadonneeService metier;
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

}
