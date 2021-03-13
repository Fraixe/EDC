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

		Partie.saisirNomJoueurs();
		
		Partie.definirTailleGrille();

		System.out.println(tailleGrille);

		
		System.out.println("-------------------Mise en place des bateaux-------------------");


		
			nombreBateau = Saisie.saisirValeurTexteToInt("Veuillez définir un nombre de bateaux pour les deux joueurs");
			
		do {
			if (nombreBateau < NOMBREMINBATEAU ) {
				System.out.println("Pas assez de bateaux !\n Nombre de bateaux minimum : "+NOMBREMINBATEAU);
				nombreBateau = Saisie.saisirValeurTexteToInt("Veuillez définir un nombre de bateaux pour les deux joueurs");
			}else 
				isNombreBateauOk = true;
			
		} while (!isNombreBateauOk);
		
		System.out.println("Nombre de bateaux définis pour les deux joueurs :" + nombreBateau);

		for (int i = 0; i <nombreBateau; i++) {
			boolean isTypeBateauOk = false;
			boolean isPositionX_Ok = false;
			boolean isPositionY_Ok = false;

			int typeBateau = Saisie.saisirValeurTexteToInt("Quel bateau voulez-vous créer ?\n 1- Croiseur  2- Escorteur  3- Sous-Marin");
			do {
				if (typeBateau < 1 && typeBateau > 3) {
					System.out.println("Valeur incorrecte ! Veuillez choisir entre 1 et 3");
					typeBateau = Saisie.saisirValeurTexteToInt("Quel bateau voulez-vous créer ?\n 1- Croiseur  2- Escorteur  3- Sous-Marin");
				}else 
					isTypeBateauOk = true;
			} while (!isTypeBateauOk);

			int positionX = Saisie.saisirValeurTexteToInt("Veillez définir ça position en X");
			do {
				if (positionX < 1 || positionX > tailleGrille) {
					System.out.println("Valeur en dehors des limites de la grille !");
					positionX = Saisie.saisirValeurTexteToInt("Veillez définir ça position en X");
				}else
					isPositionX_Ok = true;
			}while (!isPositionX_Ok);
			System.out.println("Position du bateau en X: " + positionX);

			int positionY = Saisie.saisirValeurTexteToInt("Veillez définir ça position en Y");
			do {
				if (positionY < 1 || positionY > tailleGrille) {
					System.out.println("Valeur en dehors des limites de la grille !");
					positionY = Saisie.saisirValeurTexteToInt("Veillez définir ça position en Y");
				}else
					isPositionY_Ok = true;
			}while (!isPositionY_Ok);
			System.out.println("Position du bateau en X: " + positionY);
			
			if(typeBateau != 3) {
				int isHorizontal = Saisie.saisirValeurTexteToInt("Définissez sa position\n Horizontal : 1 --- Vertical : 2");
				do {
					switch (isHorizontal) {
					case 1:
						System.out.println("Bateau en position horizontale !");
						isHorizontalBool = true;
						break;
					case 2:
						System.out.println("Bateau en position verticale !");
						isHorizontalBool = false;
					default:
						System.out.println("Erreur ! veuillez recommencer");
						isHorizontal = Saisie.saisirValeurTexteToInt("Définissez sa position\n Horizontal : 1 --- Vertical : 2");
						break;
					}
				}while (isHorizontal == 1 || isHorizontal == 2);
				
			System.out.println(isHorizontalBool);
			}
			
			switch (typeBateau) {
			case 1:
				System.out.println("Croiseur choisi");
		//		tabJoueurUn.ajouterBateau(new Croiseur(positionX, positionY, isHorizontalBool));
				break;
			case 2:
				System.out.println("Escorteur choisi");
		//		tabJoueurUn.ajouterBateau(new Escorteur(positionX, positionY, isHorizontalBool));
				break;
			case 3:
				System.out.println("Sous-marin choisi");
		//		tabJoueurUn.ajouterBateau(new SousMarin(positionX, positionY));
				break;
			}

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



