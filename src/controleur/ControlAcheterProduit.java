package controleur;

import personnages.Gaulois;
import villagegaulois.Etal;
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
		return (village.rechercherVendeursProduit(produit)!=null);
	}
	
	//pas faire les affichages depuis le controleur, 
	//tfacon la elle est privée donc elle pourra pas 
	//faire d'affichage, on la divise en deux fonctions
	public String[] lesVendeurs(String produit) {
		Gaulois[] mesVendeurs = village.rechercherVendeursProduit(produit);
		int i = 0;
		String[] mesVendeursStr = new String[mesVendeurs.length];
		while(i<mesVendeurs.length) {
			mesVendeursStr[i] = mesVendeurs[i].getNom();
			i++;
		}
		return mesVendeursStr;
	}
	
	
	public int majEtal(String nomVendeur, int qteDesiree) {
		Etal monEtal = village.rechercherEtal(village.trouverHabitant(nomVendeur));
		return monEtal.acheterProduit(qteDesiree);
	}
	
}
