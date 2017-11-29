package fr.eseo.criticalPfe.java.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

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
	
//	public ICompendiumDAO getCompendiumDao(){
//		return new CompendiumDAO();
//	}
//	
//	public ICompetenceDAO getCompetenceDao(){
//		return new CompetenceDAO();
//	}
//	
//	public IDonDAO getDonDao(){
//		return new DonDAO();
//	}
//	
//	public ISortDAO getSortDao(){
//		return new SortDAO();
//	}
//	
//	public ISortOffensifDAO getSortOffensifDao(){
//		return new SortOffensifDAO();
//	}
//	
//	public ICaracteristiqueDAO getCaracteristiqueDao(){
//		return new CaracteristiqueDAO();
//	}
//	
//	public IClasseDAO getClasseDao(){
//		return new ClasseDAO();
//	}
//	
//	public IEntiteeDAO getEntiteeDao(){
//		return new EntiteeDAO();
//	}
//	
//	public IMonstreDAO getMonstreDao(){
//		return new MonstreDAO();
//	}
//	
//	public IPersonnageDAO getPersonnageDao(){
//		return new PersonnageDAO();
//	}
//	
//	public IPersonnageJoueurDAO getPersonnageJoueurDao(){
//		return new PersonnageJoueurDAO();
//	}
//	
//	public IRaceDAO getRaceDao(){
//		return new RaceDAO();
//	}
//	
//	public IArgentDAO getArgentDao(){
//		return new ArgentDAO();
//	}
//	
//	public IArmeDAO getArmeDao(){
//		return new ArmeDAO();
//	}
//	
//	public IArmureDAO getArmureDao(){
//		return new ArmureDAO();
//	}
//	
//	public IInventaireDAO getInventaireDao() {
//		return new InventaireDAO();
//	}
//
//	public IObjetDAO getObjetDao(){
//		return new ObjetDAO();
//	}
//	
//	public ICampagneDAO getCampagneDao(){
//		return new CampagneDAO();
//	}
//	
//	public ICarteDAO getCarteDao(){
//		return new CarteDAO();
//	}
//	
//	public IContenuDAO getContenuDao(){
//		return new ContenuDAO();
//	}
//	
//	public ILieuDAO getLieuDao(){
//		return new LieuDAO();
//	}
//	
//	public IRegleDAO getRegleDao(){
//		return new RegleDAO();
//	}
//	
//	public ISessionDAO getSessionDao(){
//		return new SessionDAO();
//	}
//	
//	public IStatistiqueDAO getStatistiqueDao(){
//		return new StatistiqueDAO();
//	}
//	
//	public IUtilisateurDAO getUtilisateurDao(){
//		return new UtilisateurDAO();
//	}
}
