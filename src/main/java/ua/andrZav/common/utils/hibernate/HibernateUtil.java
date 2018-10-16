package ua.andrZav.common.utils.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory = null; // new Configuration().configure().buildSessionFactory();
    private static SessionFactory buildSessionFactory() {
        try{
            // Create the SessionFactory from hibernate.cfg.xml
            return new Configuration().configure("/hibernate.cfg.xml").buildSessionFactory();
        } catch (Throwable ex){
            // Make sure you log the exception, as it might be swallowed
            // throw new ExceptionInInitializerError("Cannot create Hibernate session factory!");
            // ex.printStackTrace();
            throw new ExceptionInInitializerError("Error loading hibernate.cfg.xml. Exception: " + ex.getMessage());
        }
    }

    public static SessionFactory getSessionFactory(){
        if (sessionFactory == null) {
            sessionFactory = buildSessionFactory();
        }
        return sessionFactory;
    }

    public static void shutdown(){
        sessionFactory.close();
    }
}
