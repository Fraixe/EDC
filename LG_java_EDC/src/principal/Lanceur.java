package principal;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.ResourceBundle.Control;

import jeu.Partie;

public class Lanceur {

	public static void main(String[] args) {
	
		boolean isPartieOver = false;
		ResourceBundle.Control rbc = ResourceBundle.Control.getControl(Control.FORMAT_DEFAULT);

		ResourceBundle bundle = ResourceBundle.getBundle("textes", Locale.FRANCE,rbc);
		
		
		
		do {
		System.out.println("---------Bataille Navale------------");
		
		Partie partie = new Partie();

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
