package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
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
		initTest();
		assertNotNull(controlLibererEtal);
	}

	@Test
	void testIsVendeur() {
		fail("Not yet implemented");
	}

	@Test
	void testLibererEtal() {
		fail("Not yet implemented");
	}

}
