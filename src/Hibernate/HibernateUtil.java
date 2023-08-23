package Hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	// bir singleton oluşturup her yerde sadece bir nesneyi kullanacağız 
	
	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {

		try {
			Configuration cfg = new  Configuration();
			SessionFactory sessionFactory = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
			
			//ServiceRegistry serviceRegistery = new StandardServiceRegistryBuilder().configure().loadProperties("hibernate.cfg.xml").build();		
			
			return sessionFactory;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ExceptionInInitializerError();
		}
		
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
