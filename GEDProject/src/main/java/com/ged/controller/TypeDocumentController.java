package com.ged.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ged.dto.TypeDocumentDTO;
import com.ged.dto.TypeDocumentPostDTO;
import com.ged.dto.service.TypeDocumentDtoService;

@RestController
public class TypeDocumentController {
	
	@Autowired
	private TypeDocumentDtoService documentDto;
	
	
	
	@RequestMapping( value = "/typeDocuments", method = RequestMethod.POST )
    public TypeDocumentPostDTO saveTypeDocument( @RequestBody TypeDocumentPostDTO td ) {
       
        return documentDto.saveTypeDocument(td);
    }
	
	@RequestMapping( value = "/typeDocuments/{id}", method = RequestMethod.GET )
    public TypeDocumentDTO getTypeDocument( @PathVariable Long id ) {
    	
        return documentDto.getTypeDocument( id );
    }
	
	
	@RequestMapping( value = "/typeDocuments", method = RequestMethod.DELETE )
    public TypeDocumentDTO deleteTypeDocument( @RequestBody TypeDocumentDTO typeDocumentDto ) {
		 
         return documentDto.deleteTypeDocument(typeDocumentDto);
    }
	
	@RequestMapping( value = "/typeDocuments", method = RequestMethod.GET )
    public List<TypeDocumentDTO> getAllTypeDocument( ) {
    	
        return documentDto.getAllTypeDocuments();
    }
	
	@RequestMapping( value = "/typeDocuments", method = RequestMethod.PUT )
	public void SetTypeDocumentById (@RequestParam String nom, @RequestParam String statut, @RequestParam Long id){
		documentDto.SetTypeDocumentById(nom,statut,id);
	}
	
	@RequestMapping( value = "/typeDocuments/all", method = RequestMethod.DELETE )
    public void deleteSelectedTypeDocument(@RequestBody Collection<TypeDocumentDTO> c) {
		documentDto.deleteSelectedTypeDocument(c);
    }
	
	@RequestMapping( value = "/typeDocuments/ids", method = RequestMethod.GET )
	public Collection<TypeDocumentDTO> getListTypeDocumentById(@RequestBody Collection<Long> ids){
		return documentDto.getListTypeDocumentById(ids);
	}


}
