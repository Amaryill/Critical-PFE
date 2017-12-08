package fr.eseo.criticalPfe.java.dao.scenario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eseo.criticalPfe.java.dao.ConnexionBDD;
import fr.eseo.criticalPfe.java.dao.DAO;
import fr.eseo.criticalPfe.java.model.scenario.Contenu;

public class ContenuDAO implements DAO<Contenu>{
	private static ContenuDAO dao;
	
	//TODO changer Contenue en Contenu dans la BDD
	
	private final String ADD_CONTENU = "INSERT INTO CONTENU () VALUES()";

	
	private ContenuDAO(){};
	
	public static ContenuDAO getContenuDAO(){
		if (dao ==null){
			dao = new ContenuDAO();
		}
		return dao;
	}

	@Override
	public Contenu creer(Contenu obj) {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;

		try {
			connexion = ConnexionBDD.getConnexion();
			preparedStatement = connexion.prepareStatement(ADD_CONTENU);
			preparedStatement.executeUpdate();

			obj.setId(ConnexionBDD.getLastId("CONTENUE"));
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return obj;
	}

	@Override
	public boolean supprimer(Contenu obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Contenu trouver(Contenu obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contenu modifier(Contenu obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contenu map(ResultSet result) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
