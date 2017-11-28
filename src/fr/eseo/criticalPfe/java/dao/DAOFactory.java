package fr.eseo.criticalPfe.java.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import fr.eseo.criticalPfe.java.dao.attribut.ICompendiumDAO;
import fr.eseo.criticalPfe.java.dao.attribut.ICompetenceDAO;
import fr.eseo.criticalPfe.java.dao.attribut.IDonDAO;
import fr.eseo.criticalPfe.java.dao.attribut.ISortDAO;
import fr.eseo.criticalPfe.java.dao.attribut.ISortOffensifDAO;
import fr.eseo.criticalPfe.java.dao.attribut.imp.CompendiumDAO;
import fr.eseo.criticalPfe.java.dao.attribut.imp.CompetenceDAO;
import fr.eseo.criticalPfe.java.dao.attribut.imp.DonDAO;
import fr.eseo.criticalPfe.java.dao.attribut.imp.SortDAO;
import fr.eseo.criticalPfe.java.dao.attribut.imp.SortOffensifDAO;
import fr.eseo.criticalPfe.java.dao.entite.ICaracteristiqueDAO;
import fr.eseo.criticalPfe.java.dao.entite.IClasseDAO;
import fr.eseo.criticalPfe.java.dao.entite.IEntiteeDAO;
import fr.eseo.criticalPfe.java.dao.entite.IMonstreDAO;
import fr.eseo.criticalPfe.java.dao.entite.IPersonnageDAO;
import fr.eseo.criticalPfe.java.dao.entite.IPersonnageJoueurDAO;
import fr.eseo.criticalPfe.java.dao.entite.IRaceDAO;
import fr.eseo.criticalPfe.java.dao.entite.imp.CaracteristiqueDAO;
import fr.eseo.criticalPfe.java.dao.entite.imp.ClasseDAO;
import fr.eseo.criticalPfe.java.dao.entite.imp.EntiteeDAO;
import fr.eseo.criticalPfe.java.dao.entite.imp.MonstreDAO;
import fr.eseo.criticalPfe.java.dao.entite.imp.PersonnageDAO;
import fr.eseo.criticalPfe.java.dao.entite.imp.PersonnageJoueurDAO;
import fr.eseo.criticalPfe.java.dao.entite.imp.RaceDAO;
import fr.eseo.criticalPfe.java.dao.objet.IArgentDAO;
import fr.eseo.criticalPfe.java.dao.objet.IArmeDAO;
import fr.eseo.criticalPfe.java.dao.objet.IArmureDAO;
import fr.eseo.criticalPfe.java.dao.objet.IInventaireDAO;
import fr.eseo.criticalPfe.java.dao.objet.IObjetDAO;
import fr.eseo.criticalPfe.java.dao.objet.imp.ArgentDAO;
import fr.eseo.criticalPfe.java.dao.objet.imp.ArmeDAO;
import fr.eseo.criticalPfe.java.dao.objet.imp.ArmureDAO;
import fr.eseo.criticalPfe.java.dao.objet.imp.InventaireDAO;
import fr.eseo.criticalPfe.java.dao.objet.imp.ObjetDAO;
import fr.eseo.criticalPfe.java.dao.scenario.ICampagneDAO;
import fr.eseo.criticalPfe.java.dao.scenario.ICarteDAO;
import fr.eseo.criticalPfe.java.dao.scenario.IContenuDAO;
import fr.eseo.criticalPfe.java.dao.scenario.ILieuDAO;
import fr.eseo.criticalPfe.java.dao.scenario.IRegleDAO;
import fr.eseo.criticalPfe.java.dao.scenario.ISessionDAO;
import fr.eseo.criticalPfe.java.dao.scenario.IUniversDAO;
import fr.eseo.criticalPfe.java.dao.scenario.imp.CampagneDAO;
import fr.eseo.criticalPfe.java.dao.scenario.imp.CarteDAO;
import fr.eseo.criticalPfe.java.dao.scenario.imp.ContenuDAO;
import fr.eseo.criticalPfe.java.dao.scenario.imp.LieuDAO;
import fr.eseo.criticalPfe.java.dao.scenario.imp.RegleDAO;
import fr.eseo.criticalPfe.java.dao.scenario.imp.SessionDAO;
import fr.eseo.criticalPfe.java.dao.scenario.imp.UniversDAO;
import fr.eseo.criticalPfe.java.dao.utilisateur.IStatistiqueDAO;
import fr.eseo.criticalPfe.java.dao.utilisateur.IUtilisateurDAO;
import fr.eseo.criticalPfe.java.dao.utilisateur.imp.StatistiqueDAO;
import fr.eseo.criticalPfe.java.dao.utilisateur.imp.UtilisateurDAO;

public class DAOFactory {

	private static final String FICHIER_PROPERTIES = "/com/sdzee/dao/dao.properties";
	private static final String PROPERTY_URL = "url";
	private static final String PROPERTY_DRIVER = "driver";
	private static final String PROPERTY_NOM_UTILISATEUR = "nomutilisateur";
	private static final String PROPERTY_MOT_DE_PASSE = "motdepasse";

	private String url;
	private String username;
	private String password;

	public DAOFactory(String url, String username, String password) {
		this.url = url;
		this.username = username;
		this.password = password;
	}

	/*
	 * Méthode chargée de récupérer les informations de connexion à la base de
	 * données, charger le driver JDBC et retourner une instance de la Factory
	 */
	public static DAOFactory getInstance() throws DAOConfigurationException {
		Properties properties = new Properties();
		String url;
		String driver;
		String nomUtilisateur;
		String motDePasse;

		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		InputStream fichierProperties = classLoader.getResourceAsStream(FICHIER_PROPERTIES);

		if (fichierProperties == null) {
			throw new DAOConfigurationException("Le fichier properties " + FICHIER_PROPERTIES + " est introuvable.");
		}

		try {
			properties.load(fichierProperties);
			url = properties.getProperty(PROPERTY_URL);
			driver = properties.getProperty(PROPERTY_DRIVER);
			nomUtilisateur = properties.getProperty(PROPERTY_NOM_UTILISATEUR);
			motDePasse = properties.getProperty(PROPERTY_MOT_DE_PASSE);
		} catch (IOException e) {
			throw new DAOConfigurationException("Impossible de charger le fichier properties " + FICHIER_PROPERTIES, e);
		}

		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			throw new DAOConfigurationException("Le driver est introuvable dans le classpath.", e);
		}

		DAOFactory instance = new DAOFactory(url, nomUtilisateur, motDePasse);
		return instance;
	}

	/* Méthode chargée de fournir une connexion à la base de données */
	/* package */ 
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}

	/*
	 * Méthodes de récupération de l'implémentation des différents DAO (un seul
	 * pour le moment)
	 */
	
	public ICompendiumDAO getCompendiumDao(){
		return new CompendiumDAO(this);
	}
	
	public ICompetenceDAO getCompetenceDao(){
		return new CompetenceDAO(this);
	}
	
	public IDonDAO getDonDao(){
		return new DonDAO(this);
	}
	
	public ISortDAO getSortDao(){
		return new SortDAO(this);
	}
	
	public ISortOffensifDAO getSortOffensifDao(){
		return new SortOffensifDAO(this);
	}
	
	public ICaracteristiqueDAO getCaracteristiqueDao(){
		return new CaracteristiqueDAO(this);
	}
	
	public IClasseDAO getClasseDao(){
		return new ClasseDAO(this);
	}
	
	public IEntiteeDAO getEntiteeDao(){
		return new EntiteeDAO(this);
	}
	
	public IMonstreDAO getMonstreDao(){
		return new MonstreDAO(this);
	}
	
	public IPersonnageDAO getPersonnageDao(){
		return new PersonnageDAO(this);
	}
	
	public IPersonnageJoueurDAO getPersonnageJoueurDao(){
		return new PersonnageJoueurDAO(this);
	}
	
	public IRaceDAO getRaceDao(){
		return new RaceDAO(this);
	}
	
	public IArgentDAO getArgentDao(){
		return new ArgentDAO(this);
	}
	
	public IArmeDAO getArmeDao(){
		return new ArmeDAO(this);
	}
	
	public IArmureDAO getArmureDao(){
		return new ArmureDAO(this);
	}
	
	public IInventaireDAO getInventaireDao() {
		return new InventaireDAO(this);
	}

	public IObjetDAO getObjetDao(){
		return new ObjetDAO(this);
	}
	
	public ICampagneDAO getCampagneDao(){
		return new CampagneDAO(this);
	}
	
	public ICarteDAO getCarteDao(){
		return new CarteDAO(this);
	}
	
	public IContenuDAO getContenuDao(){
		return new ContenuDAO(this);
	}
	
	public ILieuDAO getLieuDao(){
		return new LieuDAO(this);
	}
	
	public IRegleDAO getRegleDao(){
		return new RegleDAO(this);
	}
	
	public ISessionDAO getSessionDao(){
		return new SessionDAO(this);
	}
	
	public IUniversDAO getUniversDao(){
		return new UniversDAO(this);
	}
	
	public IStatistiqueDAO getStatistiqueDao(){
		return new StatistiqueDAO(this);
	}
	
	public IUtilisateurDAO getUtilisateurDao(){
		return new UtilisateurDAO(this);
	}
}
