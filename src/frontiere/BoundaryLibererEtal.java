package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		if (!controlLibererEtal.isVendeur(nomVendeur)) {
			System.out.println("Mais vous n'êtes pas inscrit sur notre marché aujourd'hui !");
		}
		else {
			String[] donneesEtal = controlLibererEtal.libererEtal(nomVendeur);
			System.out.println(String.format("Vous avez vendu %s sur %s %s%nAu revoir %s, passez une bonne journée.", donneesEtal[4], donneesEtal[3], donneesEtal[2], donneesEtal[1]));
			//System.out.println("Vous avez vendu "+ donneesEtal[4]+" sur "+ donneesEtal[3]+" "+ donneesEtal[2]+ "\nAu revoir "+ donneesEtal[1]+" passez une bonne journée.");
		}
	}

}
