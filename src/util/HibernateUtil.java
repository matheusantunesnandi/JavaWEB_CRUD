package util;

import java.util.HashMap;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import model.entity.Cruzeiro;
import model.entity.Embarcacao;
import model.entity.Pessoa;

public class HibernateUtil {

	private static StandardServiceRegistry registry;
	private static SessionFactory sessionFactory = null;
	private static String NOME_DB = "Cruzeiro.sqlite3";
	private static String CAMINHO_DB = PropriedadesProjeto.caminhoProjeto + NOME_DB;

	static {
		try {

			// TODO Lembrete: hibernate.cfg.xml não está sendo usado
//			metodoTradicional();

			metodoAlternativo();

		} catch (Throwable t) {
			System.err.println("Initial SessionFactory creation failed." + t);
			throw new ExceptionInInitializerError(t);
		}
	}

	@SuppressWarnings("unused")
	private static void metodoTradicional() {
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}

	/**
	 * Este método cria em memória o conteúdo do sessionFactory de forma semelhante
	 * ao método tradicional, porém sem uso de arquivo XML externo.
	 */
	private static void metodoAlternativo() {
		StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();

		HashMap<String, String> settings = new HashMap<>();
		settings.put("hibernate.connection.driver_class", "org.sqlite.JDBC");
		settings.put("hibernate.connection.url", "jdbc:sqlite:" + CAMINHO_DB);
//		settings.put("hibernate.hbm2ddl.auto", "none");
		settings.put("hibernate.hbm2ddl.auto", "update");
//		settings.put("hibernate.hbm2ddl.auto", "create-drop");
		settings.put("hibernate.cache.provider_class", "org.hibernate.cache.NoCacheProvider");
		settings.put("hibernate.format_sql", "true");
		settings.put("hibernate.show_sql", "true");
		settings.put("hibernate.dialect", "org.hibernate.dialect.SQLiteDialect");
		settings.put("hibernate.connection.autocommit", "true");

		registryBuilder.applySettings(settings);
		registry = registryBuilder.build();

		MetadataSources sources = new MetadataSources(registry);
		sources.addAnnotatedClass(Pessoa.class);
		sources.addAnnotatedClass(Embarcacao.class);
		sources.addAnnotatedClass(Cruzeiro.class);

		sessionFactory = sources.buildMetadata().buildSessionFactory();

		System.out.println("Caminho do banco de dados: \n" + CAMINHO_DB);
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void setSessionFactory(SessionFactory sessionFactory) {
		HibernateUtil.sessionFactory = sessionFactory;
	}
}
