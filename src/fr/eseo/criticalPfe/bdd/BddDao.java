wpackage fr.eseo.criticalPfe.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.eseo.criticalPfe.config.Messages;
import fr.eseo.criticalPfe.java.utils.Log;

public class BddDao {
	/**
	 * Constantes de classe BddDAO
	 */
	private static final String BDD_HOST = Messages.getString("host_bdd");
	private static final String BDD_PORT = Messages.getString("port_bdd");
	private static final String BDD_USER = Messages.getString("user");
	private static final String BDD_PASS = Messages.getString("pass");
	private static final String BDD_DB = Messages.getString("database");
	
	
	Connection connexion = null;
	PreparedStatement prepStmt= null;
	Statement stmt = null;
	ResultSet rset = null;

	/**
	 *Constructeur -> charge le driver et crée la connexion à la bdd
	 */
	public BddDao() {
		chargementDriver();
		connexion();
	}

	/**
	 * Charge le JDBC driver
	 */
	private void chargementDriver() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		} catch (ClassNotFoundException  e  ) { 
			Log.warning("Erreur lors du chargement du driver mysql: " + e.toString());
		}catch(SQLException s){
			Log.warning("Erreur lors du chargement du driver mysql: " + s.toString());
		}
	}
	
	/**
	 * 
	 */
	private void connexion(){
		try {
			this.connexion = DriverManager.getConnection("jdbc:mysql://"+ BDD_HOST + ":"+ BDD_PORT +"/"+ BDD_DB,BDD_USER,BDD_PASS);
			Log.info("connexion ok " + connexion);
			// We now prepare statement and not create
			this.stmt = this.connexion.createStatement();
			Log.info("Statement created...");
		} catch (SQLException e) {
			Log.warning(e.toString());  
		}
	}
	
	/**
	 * 
	 * @param stmt
	 */
	public void prepareStmt(String stmt){
		try {
			this.prepStmt=this.connexion.prepareStatement(stmt);
		} catch (SQLException e) {
			Log.warning(e.toString());
		}
	}
	
	/**
	 * 
	 * @param q, String query à exécuter
	 * @return ResultSet du query, null si aucun résultat
	 */
	public void setPrepStmt(String[] stringStmt){
		for(int i = 0; i < stringStmt.length; i++){
			try {
				this.prepStmt.setString(i+1,stringStmt[i]);
			} catch (SQLException e) {
				Log.warning(e.toString());
			}
		}
	}
	
	/**
	 * 
	 * @param q
	 * @return
	 */
	public ResultSet execute(String q){
		try {
			if(this.stmt.execute(q)){
				this.rset = this.stmt.getResultSet();
			}else{
				this.rset = null;
			}
		} catch (SQLException e) {
			Log.warning(e.toString());
		}
		return this.rset;
	}
	
	/**
	 * 
	 * @return
	 */
	public ResultSet executePrep(){
		try {
			if(this.prepStmt.execute()){
				this.rset = this.prepStmt.getResultSet();
			}else{
				this.rset = null;
			}
		} catch (SQLException e) {
			Log.warning(e.toString()); 
		}
		return this.rset;
	}
	
	/**
	 * 
	 */
	public void closeRset(){
		try {
			this.rset.close();
		} catch (SQLException e) {
			Log.warning(e.toString());
		}
	}
	
	/**
	 * 
	 */
	public void closeBdd(){
		try {
			if (prepStmt!=null){
				this.prepStmt.close();
			}
			this.stmt.close();
			this.connexion.close();
		} catch (SQLException e) {
			Log.warning(e.toString());
		}
	}
}
