package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Druide;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlEmmenagerTest {

	private Village village;
	private ControlEmmenager control;
	
	@BeforeEach
	protected void initTest() {
		village =new Village("le village", 10,10);
		Chef chef = new Chef("chef", 1, village);
		village.setChef(chef);
		control = new ControlEmmenager(village);
	}
	
	@Test
	void testControlEmmenager() {
		assertNotNull(control);
	}

	@Test
	void testIsHabitant() {
		assertFalse(control.isHabitant("Asterix"));
		control.ajouterGaulois("Asterix", 12);
		assertTrue(control.isHabitant("Asterix"));
		
	}

	@Test
	void testAjouterDuide() {
		assertFalse(control.isHabitant("Panoramix"));
		control.ajouterDuide("Panoramix", 6, 2, 8);
		assertTrue(village.trouverHabitant("Panoramix") instanceof Druide);
	}

	@Test
	void testAjouterGaulois() {
		assertFalse(control.isHabitant("Obelix"));
		control.ajouterGaulois("Obelix", 12);
		assertTrue(village.trouverHabitant("Obelix") instanceof Gaulois);
	}

}
