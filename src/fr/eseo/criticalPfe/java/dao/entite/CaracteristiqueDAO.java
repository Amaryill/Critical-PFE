package fr.eseo.criticalPfe.java.dao.entite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import fr.eseo.criticalPfe.java.dao.ConnexionBDD;
import fr.eseo.criticalPfe.java.dao.DAO;
import fr.eseo.criticalPfe.java.model.entite.Caracteristique;

public class CaracteristiqueDAO implements DAO<Caracteristique>{

	// TODO Changer Table par le nom de la Univers
		private final String REQUEST_ADD = "INSERT INTO Caracteristique(Force_, Dexterite, Constitution, Intelligence, Sagesse, Charisme, PDVMax) VALUES (?,?,?,?,?,?,?)"; // TODO Mettre attribut
		private final String REQUEST_DLT = "DELETE FROM Caracteristique WHERE Id=?";
		private final String REQUEST_SLT = "SELECT Id, Force_, Dexterite, Constitution, Intelligence, Sagesse, Charisme, PDVMax FROM Caracteristique WHERE";
		private final String REQUEST_UPD = "UPDATE Caracteristique SET Force_=?, Dexterite=?, Constitution=?, Intelligence=?, Sagesse=?, Charisme=?, PDVMax=? WHERE id=?"; // TODO Mettre attribut
		private final String CLAUSE_ID = " id=?";
		
		
		public Caracteristique creer(Caracteristique obj) {
			Connection connexion = null;
			PreparedStatement preparedStatement = null;

			try {
				connexion = ConnexionBDD.getConnexion();
				preparedStatement = connexion.prepareStatement(REQUEST_ADD);

				preparedStatement.setInt(1, obj.getCaracs().get("for"));
				preparedStatement.setInt(2, obj.getCaracs().get("dex"));
				preparedStatement.setInt(3, obj.getCaracs().get("con"));
				preparedStatement.setInt(4, obj.getCaracs().get("int"));
				preparedStatement.setInt(5, obj.getCaracs().get("sag"));
				preparedStatement.setInt(6, obj.getCaracs().get("cha"));
				preparedStatement.setInt(7, obj.getPointDeVieMax());
				
				preparedStatement.executeUpdate();
				
				obj.setId(ConnexionBDD.getLastId("Caracteristique"));
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
			return obj;
		}

		@Override
		public boolean supprimer(Caracteristique obj) {
			Connection connexion = null;
			PreparedStatement preparedStatement = null;

			try {
				connexion = ConnexionBDD.getConnexion();
				preparedStatement = connexion.prepareStatement(REQUEST_DLT);
				preparedStatement.setInt(1, obj.getId());
				preparedStatement.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
			return true;
		}

		@Override
		public Caracteristique trouver(Caracteristique obj) {
			Connection connexion = null;
			PreparedStatement preparedStatement = null;

			try {
				connexion = ConnexionBDD.getConnexion();
				preparedStatement = connexion.prepareStatement(REQUEST_SLT + CLAUSE_ID);
				preparedStatement.setInt(1, obj.getId());
				
				ResultSet result = preparedStatement.executeQuery();
				if (result.next()) {
					obj = map(result);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
			return obj;
		}
		

		@Override
		public Caracteristique modifier(Caracteristique obj) {
			Connection connexion = null;
			PreparedStatement preparedStatement = null;

			try {
				connexion = ConnexionBDD.getConnexion();
				preparedStatement = connexion.prepareStatement(REQUEST_UPD);
				
				preparedStatement.setInt(1, obj.getCaracs().get("for"));
				preparedStatement.setInt(2, obj.getCaracs().get("dex"));
				preparedStatement.setInt(3, obj.getCaracs().get("con"));
				preparedStatement.setInt(4, obj.getCaracs().get("int"));
				preparedStatement.setInt(5, obj.getCaracs().get("sag"));
				preparedStatement.setInt(6, obj.getCaracs().get("cha"));
				preparedStatement.setInt(7, obj.getPointDeVieMax());
				preparedStatement.setInt(8, obj.getId());
				
				preparedStatement.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
			return obj;
		}
		
		@Override
		public Caracteristique map(ResultSet result) throws SQLException {
			Caracteristique caracteristique = new Caracteristique();
			HashMap<String, Integer> caracs = new HashMap<String, Integer>();

			caracs.put("for", result.getInt("Force_"));
			caracs.put("dex", result.getInt("Dexterite"));
			caracs.put("con", result.getInt("Constitution"));
			caracs.put("int", result.getInt("Intelligence"));
			caracs.put("sag", result.getInt("Sagesse"));
			caracs.put("cha", result.getInt("Charisme"));
			
			caracteristique.setCaracs(caracs);
			caracteristique.setPointDeVieMax(result.getInt("PDVMax"));
			caracteristique.setId(result.getInt("Id"));
			
			System.out.println(caracs.get("for"));
			
			return caracteristique;
		}


}
