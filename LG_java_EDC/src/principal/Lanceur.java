package principal;

import java.util.InputMismatchException;

import flotte.*;
import jeu.Partie;
import jeu.Tableau;
import utilitaire.Message;
import utilitaire.Saisie;

public class Lanceur {

	public static void main(String[] args) {
	

		System.out.println("---------Bataille Navale------------");
		
		Partie partie = new Partie();

		partie.saisirNomJoueurs();
		
		partie.definirTailleGrille();

		System.out.println(partie.getTailleGrille());
		
		partie.definirNombreBateau();


		

		System.out.println("Bateaux placés !");
	}

}



