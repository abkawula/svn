package repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class BeerHibernateUtil {

    protected static final SessionFactory sessionFactory;

    static {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
//    public static void transactionRetrieve(Object o, String member) {
//    	Session session = null;
//    	Transaction transaction = null;
//    	
//    	try {
//    		session = sessionFactory.getCurrentSession();
//    		transaction = session.beginTransaction();
//    		
//    		String methodName = "get" + StringUtils.capitalize(member);
//    		Method relationshipMethod = o.getClass().getMethod(methodName, null);
//			relationshipMethod.invoke(o, null);
//    	} catch (Exception e) {
//    		e.printStackTrace();
//    		transaction.rollback();
//    	} finally {
//    		if (session != null && session.isOpen()) {
//    			session.close();
//    		}
//    	}
//    }

    public void save(Object object) {
		Session session = null;
		Transaction transaction = null;
		
		try {
			session = sessionFactory.getCurrentSession();
			transaction = session.beginTransaction();
			
			session.save(object);
			
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}
    
    
	
}
