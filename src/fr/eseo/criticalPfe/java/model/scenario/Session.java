package fr.eseo.criticalPfe.java.model.scenario;

import fr.eseo.criticalPfe.java.model.Model;

public class Session extends Model {
	private Campagne campagne;

	public Campagne getCampagne() {
		return campagne;
	}

	public void setCampagne(Campagne campagne) {
		this.campagne = campagne;
	}

}
