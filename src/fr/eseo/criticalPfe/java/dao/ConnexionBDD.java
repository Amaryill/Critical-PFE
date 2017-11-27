package fr.eseo.criticalPfe.java.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.eseo.criticalPfe.config.Messages;

public class ConnexionBDD {
	private static final String BDD_HOST = Messages.getString("host_bdd");
	private static final String BDD_PORT = Messages.getString("port_bdd");
	private static final String BDD_USER = Messages.getString("user");
	private static final String BDD_PASS = Messages.getString("pass");
	private static final String BDD_DB = Messages.getString("database");
	
	private static ConnexionBDD conn;
	private Connection connection;

	private ConnexionBDD() {
		this.connection = this.ouvrir();
	}

	public static ConnexionBDD getConnexion() {
		if (conn == null) {
			conn = new ConnexionBDD();
		}
		return conn;
	}

	/**
	 * Ouverture de la connexion à la base de données
	 * 
	 * @return Connection connexion à la base de données
	 */
	private Connection ouvrir() {
		Connection connection = null;
		try {
			

			

			Class.forName("com.mysql.jdbc.Driver");

			connection = DriverManager.getConnection(
					"jdbc:mysql://" + BDD_HOST + ":" + BDD_PORT + "/" + BDD_DB + "?user=" + BDD_USER + "&password=" + BDD_PASS);

			// conn = DriverManager.getConnection(URL, user, password);

		} catch (SQLException | ClassNotFoundException e) {
		}

		return connection;
	}

	public ResultSet requestFromDataBase(String sqlQuery) throws SQLException {
		Statement stmt = this.connection.createStatement();
		// stmt = conn.createStatement();
		ResultSet rset = null;
		if (stmt.execute(sqlQuery)) {
			rset = stmt.getResultSet();
		}
		return rset;
	}

	public void insertIntoDataBase(String insert) throws SQLException {
		this.connection.createStatement().execute(insert);
	}

	public void closeRequestToDataBase() throws SQLException {

		if (this.connection != null) {
			this.connection.close();
			this.connection = null;
		}
	}
	
	
	
}
