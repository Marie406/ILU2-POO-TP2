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
					int force=0;
					String question_deux = "Quelle est votre force ?";
					System.out.println("Bienvenu villageois " + nomVisiteur);
					force= Clavier.entrerEntier(question_deux);
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
		int force=0;
		System.out.println("Bienvenu druide " + nomVisiteur);
		String question = "Quelle est votre force ?";
		force = Clavier.entrerEntier(question);
		int effetPotionMax = -1;
		int effetPotionMin = 0;
		do {
			String questionMax = "Quelle est la force de la potion la plus forte que vous produisez ?";
			String questionMin = "Quelle est la force de la potion la plus faible que vous produisez ?";
			effetPotionMin = Clavier.entrerEntier(questionMin);
			effetPotionMax = Clavier.entrerEntier(questionMax);
			if (effetPotionMax<effetPotionMin) {
				System.out.println("Attention druide, vous vous êtes trompé entre le minimum et le maximum");
			}
		} while (effetPotionMax<effetPotionMin);
		controlEmmenager.ajouterDuide(nomVisiteur, force, effetPotionMin, effetPotionMax);
	}
}
