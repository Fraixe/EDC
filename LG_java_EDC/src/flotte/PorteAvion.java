package flotte;

import jeu.Partie;

public class PorteAvion extends Bateau{
	
	
	private final static int NBELEMENTS = 4;

	public PorteAvion(int x, int y, boolean bhorizontal) {
		super(x, y, bhorizontal, NBELEMENTS);
		log.info(Partie.getBundle().getString("PorteAvion"));
	}
}
