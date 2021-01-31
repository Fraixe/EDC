package jeu;

import java.util.Scanner;
import java.util.Vector;

import flotte.*;
import utilitaire.Message;


public class Tableau {
	static final int OCCUPE = 1;
	
	private static int lignes;
	private static int colonnes;

	private int[][] grille;
	
	private static Vector<Bateau> listeBateau;
	
	
	
	@SuppressWarnings("static-access")
	public Tableau(int lignes, int colonnes) {
		this.lignes = lignes;
		this.colonnes = colonnes;
		
		setGrille(new int[lignes][colonnes]);

		
		listeBateau = new Vector<Bateau>();
	}
	
	public static int effectuerCoup(int pX, int pY) {
		if ((pX < 1 || pX > lignes)&&(pY < 1 || pY > colonnes))
			return Message.COUPENDEHORSDUTABLEAU;
		
		A CODER
			
		
	}
	
	//Récupère les positions X et Y + si le bateau est vertical ou horizontal
	//
	public boolean ajouterBateau(Bateau b) {
		int x = b.getPartieBateau()[0].getPositionX();
		int y = b.getPartieBateau()[0].getPositionY();
		boolean bHorizontal = b.isbHorizontal();



		// Si le bateau à placer est sur un autre bateau déjà présent sur la grille
		//On ne place pas le bateau (return false)
		if (isBateauSuperpose(b)) {
			for (int i = 0; i < b.getPartieBateau().length; i++) {
				if (bHorizontal)
					getGrille()[x][y+i] = OCCUPE;
				else
					getGrille()[x+i][y] = OCCUPE;
			}

			System.out.println(getGrille()[x][y]);
			System.out.println(getGrille()[x][y+1]);
			
			listeBateau.add(b);

			System.out.println("Bateau ajouté !");

			return true;
		} else
			return false;
	}

	
	//Quand tout les éléments du bateau sont touchés, on le retire du jeu
	public  boolean enleverBateau(Bateau b) {
		
		if (listeBateau.contains(b)) {

			listeBateau.remove(b);
			b = null;
			System.out.println("Bateau enlevé !");
			
			System.out.println(listeBateau.size());
			return true;
		}
		System.out.println("Bateau déjà enlevé");
		return false;
	}
	
	
	//Check si le bateau qu'on placer se superpose avec un bateau déjà placés
	private boolean isBateauSuperpose(Bateau b) {
		int x;
		int y;
		
		for (int i = 0; i < b.getPartieBateau().length; i++) {
			x = b.getPartieBateau()[i].getPositionX();
			y =	b.getPartieBateau()[i].getPositionY();
			
			if (getGrille()[x][y] == OCCUPE) {
				System.out.println("Bateau est superposé !");
				return false;
			}	
		}
		return true;
	}

	
	
	
	//Getter et Setter de la grille
	public int[][] getGrille() {
		return grille;
	}

	public void setGrille(int[][] grille) {
		this.grille = grille;
	}


	
}
