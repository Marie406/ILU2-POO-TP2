package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlTrouverEtalVendeurTest {

	private Village village;
	private ControlTrouverEtalVendeur control;
	
	//Pour pouvoir ne pas avoir à réécrire la fct initTest d'une 
	//classe de test à une autre en changeant que 2 lignes de code, 
	//on peut creer une classe de tests mère avec la fonction init 
	//et que les autres classes de test fassent un extend de cette 
	//classe mere puis on fait un @override et un super en ajoutant 
	//les lignes de codes qui diffèrent
	
	@BeforeEach
	protected void initTest() {
		village =new Village("le village", 10,10);
		Chef chef = new Chef("chef", 1, village);
		village.setChef(chef);
		control = new ControlTrouverEtalVendeur(village);
	}
	@Test
	void testControlTrouverEtalVendeur() {
		initTest();
		assertNotNull(control);
	}

	@Test
	void testTrouverEtalVendeur() {
		Gaulois bonemine = new Gaulois("Bonemine", 6);
		village.ajouterHabitant(bonemine);
		village.installerVendeur(bonemine, "fleurs", 10);
		//for(int i = 0; i<4)
		//assertEqual(control.trouverEtalVendeur("Bonemine")[i], );
		fail("not implemented yet");
	}

}
