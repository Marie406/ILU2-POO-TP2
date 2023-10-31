package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String[] infosMarche = controlAfficherMarche.donnerInfosMarche();
		if(infosMarche.length==0) {
			System.out.println("Le marché est vide, revenez plus tard.");
		}
		else {
			StringBuilder message = new StringBuilder();
			message.append(nomAcheteur);
			message.append(" vous trouverez au marché :\n");
			int i =0;
			while (i<infosMarche.length) {
				message.append(String.format("- %s qui vend %s %s%n", infosMarche[i], infosMarche[i+1], infosMarche[i+2]));
				i=i+3;
			}
			System.out.println(message.toString());
		}
		
		
	}
}
