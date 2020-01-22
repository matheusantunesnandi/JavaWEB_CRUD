package util;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import model.dao.DAOGenerico;

@WebListener
public class JDBCDriveListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent servletContextEvent) {
		System.out.println("************** Starting up! **************");
	}

	/**
	 * Este método é executado quando o servidor é desligado. Ele removerá todos os
	 * registros de Drivers. Método implementado para contornar o erro da versão
	 * mais atual do TomCat que não remove o Drive do SQLite se ele não estiver
	 * interno no próprio servidor Web, e não na aplicação.
	 */
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		System.out.println("************** Shutting down! **************");
		System.out.println("Destroying Context...");
		DAOGenerico.getInstance().getSessionFactory().close();

		ClassLoader cl = Thread.currentThread().getContextClassLoader();

		Enumeration<Driver> drivers = DriverManager.getDrivers();
		while (drivers.hasMoreElements()) {
			Driver driver = drivers.nextElement();

			if (driver.getClass().getClassLoader() == cl) {
				try {
					System.out.println("Deregistering JDBC driver {}");
					DriverManager.deregisterDriver(driver);

				} catch (SQLException ex) {
					System.out.println("Error deregistering JDBC driver {}");
					ex.printStackTrace();
				}
			} else {
				System.out.println("Not deregistering JDBC driver {} as it does not belong to this webapp's ClassLoader");
			}
		}
	}

}