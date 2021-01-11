package jeu;

import java.util.Scanner;



import flotte.Bateau;
import flotte.Croiseur;
import flotte.Escorteur;


public class Tableau {
	
	private int colonnes;
	private int lignes;
	
	public Tableau(int lignes, int colonnes) {
		this.lignes = lignes;
		this.colonnes = colonnes;
		
		int grille[][] = new int[lignes][colonnes];
		System.out.println("Nombre de lignes :"+this.lignes);
		System.out.println("Nombre de colonnes :"+this.colonnes);
	}
	
	public static int effectuerCoup(int pX, int pY) {
		System.out.println("Effecteur un coup :");
		Scanner sc = new Scanner(System.in);
		return 0;
		
		
	}
	
	public static boolean ajouterBateau(Bateau b) {
		System.out.println("Ajoutez un bateau");
		
//		if (taille == 2) {
//			this.bHorizontal = bhorizontal;
//			Croiseur croiseur = new Croiseur(x, y, bhorizontal);
//		} 
//		if (taille == 3) {
//			this.bHorizontal = bhorizontal;
//			Escorteur escorteur = new Escorteur(x, y, bhorizontal);
//		}
		
		return true;
	}

	//Quand tout les éléments du bateau sont touchés, on le retire du jeu
	public static boolean enleverBateau(Bateau b) {
		return true;
	}
	
	//Check si le bateau qu'on placer se superpose avec un bateau déjà placés
	private boolean isBateauSuperpose(Bateau b) {
		
		
		return true;
	}
	
	
}
