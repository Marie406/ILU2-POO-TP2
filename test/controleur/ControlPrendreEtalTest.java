package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlPrendreEtalTest {
	private Village village;
	private ControlPrendreEtal controleurPrendreEtal;
	private ControlVerifierIdentite controlVerifierIdentite;
	
	@BeforeEach
	protected void initTest() {
		village =new Village("le village", 10,2); //nb d'etal à remplir est 2
		Chef chef = new Chef("chef", 1, village);
		village.setChef(chef);
		controlVerifierIdentite = new ControlVerifierIdentite(village);
		controleurPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite,village);
	}
	
	@Test
	void testControlPrendreEtal() {
		assertNotNull(controleurPrendreEtal);
	}

	@Test
	void testResteEtals() {
		assertTrue(controleurPrendreEtal.resteEtals());
		Gaulois bonemine = new Gaulois("Bonemine", 6);
		village.ajouterHabitant(bonemine);
		village.installerVendeur(bonemine, "fleurs", 10);
		Gaulois asterix = new Gaulois("Asterix", 6);
		village.ajouterHabitant(asterix);
		village.installerVendeur(asterix, "chocolat", 10);
		assertFalse(controleurPrendreEtal.resteEtals());
	}

	@Test
	void testPrendreEtal() {
		Gaulois bonemine = new Gaulois("Bonemine", 6);
		village.ajouterHabitant(bonemine);
		assertEquals(0,controleurPrendreEtal.prendreEtal("Bonemine", "fleurs", 10));
		assertEquals(-1, controleurPrendreEtal.prendreEtal("Asterix", "chocolat", 10));
		
	}

	@Test
	void testVerifierIdentite() {
		Gaulois bonemine = new Gaulois("Bonemine", 6);
		village.ajouterHabitant(bonemine);
		assertTrue(controleurPrendreEtal.verifierIdentite("Bonemine"));
		assertFalse(controleurPrendreEtal.verifierIdentite("Obelix"));
	}

}
