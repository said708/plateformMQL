package org.mql.test.hibernate;

import java.sql.Connection;
import java.sql.DriverManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class App1 {
	private static SessionFactory factory; 
	public App1() {
		exp02();
	}

	private void exp01() {
		String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/hb_student_tracker?useSSL=false";
		String user = "hbstudent";
		String password = "hbstudent";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("connecting to database :"+jdbcUrl);
			 Connection con = DriverManager.getConnection(jdbcUrl , user , password);
			System.out.println("Connection successful !!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	private void exp02() {
		try {
			Author said = new Author(2, "said", 1990);
            // Create the SessionFactory from hibernate.cfg.xml
        
        	
        	
        	
        	SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        	
        	System.out.println("Hibernate Configuration loaded");
        	
        	System.out.println("Hibernate serviceRegistry created");
        	
        	
        	
        	
        	
        	Session session = sessionFactory.getCurrentSession();
        	
        	
        	//start transaction
    		session.beginTransaction();
    		//Save the Model object
    		session.save(said);
    		//Commit transaction
    		session.getTransaction().commit();
    		System.out.println("Author ID="+said.getId());
    		
    		//terminate session factory, otherwise program won't end
    		session.close();
//            return sessionFactory;
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
//            throw new ExceptionInInitializerError(ex);
        }
    }

	

	public static void main(String[] args) {
		new App1();

	}

}
