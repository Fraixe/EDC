package principal;

import java.util.InputMismatchException;

import flotte.*;
import jeu.Tableau;
import utilitaire.Message;
import utilitaire.Saisie;

public class Lanceur {

	public static void main(String[] args) {
		final int TAILLEMINGRILLE = 10;
		
		String joueurUn;
		String joueurDeux;
		
		int tailleGrille;
		boolean isTailleOK = false;
		
		
		System.out.println("---------Bataille Navale------------");
		
		joueurUn = Saisie.saisirValeurTexte("Entrez le nom du joueur 1 :");
		joueurDeux = Saisie.saisirValeurTexte("Entrez le nom du joueur 2 :");
		
		do {
			try {
				tailleGrille = Saisie.saisirValeur("Veuillez définir la taille de la grille de jeu");
				if (tailleGrille < TAILLEMINGRILLE)
					System.out.println("Taille de grille trop petite ! \nTaille minimum :"+ TAILLEMINGRILLE);
				else {
					Tableau tabJoueurUn = new Tableau(tailleGrille, tailleGrille);
					Tableau tabJoueurDeux = new Tableau(tailleGrille, tailleGrille);
					System.out.println("Taille de grille définie : " + tailleGrille + " x " + tailleGrille);
					isTailleOK = true;
				}
			} catch (InputMismatchException e) {
				System.out.println("valeur entrée incorrecte !");
			}
		} while (isTailleOK == false);
		
		System.out.println("QUE LA PARTIE COMMENCE !");
		
		
	
		//Tableau tableau = new Tableau(10, 10);
				
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		Bateau bateau1 = new Croiseur(x, y, bhorizontal);
		
//		Bateau b1 = new Croiseur(2, 3, true);
//		
//		//Bateau b2 = new Escorteur(7, 3, false);
//		
//		
//		tableau.ajouterBateau(b1);
//		
//		
//		Message.obtenirMessage(tableau.effectuerCoup(2, 3));
//		
//		Message.obtenirMessage(tableau.effectuerCoup(2, 3));
//		Message.obtenirMessage(tableau.effectuerCoup(2, 4));
//		Message.obtenirMessage(tableau.effectuerCoup(2, 5));
//		
//		//Message.obtenirMessage(tableau.effectuerCoup(4, 5));
//		//Message.obtenirMessage(tableau.effectuerCoup(2, 3));
//		//Message.obtenirMessage(tableau.effectuerCoup(2, 4));
//		//Message.obtenirMessage(tableau.effectuerCoup(3, 3));
//		
//		//Message.obtenirMessage(0);
		
	}
	

}
