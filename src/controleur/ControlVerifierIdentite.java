package controleur;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

public class ControlVerifierIdentite {
	private Village village;

	public ControlVerifierIdentite(Village village) {
		this.village = village;
	}

	public boolean verifierIdentite(String nomVendeur) {
		//TODO a completer, attention le retour ne dit pas etre false :-)
		Gaulois vendeur = village.trouverHabitant(nomVendeur);

		return (vendeur != null);
	}
}
