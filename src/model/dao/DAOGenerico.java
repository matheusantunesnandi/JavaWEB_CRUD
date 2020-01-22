package model.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import util.HibernateUtil;

public class DAOGenerico {

	public static DAOGenerico daoGenerico = null;

	private SessionFactory sessionFactory;
	private Transaction transaction;

	public DAOGenerico() {
		sessionFactory = HibernateUtil.getSessionFactory();
	}

	public static DAOGenerico getInstance() {
		if (daoGenerico == null) {
			daoGenerico = new DAOGenerico();
		}

		return daoGenerico;
	}

	public boolean inserir(Object o) {
		boolean retorno = false;

		Session session = sessionFactory.openSession();

		try {
			transaction = session.beginTransaction();
			session.save(o);
			transaction.commit();

			retorno = true;

		} catch (Exception e) {
			transaction.getRollbackOnly();
			e.printStackTrace();

		} finally {
			session.close();
		}

		return retorno;
	}

	public void transacao() {

	}

	public boolean atualizar(Object o) {
		// TODO hibernate atualizar(..)
		return false;
	}

	public boolean remover(Object o) {
		// TODO hibernate remover(..)
		return false;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

}
