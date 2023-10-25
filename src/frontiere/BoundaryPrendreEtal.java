package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		boolean nomVendeurConnu = controlPrendreEtal.verifierIdentite(nomVendeur);
		if (!nomVendeurConnu) {
			StringBuilder msg = new StringBuilder();
			msg.append("Je suis désolée ");
			msg.append(nomVendeur);
			msg.append(" mais il faut être un habitant de notre village pour commercer ici.\n");
			System.out.println(msg.toString());
		}
		else {
			StringBuilder msg2 = new StringBuilder();
			msg2.append("Bonjour ");
			msg2.append(nomVendeur);
			msg2.append(", je vais regarder si je peux vous trouver un étal.\n");
			System.out.println(msg2.toString());
			boolean etalDisponible = controlPrendreEtal.resteEtals();
			if(!etalDisponible) {
				StringBuilder msg3 = new StringBuilder();
				msg3.append("Désolée ");
				msg3.append(nomVendeur);
				msg3.append(", je n'ai plus d'étal qui ne soit pas déjà occupé.\n");
				System.out.println(msg3.toString());
			}
			else {
				installerVendeur(nomVendeur);
			}
		}
	
	}

	private void installerVendeur(String nomVendeur) {
		StringBuilder msg = new StringBuilder();
		msg.append("C'est parfait, il me reste un étal pour vous !\n");
		msg.append("Il me faudrait quelques renseignements :\n");
		System.out.println(msg.toString());
		System.out.println("Quel produit souhaitez-vous vendre ?");
		String choixProduit = scan.next(); // verifier qu'il entre pas n'importe quoi ??
		String question = "Combien souhaitez-vous en vendre ?\n";
		int choixQte = Clavier.entrerEntier(question);
		int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, choixProduit, choixQte);
		if (numeroEtal!=-1) {
			StringBuilder msg2 = new StringBuilder();
			msg2.append("Le vendeur ");
			msg2.append(nomVendeur);
			msg2.append(" s'est installé à l'étal n° ");
			msg2.append(numeroEtal+1);
			System.out.println(msg2.toString());
		}
	}
}
