package principal;

import jeu.Partie;

/**
 * @author Lucas
 *Classe servant de point d'entrée à l'application
 *La boucle du jeu se réalise lorsque que les joueurs souhaitent rejouer
 */
public class Lanceur {

	public static void main(String[] args) {
	
		boolean isPartieOver = false;

		do {
		
		Partie partie = new Partie();

		partie.selectLangue();
		partie.saisirNomJoueurs();
		partie.definirTailleGrille();
		
		partie.definirNombreBateau();
		
		partie.setTypeBateauPartie();

		partie.definirBateauJoueur1();
		
		partie.definirBateauJoueur2();
		
		partie.partieDeroulement();

		isPartieOver = partie.isPartyOver();
		
		} while (!isPartieOver);
		
	}

}
