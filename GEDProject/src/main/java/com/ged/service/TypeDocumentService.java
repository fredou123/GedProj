package com.ged.service;

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
import com.ged.dto.TypeDocumentTypeMetadonneeDTO;
import com.ged.dto.TypeDossierTypeDocumentDTO;
import com.ged.entities.TypeDocument;
import com.ged.entities.TypeDocumentTypeMetadonnee;
import com.ged.metier.TypeDocumentMetier;
import com.ged.metier.TypeDocumentTypeMetadonneeMetier;

@RestController
public class TypeDocumentService {
	
	@Autowired
	private TypeDocumentMetier metier;
	@Autowired
	private TypeDocumentTypeMetadonneeMetier metier1;
	
	
    public TypeDocumentDTO saveTypeDocument( @RequestBody TypeDocumentDTO td ) {
       
        return metier.saveTypeDocument(td);
    }
    @RequestMapping( value = "/typeDocuments", method = RequestMethod.POST )
	public TypeDocumentDTO saveTypeDocument(@RequestBody TypeDocumentDTO typeDocumentDto, 
			@RequestBody List<TypeDocumentTypeMetadonneeDTO> listDocMeta,
			@RequestBody List<TypeDossierTypeDocumentDTO> listDosDoc){
		return metier.saveTypeDocument(typeDocumentDto, listDocMeta, listDosDoc);
	}
	
	@RequestMapping( value = "/typeDocuments/{id}", method = RequestMethod.GET )
    public TypeDocument getTypeDocument( @PathVariable Long id ) {
    	
        return metier.getTypeDocument( id );
    }
	
	
	@RequestMapping( value = "/typeDocuments", method = RequestMethod.DELETE )
    public TypeDocument deleteTypeDocument( @RequestBody TypeDocument typeDocument ) {
		 if (typeDocument.getTypeDocumentTypeMetadonnees()!=null){
			 for(TypeDocumentTypeMetadonnee t : typeDocument.getTypeDocumentTypeMetadonnees()){
				 metier1.deleteTypeDocumentTypeMetadonnee(t);
			 }
		 }
         return metier.deleteTypeDocument(typeDocument);
    }
	
	@RequestMapping( value = "/typeDocuments", method = RequestMethod.GET )
    public List<TypeDocumentDTO> getAllTypeDocument( ) {
    	
        return metier.getAllTypeDocuments();
    }
	
	@RequestMapping( value = "/typeDocuments", method = RequestMethod.PUT )
	public void SetTypeDocumentById (@RequestParam String nom, @RequestParam Long id){
		 metier.SetTypeDocumentById(nom, id);
	}
	
	@RequestMapping( value = "/typeDocuments/all", method = RequestMethod.DELETE )
    public void deleteSelectedTypeDocument(@RequestBody Collection<TypeDocument> c) {
		metier.deleteSelectedTypeDocument(c);
    }
	
	@RequestMapping( value = "/typeDocuments/ids", method = RequestMethod.GET )
	public Collection<TypeDocument> getListTypeDocumentById(@RequestBody Collection<Long> ids){
		return metier.getListTypeDocumentById(ids);
	}

}
