package model.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.entity.Pessoa;
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
		return operacao(o);
	}

	public boolean atualizar(Object o) {
		return operacao(o);
	}

	public boolean remover(Object o) {
		return operacao(o);
	}

	public boolean operacao(Object o) {
		return operacao(o, new Throwable().getStackTrace()[1].getMethodName());
	}

	public boolean operacao(Object o, String nomeDoMetoco) {
		boolean retorno = false;

		Session session = sessionFactory.openSession();

		try {
			transaction = session.beginTransaction();

			switch (nomeDoMetoco) {
			case "inserir":
				session.save(o);

				break;

			case "atualizar":
				session.update(o);

				break;

			case "remover":
				Pessoa p = (Pessoa) o;
				p.setId(1);
				session.remove(o);

				break;
			}

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

	/**
	 * Retorna a lista de itens salvo no banco de dados de acordo com a Entidade
	 * passada como parâmetro.
	 * 
	 * @param <T>
	 * @param <T>
	 * 
	 * @param classe : Entidade que deverá buscar no banco de dados.
	 * @return List contendo todos os objetos encontrados da entidade passada como
	 *         parâmetro.
	 */
	public <T> List<T> listar(Class<T> classe) {
		Session session = sessionFactory.openSession();

		List<T> queryResult = null;

		try {
			transaction = session.beginTransaction();

			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<T> criteria = builder.createQuery(classe);
			Root<T> root = criteria.from(classe);
			criteria.select(root);

			queryResult = session.createQuery(criteria).getResultList();

			transaction.commit();

		} catch (Exception e) {
			transaction.getRollbackOnly();
			e.printStackTrace();

		} finally {
			session.close();
		}

		return queryResult;
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
