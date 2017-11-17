package fr.eseo.criticalPfe.bdd;

import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eseo.criticalPfe.bdd.BddDao;
import fr.eseo.criticalPfe.config.Messages;
import fr.eseo.criticalPfe.java.utils.Log;

public class BddBo {
	/**
	 * Attributs de classe BddBO
	 */
	private BddDao bdd;
	private String selectAllFrom = "SELECT * FROM ";
	private String insert = "INSERT INTO ";
	private String values = " values('";
	private String success = "Success";
	
	/**
	 * Constantes de classe BddBO
	 */
	
	private static final String TABLE_UTILISATEUR = Messages.getString("table_Utilisateur");
	private static final String NORESULT = "No result";
	
	/**
	 * Instance de BddBo, creation de la connexion à la bdd
	 */
	public BddBo() {
		this.bdd = new BddDao();
	}
	
	/**
	 * Retourne la bdd
	 * @return
	 */
	public BddDao getBdd() {
		return bdd;
	}
	
	/**
	 * Set la bdd
	 * @param bdd
	 */
	public void setBdd(BddDao bdd) {
		this.bdd = bdd;
	}
	
	/**
	 * Récupère les utilisateurs et leurs paramètres
	 * 
	 * @param userName
	 * @param userPassword
	 * @return User de la bdd (si present) -> Array:[username,password,mail]
	 */
	public String[] getUser(String userName, String userPassword){
		int size = 4;
		/*
		 *  Needed to UPDATE `users` SET `password`=PASSWORD("mdptest") WHERE username="test"
		 *  for each password in the bdd to secure it
		 */
		String[] result = new String[size];
		
		//SECURITY
		String selectUser = selectAllFrom +TABLE_UTILISATEUR+" WHERE login=? AND password=?";
		Log.info("Try to get user from BDD... ");
		String[] paramStmt= {userName,userPassword};
		this.bdd.prepareStmt(selectUser);
		this.bdd.setPrepStmt(paramStmt);
		ResultSet rset = this.bdd.executePrep();
		//END SECURITY
		
		if(rset != null){
			try{
				while (rset.next()) {
					for(int i = 0; i< size; i++){
						result[i] = rset.getString(i+1);
					}
				}
			}catch(SQLException e){
				Log.warning(e.toString());
			}finally{
				Log.info(success);
				bdd.closeRset();
			}
		}else{
			Log.info(NORESULT);
			bdd.closeRset();
		}
		return result;
	}
	
	/*
	 * Crée un compte dans la bdd
	 * 
	 * @param pseudo
	 * @param mdp
	 * @param mail
	 */
	
	public void signUp(String pseudo, String mdp, String mail){
		
		String insertUser = insert + TABLE_UTILISATEUR + values + pseudo+"','"+mdp+"','"+mail+"','');";
		this.bdd.prepareStmt(insertUser);
		ResultSet rset = this.bdd.executePrep();
		
	}
	
	public String getMdp (String pseudo) throws SQLException{
		String mdpBdd="";
		String getPassword = "select password from utilisateur where login='"+pseudo+"';";
		this.bdd.prepareStmt(getPassword);
		ResultSet resultatMdpBdd = this.bdd.executePrep();
		while(resultatMdpBdd.next()){
			mdpBdd = resultatMdpBdd.getString("password");
		}
		return mdpBdd;
	}
	
	public void modifPseudo (String pseudo_ancien, String pseudo_nouveau){
		String  updatePseudo = "update "+TABLE_UTILISATEUR+" set login='"+pseudo_nouveau+"' where login='"+pseudo_ancien+"';";
		this.bdd.prepareStmt(updatePseudo);
		ResultSet rset = this.bdd.executePrep();
	}
	
	public void modifMdp (String pseudo, String mdp_nouveau){
		
		String  updateMdp = "update "+TABLE_UTILISATEUR+" set password='"+mdp_nouveau+"' where login='"+pseudo+"';";
		this.bdd.prepareStmt(updateMdp);
		ResultSet rset = this.bdd.executePrep();
	}
	
	/**
	 * Ferme la connexion à la bdd
	 */
	public void close(){
		this.bdd.closeBdd();
	}
}
