package com.ged.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.springframework.security.core.GrantedAuthority;

@SuppressWarnings("serial")
@Entity
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_user")
	private Long id;
	private String nom;
	private String prenom;
	private String login;
	private String mdp;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name= "user_profil", joinColumns= @JoinColumn (name="id_user"), inverseJoinColumns = @JoinColumn(name="id_profil"))  
	private Collection<Profil> profils;
	@OneToMany
	private Collection<HistoriqueConnexion> connexions;
	@ManyToMany
	private Collection<Groupe> groupes;

	private boolean accountNonExpired;

	private boolean accountNonLocked;

	private boolean credentialsNonExpired;

	private boolean enabled;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public Long getId() {
		return id;
	}

	public Collection<Profil> getProfils() {
		return profils;
	}

	public void setProfils(Collection<Profil> profils) {
		this.profils = profils;
	}

	public Collection<HistoriqueConnexion> getConnexions() {
		return connexions;
	}

	public void setConnexions(Collection<HistoriqueConnexion> connexions) {
		this.connexions = connexions;
	}

	public Collection<Groupe> getGroupes() {
		return groupes;
	}

	public void setGroupes(Collection<Groupe> groupes) {
		this.groupes = groupes;
	}

	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User() {

	}

}
