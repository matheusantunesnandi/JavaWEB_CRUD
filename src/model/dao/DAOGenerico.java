package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.SessionFactory;

import util.HibernateUtil;

public class DAOGenerico {

	// Declaração estática do DAOGenerico para que o mesmo seja compartilhado entre todas as sessões que poderão ser abertas via navegador.
	public static DAOGenerico daoGenerico = null;
	
	private SessionFactory sessionFactory;
	private EntityManagerFactory entityManagerFactory;

	public DAOGenerico() {
		sessionFactory = HibernateUtil.getSessionFactory();
		entityManagerFactory = sessionFactory.openSession().getEntityManagerFactory();
	}

	// Método para recuperar o DAOGenerico compartilhado, pois a cada sessão um novo DAO seria criado, porém é recuperado o que estiver em memória.
	// Evia que várias conexões prncipais sejam abertas com o mesmo banco. Todavia as requisições são feitas e fechadas em cada ação de cada sessão aberta.
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
		boolean retorno = false;

		String nomeMetodoAnterior = new Throwable().getStackTrace()[1].getMethodName();

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		try {
			entityManager.getTransaction().begin();

			switch (nomeMetodoAnterior) {
			case "inserir":
				entityManager.persist(o);

				break;

			case "atualizar":
				entityManager.merge(o);

				break;

			case "remover":
				entityManager.remove(o);

				break;
			}

			entityManager.getTransaction().commit();

			retorno = true;

		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();

		} finally {
			// TODO: Validar alternativa de só fechar quando o a sessão fechar e se isto é
			// uma melhor forma / viável.
			entityManager.close();
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
		List<T> queryResult = null;

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		try {
			entityManager.getTransaction().begin();

			CriteriaBuilder builder = entityManagerFactory.getCriteriaBuilder();
			CriteriaQuery<T> criteria = builder.createQuery(classe);
			Root<T> root = criteria.from(classe);
			criteria.select(root);

			queryResult = entityManager.createQuery(criteria).getResultList();

			entityManager.getTransaction().commit();

		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();

		} finally {
			// TODO: Validar alternativa de só fechar quando o a sessão fechar e se isto é
			// uma melhor forma / viável.
			entityManager.close();
		}

		return queryResult;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}
}
