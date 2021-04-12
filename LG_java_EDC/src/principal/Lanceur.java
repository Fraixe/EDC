package principal;

import jeu.Partie;

public class Lanceur {

	public static void main(String[] args) {
	

		System.out.println("---------Bataille Navale------------");
		
		Partie partie = new Partie();

		partie.saisirNomJoueurs();
		
		partie.definirTailleGrille();

		System.out.println(partie.getTailleGrille());
		
		partie.definirNombreBateau();
		
		partie.setTypeBateauPartie();

		partie.definirBateauJoueur1();
		
		partie.definirBateauJoueur2();
		

		System.out.println("Bateaux placés !");
	}

}
