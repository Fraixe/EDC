package flotte;

import java.util.ArrayList;
import java.util.List;
import flotte.Element;

public class Bateau {
	
	private boolean bHorizontal;
	
	
	public Bateau(int x, int y, boolean bhorizontal,int taille){
		
		//Sauvegarde en variable de bHorizontal
		this.bHorizontal = bhorizontal;
		
		//Création des elements du bateau
		List<Element> partieBateau = new ArrayList<Element>();
		
		//placement du premier element du bateau
		partieBateau.add(new Element(x, y, this));
		
		//boucle pour placer les elements suivant selon si le bateau est horizontal ou vertical
		for(int i = 1; i < taille; i++) {
			if (bhorizontal)
				partieBateau.add(new Element(x, y+i, this));
			else
				partieBateau.add(new Element(x+i, y, this));
		}
		
	}
	
	
	
	public static void avancer() {
		System.out.println("Le bateau avance");
	}
	
	public int estTouche(int pX, int pY) {
		return 0;
	}

}
