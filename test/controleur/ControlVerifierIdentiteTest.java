package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlVerifierIdentiteTest {
	private Village village;
	private ControlVerifierIdentite controleur;
	
	@BeforeEach
	protected void initTest() {
		village =new Village("le village", 10,2); //nb d'etal à remplir est 2
		Chef chef = new Chef("chef", 1, village);
		village.setChef(chef);
		controleur = new ControlVerifierIdentite(village);
	}
	

	@Test
	void testControlVerifierIdentite() {
		assertNotNull(controleur);
	}

	@Test
	void testVerifierIdentite() {
		Gaulois bonemine = new Gaulois("Bonemine", 6);
		village.ajouterHabitant(bonemine);
		assertTrue(controleur.verifierIdentite("Bonemine"));
		assertFalse(controleur.verifierIdentite("Obelix"));
	}

}
