package com.ged.service;

import java.util.Collection;

import com.ged.entities.Document;

public interface DocumentService {

    public Document saveDocument( Document document );

    public Document getDocument( Long id );

    public Document SetDocument( Document document, String newNom );

    public Document DeleteDocument( Document document );
    
    public Collection<Document> getAllDocument ();
}
