package principal;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.ResourceBundle.Control;

import jeu.Partie;

public class Lanceur {

	public static void main(String[] args) {
	
		boolean isPartieOver = false;
		
	
		do {
		
		Partie partie = new Partie();

		partie.selectLangue();
		partie.saisirNomJoueurs();
		
		partie.definirTailleGrille();

		System.out.println(partie.getTailleGrille());
		
		partie.definirNombreBateau();
		
		partie.setTypeBateauPartie();

		partie.definirBateauJoueur1();
		
		partie.definirBateauJoueur2();
		
		partie.partieDeroulement();

		isPartieOver = partie.isPartyOver();
		
		} while (!isPartieOver);
		
	}

}
