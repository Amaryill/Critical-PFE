package fr.eseo.criticalPfe.java.dao.scenario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eseo.criticalPfe.java.dao.ConnexionBDD;
import fr.eseo.criticalPfe.java.dao.DAO;
import fr.eseo.criticalPfe.java.model.scenario.Regle;

public class RegleDAO implements DAO<Regle>{
	private static RegleDAO dao;

	private final String ADD_CONTENU = "INSERT INTO REGLE () VALUES()";
	
	private RegleDAO(){};
	
	public static RegleDAO getRegleDAO(){
		if(dao == null){
			dao = new RegleDAO();
		}
		return dao;
	}

	@Override
	public Regle creer(Regle obj) {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;

		try {
			connexion = ConnexionBDD.getConnexion();
			preparedStatement = connexion.prepareStatement(ADD_CONTENU);
			preparedStatement.executeUpdate();

			obj.setId(ConnexionBDD.getLastId("REGLE"));
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return obj;
	}

	@Override
	public boolean supprimer(Regle obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Regle trouver(Regle obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Regle modifier(Regle obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Regle map(ResultSet result) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
