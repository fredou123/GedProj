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

import com.ged.dto.TypeMetadonneeDTO;
import com.ged.dto.TypeMetadonneePostDTO;
import com.ged.dto.service.TypeMetadonneeDtoService;

@RestController
public class TypeMetadonneeController {
	
	@Autowired
	private TypeMetadonneeDtoService metier;
	
	@RequestMapping( value = "/typeMetadonnees", method = RequestMethod.POST )
    public TypeMetadonneePostDTO saveTypeMetadonnee( @RequestBody TypeMetadonneePostDTO tm ) {
    	
        return metier.saveTypeMetadonnee( tm );
    }
	
	@RequestMapping( value = "/typeMetadonnees/{id}", method = RequestMethod.GET )
    public TypeMetadonneeDTO getTypeMetadonnee( @PathVariable Long id ) {
    	
        return metier.getTypeMetadonnee( id );
    }
	
	
	@RequestMapping( value = "/typeMetadonnees", method = RequestMethod.DELETE )
    public TypeMetadonneeDTO deleteTypeMetadonnee( @RequestBody TypeMetadonneeDTO typeMetadonnee ) {
    
         return metier.deleteTypeMetadonnee(typeMetadonnee);
    }
	
	@RequestMapping( value = "/typeMetadonnees", method = RequestMethod.GET )
    public List<TypeMetadonneeDTO> getAllTypeMetadonnee( ) {
    	
        return metier.getAllTypeMetadonnees();
    }
	
	@RequestMapping( value = "/typeMetadonnees", method = RequestMethod.PUT )
	public void SetTypeMetadonneeById (@RequestParam String nom, @RequestParam String type,@RequestParam Long id){
		 metier.SetTypeMetadonneeById(nom, type, id);
	}
	
	@RequestMapping( value = "/typeMetadonnees/all", method = RequestMethod.DELETE )
    public void deleteSelectedTypeMetadonnee(@RequestBody Collection<TypeMetadonneeDTO> c) {
		metier.deleteSelectedTypeMetadonnee(c);
    }
	
	@RequestMapping( value = "/typeMetadonnees/ids", method = RequestMethod.GET )
	public Collection<TypeMetadonneeDTO> getListTypeMetadonneeById(@RequestBody Collection<Long> ids){
		return metier.getListTypeMetadonneeById(ids);
	}
	
	
	
	
	

}
