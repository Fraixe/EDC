package jeu;

import utilitaire.Saisie;

public class Partie {
	
	final static int TAILLEMINGRILLE = 10;
	final static int NOMBREMINBATEAU = 3;
	private String joueurUn = null;
	private String joueurDeux = null;
	
	private int tailleGrille = 0;
	private int nombreBateau =0;
	
	
	public Partie() {
	
	}

	//Permets de saisir le nom des joueurs
	public boolean saisirNomJoueurs() {
		
		this.joueurUn = Saisie.saisirValeurTexte("Entrez le nom du joueur 1 :");
		this.joueurDeux = Saisie.saisirValeurTexte("Entrez le nom du joueur 2 :");

		if (joueurUn.isEmpty()){
			joueurUn = "Joueur 1";
		}

		if (joueurDeux.isEmpty()){
			joueurDeux = "Joueur 2";
		}
		return true;
	}
	
	//Permets de définir la taille de la grille
	public boolean definirTailleGrille() {
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
	
	//Méthode donnant le nombre de Bateau pour les deux joueurs
	public boolean definirNombreBateau() {
		System.out.println("-------------------Mise en place des bateaux-------------------");
		this.nombreBateau = Saisie.saisirValeurTexteToInt("Veuillez définir un nombre de bateaux pour les deux joueurs");
		
		boolean isNombreBateauOk = false;
		do {
			if (nombreBateau < NOMBREMINBATEAU ) {
				System.out.println("Pas assez de bateaux !\n Nombre de bateaux minimum : "+NOMBREMINBATEAU);
				this.nombreBateau = Saisie.saisirValeurTexteToInt("Veuillez définir un nombre de bateaux pour les deux joueurs");
			}else 
				isNombreBateauOk = true;
			
		} while (!isNombreBateauOk);
	
	System.out.println("Nombre de bateaux définis pour les deux joueurs :" + this.nombreBateau);
		return isNombreBateauOk;
	}
	
	public boolean placerBateaux() {
		
		
		return false;
		
	}
	
	

	public int getTailleGrille() {
		return tailleGrille;
	}
	
}
