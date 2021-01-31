package principal;

import java.util.Scanner;

import flotte.Bateau;
import flotte.Croiseur;
import flotte.Escorteur;
import jeu.Tableau;
import utilitaire.Message;

public class Lanceur {

	public static void main(String[] args) {
		final int X = 10;
		final int Y = 10;
				
		Tableau tableau = new Tableau(X, Y);
				
		System.out.println("3 bateau seront crées 1 croiseur, 1 escorteur et 1 sous marin");
		
//		Bateau bateau1 = new Croiseur(x, y, bhorizontal);
		
		Bateau b1 = new Croiseur(2, 3, true);
		
		Bateau b2 = new Escorteur(7, 3, false);
		
		
		tableau.ajouterBateau(b1);
		
		tableau.ajouterBateau(b1);
		
		
		 
		
		//Message.obtenirMessage(0);
		
	}
	

}
