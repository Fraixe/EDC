package jeu;

import java.util.Vector;

import org.apache.log4j.Logger;

import flotte.*;
import utilitaire.Message;


public class Tableau {
	
	Logger log = Logger.getLogger(Tableau.class);
	
	static final int OCCUPE = 1;
	
	private static int lignes;
	private static int colonnes;
	private int[][] grille;
	
	private static Vector<Bateau> listeBateau = new Vector<Bateau>();;
	
	@SuppressWarnings("static-access")
	public Tableau(int lignes, int colonnes) {
		this.lignes = lignes;
		this.colonnes = colonnes;
		setGrille(new int[lignes+1][colonnes+1]);
	}
	
	public int effectuerCoup(int pX, int pY) {
		int resultat;
		//controle du coup � jouer
		if ((pX < 1 || pX > lignes) || (pY < 1 || pY > colonnes)) {
			return Message.COUPENDEHORSDUTABLEAU;
		}
		else { 			
			//fonctionnement normal
			//boucle parcourant les bateaux
			for (int i= 0; i < listeBateau.size(); i++){
				//appel de la fonction estTouche de chaque bateau
				resultat = listeBateau.elementAt(i).estTouche(pX, pY);
				//Si le coup touche OU a d�j� touch� un bateau OU coule un bateau on sort de la boucle et on retourne le bon code
				if (resultat == Message.COUPSURELEMENTTOUCHE || resultat == Message.COUPSURELEMENTTOUCHEPREM )
					return resultat;
				
				if (resultat == Message.COUPSURBATEAUCOULE) {
					enleverBateau(listeBateau.elementAt(i));
					return resultat;
				}
			}
		}
		// renvoi par d�faut coup dans eau si le coup n'a pas touch�
		return resultat = Message.COUPDANSEAU;
	}
	
	//R�cup�re les positions X et Y + si le bateau est vertical ou horizontal
	//
	public boolean ajouterBateau(Bateau b) {
		int x = b.getPartieBateau()[0].getPositionX();
		int y = b.getPartieBateau()[0].getPositionY();
		boolean bHorizontal = b.isbHorizontal();

		// Si le bateau � placer est sur un autre bateau d�j� pr�sent sur la grille
		//On ne place pas le bateau (return false)
		if (!isBateauSuperpose(b)) {
			for (int i = 0; i < b.getPartieBateau().length; i++) {
				if (bHorizontal)
					getGrille()[x][y+i] = OCCUPE;
				else
					getGrille()[x+i][y] = OCCUPE;
			}
			
			listeBateau.add(b);
			return true;
		} else
			return false;
	}

	
	

	//Quand tout les �l�ments du bateau sont touch�s, on le retire du jeu
	public  boolean enleverBateau(Bateau b) {
		
		if (listeBateau.contains(b)) {
			listeBateau.remove(b);
			b = null;
			return true;
		}
		return false;
	}

	//Check si le bateau qu'on place se superpose avec un bateau d�j� plac�s
	//Si le bateau est superpos� on le supprime de la m�moire via le null
	private boolean isBateauSuperpose(Bateau b) {
		int x;
		int y;
		
		for (int i = 0; i < b.getPartieBateau().length; i++) {
			x = b.getPartieBateau()[i].getPositionX();
			y =	b.getPartieBateau()[i].getPositionY();
			
			if (getGrille()[x][y] == OCCUPE) {
				log.info(Partie.getBundle().getString("erreurBateeauSuperpose"));
				b = null;
				return true;
			}
		}
		return false;
	}

	//Getter et Setter de la grille
	public int[][] getGrille() {
		return grille;
	}

	public void setGrille(int[][] grille) {
		this.grille = grille;
	}
	
	public Vector<Bateau> getListeBateau() {
		return listeBateau;
	}
}