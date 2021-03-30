package principal;

import java.util.InputMismatchException;

import flotte.*;
import jeu.Partie;
import jeu.Tableau;
import utilitaire.Message;
import utilitaire.Saisie;

public class Lanceur {

	public static void main(String[] args) {
		final int TAILLEMINGRILLE = 10;
		final int NOMBREMINBATEAU = 3;



		int tailleGrille = 0;
		boolean isTailleOK = false;
		int nombreBateau = 0;
		boolean isNombreBateauOk = false;
		boolean isHorizontalBool = false;

		System.out.println("---------Bataille Navale------------");
		
		Partie partie = new Partie();

		partie.saisirNomJoueurs();
		
		partie.definirTailleGrille();

		System.out.println(partie.getTailleGrille());
		
		partie.definirNombreBateau();


		

		System.out.println("Bateaux placés !");
	}

}



