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

import com.ged.dto.TypeDossierDTO;
import com.ged.dto.TypeDossierPostDTO;
import com.ged.dto.service.TypeDossierDtoService;

@RestController
public class TypeDossierController {
	
	@Autowired
	private TypeDossierDtoService metier;
	
	@RequestMapping( value = "/typeDossiers", method = RequestMethod.POST )
    public TypeDossierPostDTO saveTypeDossier( @RequestBody TypeDossierPostDTO td ) {
		
        return metier.saveTypeDossier(td);
    }
	
	@RequestMapping( value = "/typeDossiers/{id}", method = RequestMethod.GET )
    public TypeDossierDTO getTypeDossier( @PathVariable Long id ) {
    	
        return metier.getTypeDossier( id );
    }
	
	
	@RequestMapping( value = "/typeDossiers", method = RequestMethod.DELETE )
    public TypeDossierDTO deleteTypeDossier( @RequestBody TypeDossierDTO typeDossier ) {
    
         return metier.deleteTypeDossier(typeDossier);
    }
	
	@RequestMapping( value = "/typeDossiers", method = RequestMethod.GET )
    public List<TypeDossierDTO>  getAllTypeDossier( ) {	
		
        return  metier.getAllTypeDossiers();
    }
	
	@RequestMapping( value = "/typeDossiers", method = RequestMethod.PUT )
	public void SetTypeDossierById (@RequestParam String nom, @RequestParam Long id){
		 metier.SetTypeDossierById(nom, id);
	}
	
	@RequestMapping( value = "/typeDossiers/all", method = RequestMethod.DELETE )
    public void deleteSelectedTypeDossier(@RequestBody Collection<TypeDossierDTO> c) {
		metier.deleteSelectedTypeDossier(c);
    }
	
	@RequestMapping( value = "/typeDossiers/ids", method = RequestMethod.GET )
	public Collection<TypeDossierDTO> getListTypeDossierById(@RequestBody Collection<Long> ids){
		return metier.getListTypeDossierById(ids);
	}


}
