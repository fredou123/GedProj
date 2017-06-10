package com.ged.service.implementation;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ged.dao.DocumentRepository;
import com.ged.entities.Document;
import com.ged.service.DocumentService;

@Service
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    DocumentRepository documentRepository;

    @Override
    public Document saveDocument( Document document ) {

        return documentRepository.save( document );

    }

    @Override
    public Document getDocument( Long id ) {

        return documentRepository.findOne(id);
    }

    @Override
    public Document SetDocument( Document document, String newNom ) {

        Document doc = documentRepository.findOne( document.getId() );
        doc.setNom(newNom);
        return doc;
    }

    @Override
    public Document DeleteDocument( Document document ) {

    	documentRepository.delete(document);
    	return document;
    	
    }

	@Override
	public Collection<Document> getAllDocument() {
		return documentRepository.findAll();
	}

}
