package fr.eseo.criticalPfe.java.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.eseo.criticalPfe.config.Messages;
import fr.eseo.criticalPfe.java.utils.Log;

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

			connection = DriverManager.getConnection("jdbc:mysql://" + BDD_HOST + ":" + BDD_PORT + "/" + BDD_DB
					+ "?user=" + BDD_USER + "&password=" + BDD_PASS + "&useUnicode=true&characterEncoding=utf8&autoReconnect=true&useSSL=false");

		} catch (SQLException | ClassNotFoundException e) {
			Log.warning(e.toString());
		}

		return connection;
	}

	public ResultSet selectFromDataBase(String sqlQuery) {
		Statement stmt;
		ResultSet rset = null;
		try {
			stmt = this.connection.createStatement();

			// stmt = conn.createStatement();
			if (stmt.execute(sqlQuery)) {
				rset = stmt.getResultSet();
			}
		} catch (SQLException e) {
			Log.warning(e.toString());
		}
		return rset;
	}

	public void requestToDataBase(String insert){
		try {
			this.connection.createStatement().execute(insert);
		} catch (SQLException e) {
			Log.warning(e.toString());
		}
	}

	public void closeRequestToDataBase() throws SQLException {

		if (this.connection != null) {
			this.connection.close();
			this.connection = null;
		}
	}

}
