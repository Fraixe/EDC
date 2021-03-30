package jeu;

import utilitaire.Saisie;

/**
 * @author Lucas
 *Classe r�pertoriant tout les controles lors du d�roulement d'une partie
 */
public class InspectorSetBateau {
	
	private int tailleGrille;
	private int typeBateauSaved;
	
	
	public InspectorSetBateau(int tailleGrille) {
		this.tailleGrille = tailleGrille;
	}
	
	
	public int checkTypeBateau(int typeBateau) {
		boolean isTypeBateauOk = false;
		
		do {
			if (typeBateau < 1 && typeBateau > 3) {
				System.out.println("Valeur incorrecte ! Veuillez choisir entre 1 et 3");
				typeBateau = Saisie.saisirValeurTexteToInt("Quel bateau voulez-vous cr�er ?\n 1- Croiseur  2- Escorteur  3- Sous-Marin");
			}else 
				isTypeBateauOk = true;
		} while (!isTypeBateauOk);
		
		this.typeBateauSaved = typeBateau;
		return typeBateau;
	}
	
	public int checkPosX(int posX) {
		boolean isPositionX_Ok = false;
		
		do {
			if (posX < 1 || posX > tailleGrille) {
				System.out.println("Valeur en dehors des limites de la grille !");
				posX = Saisie.saisirValeurTexteToInt("Veillez d�finir �a position en X");
			}else
				isPositionX_Ok = true;
		}while (!isPositionX_Ok);
		
		return posX;
	}
	
	public int checkPosY(int posY) {
		boolean isPositionY_Ok = false;
		
		do {
			if (posY < 1 || posY > tailleGrille) {
				System.out.println("Valeur en dehors des limites de la grille !");
				posY = Saisie.saisirValeurTexteToInt("Veillez d�finir �a position en Y");
			}else
				isPositionY_Ok = true;
		}while (!isPositionY_Ok);
		
		return posY;
	}
	
	public boolean checkIsHorizontal() {
		boolean isHorizontalBool = false;
		
			int isHorizontal = Saisie.saisirValeurTexteToInt("D�finissez sa position\n Horizontal : 1 --- Vertical : 2");
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
					isHorizontal = Saisie.saisirValeurTexteToInt("D�finissez sa position\n Horizontal : 1 --- Vertical : 2");
					break;
				}
			}while (isHorizontal == 1 || isHorizontal == 2);

		
		return isHorizontalBool;
	}

}