package jeu;

import utilitaire.Saisie;

public class Partie {

	static String joueurUn = null;
	static String joueurDeux = null;
	
	static final int TAILLEMINGRILLE = 10;
	static int tailleGrille = 0;
	
	
	//Permets de saisir le nom des joueurs
	public static boolean saisirNomJoueurs() {
		
		joueurUn = Saisie.saisirValeurTexte("Entrez le nom du joueur 1 :");
		joueurDeux = Saisie.saisirValeurTexte("Entrez le nom du joueur 2 :");

		if (joueurUn.isEmpty()){
			joueurUn = "Joueur 1";
		}

		if (joueurDeux.isEmpty()){
			joueurDeux = "Joueur 2";
		}
		return true;
	}
	
	public static boolean definirTailleGrille() {
		boolean isTailleOK = false;
		
		tailleGrille = Saisie.saisirValeurTexteToInt("Veuillez définir la taille de la grille de jeu\nTaille minimum :"+ TAILLEMINGRILLE);
		do {
			if (tailleGrille < TAILLEMINGRILLE) {
				System.out.println("Taille de grille trop petite ! \nTaille minimum :"+ TAILLEMINGRILLE);
				tailleGrille = Saisie.saisirValeurTexteToInt("Veuillez définir la taille de la grille de jeu\nTaille minimum :"+ TAILLEMINGRILLE);
			}
			else 
				isTailleOK = true;
		} while (!isTailleOK);
			
		Tableau tabJoueurUn = new Tableau(tailleGrille, tailleGrille);
		Tableau tabJoueurDeux = new Tableau(tailleGrille, tailleGrille);
		System.out.println("Taille de grille définie : " + tailleGrille + " x " + tailleGrille);
		
		System.out.println(tailleGrille);

		return true;
		
	}
	
	
}
