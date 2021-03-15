package jeu;

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
		setGrille(new int[lignes+1][colonnes+1]);
		this.listeBateau = new Vector<Bateau>();
	}
	
	public int effectuerCoup(int pX, int pY) {
		int resultat;
		//controle du coup à jouer
		if ((pX < 1 || pX > lignes) || (pY < 1 || pY > colonnes)) {
			return Message.COUPENDEHORSDUTABLEAU;
		}
		else { 			
			//fonctionnement normal
			//boucle parcourant les bateaux
			for (int i= 0; i < listeBateau.size(); i++){
				//appel de la fonction estTouche de chaque bateau
				resultat = listeBateau.elementAt(i).estTouche(pX, pY);
				//Si le coup touche OU a déjà touché un bateau OU coule un bateau on sort de la boucle et on retourne le bon code
				if (resultat == Message.COUPSURELEMENTTOUCHE || resultat == Message.COUPSURELEMENTTOUCHEPREM )
					return resultat;
				
				if (resultat == Message.COUPSURBATEAUCOULE) {
					enleverBateau(listeBateau.elementAt(i));
					return resultat;
				}
			}
		}
		// renvoi par défaut coup dans eau si le coup n'a pas touché
		return resultat = Message.COUPDANSEAU;
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
			return true;
		}
		System.out.println("Bateau déjà enlevé");
		return false;
	}

	//Check si le bateau qu'on place se superpose avec un bateau déjà placés
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