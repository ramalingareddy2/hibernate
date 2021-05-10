package com.sar.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import org.hibernate.service.spi.Configurable;
import org.hibernate.service.spi.Startable;
import org.hibernate.service.spi.Stoppable;

/**
 * This is the our blaze connection management framework, we are plugging in our
 * framework connection technic into hibernate
 * 
 * @author Sriman
 *
 */
public class BlazeConnectionProviderImpl implements ConnectionProvider, Configurable, Startable, Stoppable {
	private String driverClassname;
	private String url;
	private String username;
	private String password;

	@Override
	public boolean isUnwrappableAs(Class unwrapType) {
		return false;
	}

	@Override
	public <T> T unwrap(Class<T> unwrapType) {
		return null;
	}

	@Override
	public void stop() {
		System.out.println("BlazeConnectionProviderImpl.stop();");

		driverClassname = null;
		url = null;
		username = null;
		password = null;
	}

	@Override
	public void start() {
		try {
			System.out.println("BlazeConnectionProviderImpl.start();");
			Class.forName(driverClassname);
		} catch (ClassNotFoundException e) {
			throw new HibernateException("error while loading jdbc driver", e);
		}
	}

	@Override
	public void configure(Map configurationValues) {
		System.out.println("BlazeConnectionProviderImpl.configure(configurationValues);");

		driverClassname = (String) configurationValues.get("connection.driver_class");
		url = (String) configurationValues.get("connection.url");
		username = (String) configurationValues.get("connection.username");
		password = (String) configurationValues.get("connection.password");
	}

	@Override
	public Connection getConnection() throws SQLException {
		System.out.println("BlazeConnectionProviderImpl.getConnection();");
		Connection con = DriverManager.getConnection(url, username, password);
		con.setAutoCommit(false);
		return con;
	}

	@Override
	public void closeConnection(Connection conn) throws SQLException {
		System.out.println("BlazeConnectionProviderImpl.closeConnection(con);");
		if (conn != null && conn.isClosed() == false) {
			conn.close();
		}
	}

	@Override
	public boolean supportsAggressiveRelease() {
		return true;
	}

}
