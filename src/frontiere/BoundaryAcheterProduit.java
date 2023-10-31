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
				System.out.println("Désolé, personne ne vend ce produit au marché\n");
			}
			else {
				int numCommercant = 0;
				StringBuilder question = new StringBuilder();
				question.append(String.format("Chez quel commerçant voulez-vous acheter des %s ?%n", nomProduit));
				int i=0;
				String[] vendeurs = controlAcheterProduit.lesVendeurs(nomProduit);
				while(i<vendeurs.length) {
					question.append(String.format("%d - %s%n", i+1,vendeurs[i]));
					i++;
				}
				while (numCommercant<1 || numCommercant>vendeurs.length) {
					numCommercant = Clavier.entrerEntier(question.toString());
				}
				String nomVendeur = vendeurs[numCommercant -1];
				System.out.println(String.format("%s se déplace jusqu'à l'étal du vendeur %s%nBonjour %s", nomAcheteur, nomVendeur, nomAcheteur));
				String quest_deux = String.format("Combien de %s voulez-vous acheter ?%n", nomProduit);
				int qteDesiree = 0;
				while (qteDesiree<=0) {
					qteDesiree = Clavier.entrerEntier(quest_deux);
				}
				int qteAchetee = controlAcheterProduit.majEtal(nomVendeur, qteDesiree);
				if(qteAchetee==0) {
					System.out.println(String.format("%s veut acheter %d %s, malheureusement il n'y en a plus !%n", nomAcheteur, qteDesiree, nomProduit));
				} else if (qteAchetee==qteDesiree) {
					System.out.println(String.format("%s achète %d %s à %s", nomAcheteur, qteAchetee, nomProduit,nomVendeur));
				} else {
					System.out.println(String.format("%s veut acheter %d %s, malheureusement %s n'en a plus que %d. %s achète tout le stock de %s.", nomAcheteur, qteDesiree, nomProduit, nomVendeur, qteAchetee, nomAcheteur, nomVendeur));
				}
					
			}	
		}
	}
}
