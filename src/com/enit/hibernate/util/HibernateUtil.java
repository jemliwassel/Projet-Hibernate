 package com.enit.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import org.hibernate.HibernateException;
import org.hibernate.Session;



public class HibernateUtil {

    public static final SessionFactory sessionFactory;
    public static final ThreadLocal session = new ThreadLocal();

    static {
        try {
            // Création de la SessionFactory �  partir de hibernate.cfg.xml
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (HibernateException ex) {
            System.out.println("Initial SessionFactory creation failed." + ex);
            throw new RuntimeException("Problème de configuration : " + ex.getMessage());
        }
    }

     // Singleton
    public static Session currentSession() throws HibernateException {
    	
        Session s = (Session) session.get();
        // Ouvre une nouvelle Session, si ce Thread n'en a aucune
        if (s == null) {
            s = sessionFactory.openSession();
            session.set(s);
        }
        return s;
    }

    public static void closeSession() throws HibernateException {
        Session s = (Session) session.get();
        session.set(null);
        if (s != null) {
            s.close();
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}