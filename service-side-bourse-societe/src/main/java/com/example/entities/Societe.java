package com.example.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Societe implements Serializable {
	@Id
	@GeneratedValue
	private long id;
	private String nom;

	public Societe() {
	}

	public Societe(String nom) {
		super();
		this.nom = nom;
	}

	public long getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}
