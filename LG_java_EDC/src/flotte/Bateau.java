package flotte;

import utilitaire.Message;

public class Bateau {
	
	private boolean bHorizontal;
	private Element[] partieBateau = null;
	private int compteur = 0;
	
	




	public Bateau(int x, int y, boolean bhorizontal,int taille){
		
		//Sauvegarde en variable de bHorizontal
		this.setbHorizontal(bhorizontal);
		
		//Création des elements du bateau
		this.partieBateau = new Element[taille];
		
		//boucle pour placer les elements suivant selon si le bateau est horizontal ou vertical
		for(int i = 0; i < taille; i++) {
			if (bhorizontal)
				this.partieBateau[i] = new Element(x, y+i, this);
			else
				this.partieBateau[i] = new Element(x+i, y, this);
		}
		
	}
	


	public static void avancer() {
		System.out.println("Le bateau avance");
	}
	
	
	
	public int estTouche(int pX, int pY) {
		int resultat;
		
		for (int i = 0; i < partieBateau.length; i++) {
			resultat = partieBateau[i].estTouche(pX, pY);
			
			if (resultat == Message.COUPSURELEMENTTOUCHE)
				return resultat;
			
			if (resultat == Message.COUPSURELEMENTTOUCHEPREM) {
				compteur++;
				if (compteur == partieBateau.length) {
					resultat = Message.COUPSURBATEAUCOULE;
					return resultat;
				}
				resultat = Message.COUPSURELEMENTTOUCHEPREM;
				return resultat;
				
			}
		}

		resultat = Message.COUPDANSEAU;
		return resultat;
		
	}



	// getter et setter
	public boolean isbHorizontal() {
		return bHorizontal;
	}



	public void setbHorizontal(boolean bHorizontal) {
		this.bHorizontal = bHorizontal;
	}

	public Element[] getPartieBateau() {
		return partieBateau;
	}

	public void setPartieBateau(Element[] partieBateau) {
		this.partieBateau = partieBateau;
	}
}


