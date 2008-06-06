package dbObjects;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class CharacterTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		Session session = null;
		SessionFactory sessionFactory = null;
		Transaction tx = null;
		try {
			// Create a session factory from the configuration hibernate.properties
			// File should be present in the class path)
			AnnotationConfiguration cfg = new AnnotationConfiguration();
			cfg.addAnnotatedClass(Character.class);
//			cfg.addAnnotatedClass(Item.class);
			cfg.configure();
			sessionFactory = cfg.buildSessionFactory();
			// Create a session
	      	session = sessionFactory.openSession();
	      	// Begin a transaction
	      	tx = session.beginTransaction ();
	   
	      	Character conan = new Character();
	      	conan.setName("Conan");
	      	conan.setStrength(18);
	      	conan.setWisdom(4);
		  	session.save(conan);
		  	
		  	tx.commit ();
		}catch(Exception ex){
			ex.printStackTrace();
		}finally {
			if (session != null) {
				// Close the session
				session.close();
			}
		}
		
	}

}
