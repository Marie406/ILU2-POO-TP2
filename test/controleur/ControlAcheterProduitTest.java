package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlAcheterProduitTest {
	private Village village;
	private ControlAcheterProduit controlAcheterProduit;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;
	
	@BeforeEach
	protected void initTest() {
		village =new Village("le village", 10,10);
		Chef chef = new Chef("chef", 1, village);
		village.setChef(chef);
		//en cours
	}
	
	@Test
	void testControlAcheterProduit() {
		fail("Not yet implemented");
	}

	@Test
	void testEstHabitant() {
		fail("Not yet implemented");
	}

	@Test
	void testEstPropose() {
		fail("Not yet implemented");
	}

	@Test
	void testLesVendeurs() {
		fail("Not yet implemented");
	}

	@Test
	void testMajEtal() {
		fail("Not yet implemented");
	}

}
