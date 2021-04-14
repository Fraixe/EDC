package flotte;

import jeu.Partie;
import utilitaire.Message;

/**
 * @author Lucas
 *Le sous marin peut être en plongé, donc il faut redéfinir la méthode est Touché, 
 *si le bateau est en plongé (isInDive) alors dans tout les cas on retournera que le coup est dans l'eau
 *sinon on rappelle la méthode de la classe mère
 */
public class SousMarin extends Bateau{

	private final static int NBELEMENTS = 1;
	
	private static boolean isInDive;
	
	public SousMarin(int x, int y) {
		super(x, y, true, NBELEMENTS);
		log.info(Partie.getBundle().getString("sousMarin"));
	}

	
	
	@Override
	public int estTouche(int pX, int pY) {
		if (isInDive)
			return Message.COUPDANSEAU;
		else
			return super.estTouche(pX, pY);
	}
	
	
}
