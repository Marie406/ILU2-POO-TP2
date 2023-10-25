package controleur;

import personnages.Gaulois;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public boolean estHabitant(String nomGaulois) {
		return controlVerifierIdentite.verifierIdentite(nomGaulois);
	}
	
	public boolean estPropose(String produit) {
		return (village.rechercherVendeursProduit(produit).length!=0);
	}
	
	//pas faire les affichages depuis le controleur, tfacon la elle est privée donc elle pourra pas faire d'affichage, on la divise en deux fonctions
	private Gaulois[] lesVendeurs(String produit) {
		Gaulois[] mesVendeurs = village.rechercherVendeursProduit(produit);
		int i = 0;
		StringBuilder listeVendeurs = new StringBuilder();
		while(i<mesVendeurs.length) {
			listeVendeurs.append(String.format("%d - %s%n", i+1,mesVendeurs[i].getNom()));
			i++;
		}
		return mesVendeurs;
	}
	
	//pour ensuite chercher la qté de produit ds l'etal du vendeur choisi
	private Gaulois monVendeur(Gaulois[] lesVendeurs, int ind) {
		return lesVendeurs[ind-1];
	}
}
