package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory sessionFactory = null;

	static {
		try {

			sessionFactory = new Configuration().configure().buildSessionFactory();

		} catch (Throwable t) {
			System.err.println("Initial SessionFactory creation failed." + t);
			throw new ExceptionInInitializerError(t);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void setSessionFactory(SessionFactory sessionFactory) {
		HibernateUtil.sessionFactory = sessionFactory;
	}
}
