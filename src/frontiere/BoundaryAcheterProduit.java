package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;
import personnages.Gaulois;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		if (!controlAcheterProduit.estHabitant(nomAcheteur)) {
			System.out.println(String.format("Désolé %s, vous n'êtes pas encore habitant du village. Vous ne pouvez pas acheter au marché.\n", nomAcheteur));
		}
		else {
			System.out.println("Quel produit voulez-vous acheter ?\n");
			String nomProduit = scan.next();
			if(!controlAcheterProduit.estPropose(nomProduit)) {
				System.out.println("Désolé, personne ne vend ce produit au marché");
			}
			else {
				int numCommercant = 0;
				String question = "Chez quel commerçant voules-vous acheter des fleurs ?";
				//controlAcheterProduit.lesVendeurs(nomProduit);
				numCommercant = Clavier.entrerEntier(question);
				
			}
		}
	}
}
