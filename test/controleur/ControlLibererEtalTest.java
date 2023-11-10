package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlLibererEtalTest {

	private Village village;
	private ControlLibererEtal controlLibererEtal;
	private ControlTrouverEtalVendeur controlEtalVendeur;
	
	@BeforeEach
	protected void initTest() {
		village =new Village("le village", 10,10);
		Chef chef = new Chef("chef", 1, village);
		village.setChef(chef);
		controlEtalVendeur = new ControlTrouverEtalVendeur(village);
		controlLibererEtal = new ControlLibererEtal(controlEtalVendeur);
	}
	
	@Test
	void testControlLibererEtal() {
		assertNotNull(controlLibererEtal);
	}
	
	@Test
	void testIsVendeur() {
		Gaulois bonemine = new Gaulois("Bonemine", 6);
		village.ajouterHabitant(bonemine);
		village.installerVendeur(bonemine, "fleurs", 10);
		assertTrue(controlLibererEtal.isVendeur("Bonemine"));
		assertFalse(controlLibererEtal.isVendeur("Obélix"));
	}

	@Test
	void testLibererEtal() {
		Gaulois bonemine = new Gaulois("Bonemine", 6);
		village.ajouterHabitant(bonemine);
		village.installerVendeur(bonemine, "fleurs", 10);
		String[] mesDonneesSup = controlEtalVendeur.trouverEtalVendeur("Bonemine").etatEtal();
		String[] mesDonnees = controlLibererEtal.libererEtal("Bonemine"); // bien le mettre apres la ligne .etatEtal pour pas que etalOccupe vaille false
		for(int i=1; i<mesDonnees.length; i++) {
			assertEquals(mesDonnees[i],mesDonneesSup[i]);
		}
		
		assertFalse(controlEtalVendeur.trouverEtalVendeur("Bonemine").isEtalOccupe());
	}

}
