package com.ged.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ged.entities.Document;
import com.ged.metier.DocumentMetier;


@RestController
public class DocumentService {

    @Autowired
    private DocumentMetier documentMetier;

    @RequestMapping( value = "/documents", method = RequestMethod.POST )
    public Document SaveDocument( @RequestBody Document document ) {
    	
        return documentMetier.saveDocument( document );
    }

    @RequestMapping( value = "/documents/{id}", method = RequestMethod.GET )
    public Document getDocument( @PathVariable Long id ) {
    	
        return documentMetier.getDocument( id );
    }
    
    @RequestMapping( value = "/documents", method = RequestMethod.GET )
    public Collection<Document> getAllDocument( ) {
    	
        return documentMetier.getAllDocument();
    }
    
    @RequestMapping( value = "/documents", method = RequestMethod.DELETE )
    public Document DeleteDocument( @RequestBody Document document ) {
    	
         documentMetier.DeleteDocument( document );
         return document;
    }
    
    @RequestMapping( value = "/documents/{id}/{newNom}", method = RequestMethod.PUT )
    public Document SetDocument( @PathVariable Document document, @PathVariable String newNom ) {
    	
        return documentMetier.SetDocument( document, newNom );
    }

}
