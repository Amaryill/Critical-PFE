package fr.eseo.criticalPfe.java.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.eseo.criticalPfe.config.Messages;
import fr.eseo.criticalPfe.java.utils.Log;

public class ConnexionBDD {
	private final String GET_LAST_ID = 	"SELECT LAST_INSERT_ID()";
	
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

	public boolean requestToDataBase(String insert){
		boolean result = false;
	    try {
			result = this.connection.createStatement().execute(insert);
			result = true;
		} catch (SQLException e) {
			Log.warning(e.toString());
		}
	    return result;
	}

	public void closeRequestToDataBase() throws SQLException {

		if (this.connection != null) {
			this.connection.close();
			this.connection = null;
		}
	}
	

	public Integer getLastId(String table) throws SQLException{
		Integer id = null;
		// TODO Rajouter from table
		ResultSet result = this.selectFromDataBase("SELECT `Id` FROM "+table+" WHERE id = (SELECT max(id) FROM "+table+")");
		
		while(result.next()){
			id = result.getInt(1);
		}
		
		return id;
	}

	  public Connection getCo() throws SQLException {
	        return DriverManager.getConnection("jdbc:mysql://" + BDD_HOST + ":" + BDD_PORT + "/" + BDD_DB, BDD_USER, BDD_PASS);
	    }
	

}
