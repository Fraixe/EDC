package principal;

import java.util.InputMismatchException;

import flotte.*;
import jeu.Tableau;
import utilitaire.Message;
import utilitaire.Saisie;

public class Lanceur {

	public static void main(String[] args) {
		final int TAILLEMINGRILLE = 10;
		final int NOMBREMINBATEAU = 3;

		String joueurUn = null;
		String joueurDeux = null;



		int tailleGrille = 0;
		boolean isTailleOK = false;
		int nombreBateau = 0;
		boolean isNombreBateauOk = false;

		System.out.println("---------Bataille Navale------------");

		joueurUn = Saisie.saisirValeurTexte("Entrez le nom du joueur 1 :");
		joueurDeux = Saisie.saisirValeurTexte("Entrez le nom du joueur 2 :");

		if (joueurUn.isEmpty()){
			joueurUn = "Joueur 1";
		}

		if (joueurDeux.isEmpty()){
			joueurDeux = "Joueur 2";
		}

		do {

			tailleGrille = Saisie.saisirValeurTexteToInt("Veuillez définir la taille de la grille de jeu");
			//if (Saisie)

			if (tailleGrille < TAILLEMINGRILLE)
				System.out.println("Taille de grille trop petite ! \nTaille minimum :"+ TAILLEMINGRILLE);
			else {
				Tableau tabJoueurUn = new Tableau(tailleGrille, tailleGrille);
				Tableau tabJoueurDeux = new Tableau(tailleGrille, tailleGrille);
				System.out.println("Taille de grille définie : " + tailleGrille + " x " + tailleGrille);
				isTailleOK = true;
			}
		} while (!isTailleOK);
		
		System.out.println(tailleGrille);

		
		System.out.println("-------------------Mise en place des bateaux-------------------");


		do {
			nombreBateau = Saisie.saisirValeurTexteToInt("Veuillez définir un nombre de bateaux pour les deux joueurs");

			if (nombreBateau < NOMBREMINBATEAU ) 
				System.out.println("Pas assez de bateaux !");
			else {
				isNombreBateauOk = true;
				System.out.println("Nombre de bateaux définis pour les deux joueurs :" + nombreBateau);
			}
		} while (!isNombreBateauOk);

		for (int i = 0; i <nombreBateau; i++) {
			boolean isTypeBateauOk = false;
			boolean isPositionX_Ok = false;
			boolean isPositionY_Ok = false;

			do {
				int typeBateau = Saisie.saisirValeurTexteToInt("Quel bateau voulez-vous créer ?\n 1- Croiseur  2- Escorteur  3- Sous-Marin");
				if (typeBateau < 1 && typeBateau > 3)
					System.out.println("Valeur incorrecte ! Veuillez choisir entre 1 et 3");
				else {
					switch (typeBateau) {
					case 1:
						System.out.println("Croiseur choisi");
						break;
					case 2:
						System.out.println("Escoteur choisi");
						break;
					case 3:
						System.out.println("Sous-marin choisi");
						break;
					}
				isTypeBateauOk = true;
				}
			} while (!isTypeBateauOk);

			do {
				int positionX = Saisie.saisirValeurTexteToInt("Veillez définir ça position en X");
				if (positionX < 1 || positionX > tailleGrille) {
					System.out.println("Valeur en dehors des limites de la grille !");
				}else
					System.out.println("Position du bateau en X: " + positionX);
				isPositionX_Ok = true;
			}while (!isPositionX_Ok);

			do {
				int positionY = Saisie.saisirValeurTexteToInt("Veillez définir ça position en Y");
				if (positionY < 1 || positionY > tailleGrille) {
					System.out.println("Valeur en dehors des limites de la grille !");
				}else
					System.out.println("Position du bateau en X: " + positionY);
				isPositionY_Ok = true;

			}while (!isPositionY_Ok);

		}

		System.out.println("Bateaux placés !");
	}








	//Tableau tableau = new Tableau(10, 10);






















	//		Bateau bateau1 = new Croiseur(x, y, bhorizontal);

	//		Bateau b1 = new Croiseur(2, 3, true);
	//		
	//		//Bateau b2 = new Escorteur(7, 3, false);
	//		
	//		
	//		tableau.ajouterBateau(b1);
	//		
	//		
	//		Message.obtenirMessage(tableau.effectuerCoup(2, 3));
	//		
	//		Message.obtenirMessage(tableau.effectuerCoup(2, 3));
	//		Message.obtenirMessage(tableau.effectuerCoup(2, 4));
	//		Message.obtenirMessage(tableau.effectuerCoup(2, 5));
	//		
	//		//Message.obtenirMessage(tableau.effectuerCoup(4, 5));
	//		//Message.obtenirMessage(tableau.effectuerCoup(2, 3));
	//		//Message.obtenirMessage(tableau.effectuerCoup(2, 4));
	//		//Message.obtenirMessage(tableau.effectuerCoup(3, 3));
	//		
	//		//Message.obtenirMessage(0);

}



