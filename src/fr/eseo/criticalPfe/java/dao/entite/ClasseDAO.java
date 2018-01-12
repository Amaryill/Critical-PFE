package fr.eseo.criticalPfe.java.dao.entite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fr.eseo.criticalPfe.java.dao.ConnexionBDD;
import fr.eseo.criticalPfe.java.dao.DAO;
import fr.eseo.criticalPfe.java.model.entite.Classe;

public class ClasseDAO implements DAO<Classe>{

	// TODO Changer Table par le nom de la Univers
		private final String REQUEST_ADD = "INSERT INTO Classe(Nom, deDeVie, alignementPossible, ptsCompParNiveau, Description) VALUES (?,?,?,?)";
		private final String REQUEST_DLT = "DELETE FROM Classe WHERE Nom=?";
		private final String REQUEST_UPD = "UPDATE Classe SET Nom=?, deDeVie=?, alignementPossible=?, ptsCompParNiveau=?, Description=? WHERE Nom=?";
		private final String REQUEST_SLT = "SELECT Nom, deDeVie, alignementPossible, ptsCompParNiveau, Description FROM Classe WHERE";
		private final String REQUEST_SLT_ALL = "SELECT Nom, deDeVie, alignementPossible, ptsCompParNiveau, Description FROM Classe";
		private final String CLAUSE_ID = " Nom=?";

		
		public Classe creer(Classe obj) {
			Connection connexion = null;
			PreparedStatement preparedStatement = null;

			
			try {
				connexion = ConnexionBDD.getConnexion();
				preparedStatement = connexion.prepareStatement(REQUEST_ADD);

				preparedStatement.setString(1, obj.getNom());
				preparedStatement.setInt(2, obj.getDeDeVie());
				preparedStatement.setString(3, obj.getAlignement());
				preparedStatement.setInt(4, obj.getPointCompetenceNiveau());
				preparedStatement.setString(5, obj.getDescription());

				preparedStatement.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
			return obj;
		}

		@Override
		public boolean supprimer(Classe obj) {
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
		public Classe trouver(Classe obj) {
			Connection connexion = null;
			PreparedStatement preparedStatement = null;
			Classe classeTrouvee = null;

			try {
				connexion = ConnexionBDD.getConnexion();
				preparedStatement = connexion.prepareStatement(REQUEST_SLT + CLAUSE_ID);
				preparedStatement.setString(1, obj.getNom());

				ResultSet result = preparedStatement.executeQuery();
				if (result.next()) {
					classeTrouvee = map(result);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
			return classeTrouvee;
		}
		
	    public ArrayList<Classe> trouverTous(){
	           Connection connexion = null;
	            PreparedStatement preparedStatement = null;
	            ArrayList<Classe> classesTrouvees = new ArrayList<>();
	            
	            try {
	                connexion = ConnexionBDD.getConnexion();
	                preparedStatement = connexion.prepareStatement(REQUEST_SLT_ALL);

	                ResultSet result = preparedStatement.executeQuery();
	                
	                while (result.next()) {
	                    classesTrouvees.add( map(result) );
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	                return null;
	            }
	            return classesTrouvees;
	    }

		@Override
		public Classe modifier(Classe obj) {
			Connection connexion = null;
			PreparedStatement preparedStatement = null;

			try {
				connexion = ConnexionBDD.getConnexion();
				preparedStatement = connexion.prepareStatement(REQUEST_UPD);
				
				preparedStatement.setString(1, obj.getNom());
				preparedStatement.setInt(2, obj.getDeDeVie());
				preparedStatement.setString(3, obj.getAlignement());
				preparedStatement.setInt(4, obj.getPointCompetenceNiveau());
				preparedStatement.setString(5, obj.getDescription());
				preparedStatement.setString(6, obj.getNom());

				preparedStatement.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
			return obj;
		}

		@Override
		public Classe map(ResultSet result) throws SQLException {
			Classe classe = new Classe();

			classe.setNom(result.getString("Nom"));
			classe.setDeDeVie(result.getInt("deDeVie"));
			classe.setAlignement(result.getString("alignementPossible"));
			classe.setPointCompetenceNiveau(result.getInt("ptsCompParNiveau"));
			classe.setDescription(result.getString("Description"));
			
			return classe;

		}
	}
