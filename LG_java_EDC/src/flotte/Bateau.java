package flotte;

import java.util.ArrayList;
import java.util.List;
import flotte.Element;

public class Bateau {
	
	private boolean bHorizontal;
	private Element[] partieBateau = null;
	
	
	public Bateau(int x, int y, boolean bhorizontal,int taille){
		
		//Sauvegarde en variable de bHorizontal
		this.bHorizontal = bhorizontal;
		
		//Création des elements du bateau
		this.partieBateau = new Element[taille];
		
		//placement du premier element du bateau
		
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
		return 0;
	}

}
