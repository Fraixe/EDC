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
		
		
		
		Message.obtenirMessage(0);
		
	}
	
	// Retourner une valeur saisie
	public static int saisirValeur(String p_texte) {	

		// Cr�ation d'un objet Scanner permettant la saisie au clavier
		Scanner sc = new Scanner(System.in);

		// Affichage du texte
		System.out.print("\n" + p_texte);

		// Attendre la saisie et stocker la valeur dans valeurEntree
		int valeurEntree = sc.nextInt();

		// Retourner la valeur sous forme d'une String
		return valeurEntree;
	}

}
