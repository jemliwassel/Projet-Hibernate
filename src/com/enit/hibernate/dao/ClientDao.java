package com.enit.hibernate.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.enit.hibernate.entities.Client;
import com.enit.hibernate.util.HibernateUtil;

public class ClientDao {
	
	
private static ClientDao clientDao;
	
	private ClientDao() {
		
	}
	
	//patron singleton

	public static ClientDao getInstance() {
		if(clientDao== null) 
			clientDao = new ClientDao();
		
		
			return clientDao;
		
	}
	

	public void addClient(String nom,String add){

		Session session=HibernateUtil.currentSession();
	try{
		session.beginTransaction();
		Client cl=new Client();
		cl.setNom(nom);
		cl.setAdresse(add);
		session.save(cl);
		session.getTransaction().commit();
	}
	catch(HibernateException h){
		session.getTransaction().rollback();

	}
	}
	
	public Client searchClient(long id) {
		
		Session session=HibernateUtil.currentSession();
  Client cl=null;
		try {
			session.beginTransaction();
			cl=(Client) session.get(Client.class, id);
			session.getTransaction().commit();
		}
		catch(HibernateException h){
			session.getTransaction().rollback();

		}
		 
		return cl;
		
	}
	
	public void mettreAjour(Client cl) {
		Session session=HibernateUtil.currentSession();

		try {
		session.beginTransaction();
		session.update(cl);
			session.getTransaction().commit();
		}
		catch(HibernateException h){
			session.getTransaction().rollback();

	}

		
	}
	public void addClient(Client cl){

		Session session=HibernateUtil.currentSession();
	try{
		session.beginTransaction();
		
		session.save(cl);
		session.getTransaction().commit();
	}
	catch(HibernateException h){
		session.getTransaction().rollback();
		

	}
	}
	
	
	public void suppClient(long idClient) {
	
		Session session=HibernateUtil.currentSession();
		try{
			session.beginTransaction();
			
		Client cl=	(Client)session.get(Client.class,idClient);
		session.delete(cl);
			session.getTransaction().commit();
		}
		catch(HibernateException h){
			session.getTransaction().rollback();

		}
		
	}
	
}
