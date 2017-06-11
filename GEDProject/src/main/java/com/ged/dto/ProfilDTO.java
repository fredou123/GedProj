package com.ged.dto;

import org.springframework.security.core.GrantedAuthority;

import com.ged.entities.Profil;

public class ProfilDTO implements GrantedAuthority{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String authority;
	private String description;
	
	
	
	public ProfilDTO(String authority, String description) {
		super();
		this.authority = authority;
		this.description = description;
	}
	
	public ProfilDTO(Profil profil){
		this.authority = profil.getNom();
	}

	@Override
	public String getAuthority() {
		return authority;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	

}
