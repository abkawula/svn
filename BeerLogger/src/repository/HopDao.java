package repository;

import org.hibernate.Session;
import org.hibernate.Transaction;

import domain.Hop;

public class HopDao extends BeerHibernateUtil{

	public void save(Hop hop) {
		Session session = null;
		Transaction transaction = null;
		
		try {
			session = sessionFactory.getCurrentSession();
			transaction = session.beginTransaction();
			
			session.save(hop);
			
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
