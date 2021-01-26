package jeu;

import java.util.Scanner;
import java.util.Vector;

import flotte.*;


public class Tableau {
	static final int OCCUPE = 1;
	
	private int colonnes;
	private int lignes;
	private int[][] grille;
	
	private static Vector<Bateau> listeBateau;
	
	
	
	public Tableau(int lignes, int colonnes) {
		this.lignes = lignes;
		this.colonnes = colonnes;
		
		setGrille(new int[lignes][colonnes]);
		System.out.println("Nombre de lignes :"+this.lignes);
		System.out.println("Nombre de colonnes :"+this.colonnes);
		
		listeBateau = new Vector<Bateau>();
	}
	
	public static int effectuerCoup(int pX, int pY) {
		System.out.println("Effecteur un coup :");
		Scanner sc = new Scanner(System.in);
		return 0;
		
	}
	
	//R�cup�re les positions X et Y + si le bateau est vertical ou horizontal
	public boolean ajouterBateau(Bateau b) {
		int x = b.getPartieBateau()[0].getPositionX();
		int y = b.getPartieBateau()[0].getPositionY();
		boolean bHorizontal = b.isbHorizontal();



		if (isBateauSuperpose(b)) {
			for (int i = 0; i < b.getPartieBateau().length; i++) {
				if (bHorizontal)
					getGrille()[x][y+i] = OCCUPE;
				else
					getGrille()[x+i][y] = OCCUPE;
			}


			System.out.println(getGrille()[x][y]);
			System.out.println(getGrille()[x][y+1]);

			System.out.println("Bateau ajout� !");


			listeBateau.add(b);

			return true;
		} else
			return false;
	}

	//Quand tout les �l�ments du bateau sont touch�s, on le retire du jeu
	public static boolean enleverBateau(Bateau b) {
		
		listeBateau.remove(b);
		return true;
	}
	
	
	
	//Check si le bateau qu'on placer se superpose avec un bateau d�j� plac�s
	private boolean isBateauSuperpose(Bateau b) {
		
		
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
