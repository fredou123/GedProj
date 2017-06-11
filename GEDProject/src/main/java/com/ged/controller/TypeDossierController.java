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

import com.ged.entities.TypeDossier;
import com.ged.service.TypeDossierService;

@RestController
public class TypeDossierController {
	
	@Autowired
	private TypeDossierService metier;
	
	@RequestMapping( value = "/typeDossiers", method = RequestMethod.POST )
    public TypeDossier saveTypeDossier( @RequestBody TypeDossier td ) {
		
        return metier.saveTypeDossier(td);
    }
	
	@RequestMapping( value = "/typeDossiers/{id}", method = RequestMethod.GET )
    public TypeDossier getTypeDossier( @PathVariable Long id ) {
    	
        return metier.getTypeDossier( id );
    }
	
	
	@RequestMapping( value = "/typeDossiers", method = RequestMethod.DELETE )
    public TypeDossier deleteTypeDossier( @RequestBody TypeDossier typeDossier ) {
    
         return metier.deleteTypeDossier(typeDossier);
    }
	
	@RequestMapping( value = "/typeDossiers", method = RequestMethod.GET )
    public List<TypeDossier>  getAllTypeDossier( ) {	
		
        return  metier.getAllTypeDossiers();
    }
	
	@RequestMapping( value = "/typeDossiers", method = RequestMethod.PUT )
	public void SetTypeDossierById (@RequestParam String nom, @RequestParam Long id){
		 metier.SetTypeDossierById(nom, id);
	}
	
	@RequestMapping( value = "/typeDossiers/all", method = RequestMethod.DELETE )
    public void deleteSelectedTypeDossier(@RequestBody Collection<TypeDossier> c) {
		metier.deleteSelectedTypeDossier(c);
    }
	
	@RequestMapping( value = "/typeDossiers/ids", method = RequestMethod.GET )
	public Collection<TypeDossier> getListTypeDossierById(@RequestBody Collection<Long> ids){
		return metier.getListTypeDossierById(ids);
	}


}
