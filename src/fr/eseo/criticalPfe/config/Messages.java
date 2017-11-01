package fr.eseo.criticalPfe.config;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Messages {
	private static final String BUNDLE_NAME = "fr.eseo.criticalPfe.config.messages"; //$NON-NLS-1$
	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

	/**
	 * 
	 */
	private Messages() {
	}

	/**
	 * 
	 * @param key
	 * @return
	 */
 	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) { 
			return '!' + key + '!'; 
		}
	}
}
