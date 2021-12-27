package com.enit.hibernate.tests;

import com.enit.hibernate.dao.ClientDao;
import com.enit.hibernate.entities.Client;

public class TestHibernate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	ClientDao clientDao	=ClientDao.getInstance();
Client cl1= new Client ();
	cl1.setNom("Fourati");
	cl1.setAdresse("La marsa");
	
	    clientDao.addClient("HAJJI", "Ariana");
	    clientDao.addClient("Rekik", "Ariana");
	    clientDao.addClient("Ben amor", "Tunis");
	    clientDao.addClient("Ben Abdallah", "Manouba");
	    clientDao.addClient(cl1);
	  
	    
	
/*	Client cl= clientDao.searchClient(3);
	
	System.out.println("\n \n le client recherché est objet persistant: "+ cl );
	
	
	cl.setAdresse("Sfax");
     
	clientDao.mettreAjour(cl);*/
	
//	clientDao.suppClient(1);
	
	

	

		    
	}

}
