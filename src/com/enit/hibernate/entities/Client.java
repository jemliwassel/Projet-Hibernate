package com.enit.hibernate.entities;

import java.io.Serializable;

public class Client implements Serializable{
 private Long idClient;
 private String nom;
 private String adresse;
 
public String getAdresse() {
	return adresse;}

public void setAdresse(String adresse) {
	this.adresse = adresse;
}


public Long getIdClient() {
	return idClient;
}
public void setIdClient(Long idClient) {
	this.idClient = idClient;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
@Override
public String toString() {
	return "Client [idClient=" + idClient + ", nom=" + nom + ", adresse=" + adresse + "]";
}

}
