package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					//TODO a completer
					
					System.out.println("Bienvenue villageois " + nomVisiteur );
					StringBuilder question1 = new StringBuilder();
					question1.append("Quelle est votre force ?");
					int force = -1;
					force = Clavier.entrerEntier(question1.toString());
					controlEmmenager.ajouterGaulois(nomVisiteur, force);
					
					break;

				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		//TODO a completer
		System.out.println("Bienvenue druide " + nomVisiteur);
		StringBuilder question2 = new StringBuilder();
		question2.append("Quelle est votre force ?");
		
		int forceDruide = -1;
		forceDruide = Clavier.entrerEntier(question2.toString());
		int effetPotionMax = forceDruide;
		int effetPotionMin = forceDruide;
		do {
			StringBuilder quMin = new StringBuilder();
			StringBuilder quMax = new StringBuilder();
			quMin.append("Quelle est la force de potion la plus faible que vous produisez ?");
			quMax.append("Quelle est la force de potion la plus forte que vous produisez ?");
			effetPotionMin = Clavier.entrerEntier(quMin.toString());
			effetPotionMax = Clavier.entrerEntier(quMax.toString());
			
			if(effetPotionMax < effetPotionMin) {
				System.out.println("Attention Druide, vous êtes trompé entre le minimum et le maximum ");
			}
		
	    }while(effetPotionMax < effetPotionMin);
		
		controlEmmenager.ajouterDruide(nomVisiteur, forceDruide, effetPotionMin, effetPotionMax);
	}   
}