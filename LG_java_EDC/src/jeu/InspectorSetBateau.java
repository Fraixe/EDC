package jeu;

import org.apache.log4j.Logger;

import utilitaire.Saisie;

/**
 * @author Lucas
 *Classe répertoriant tout les controles lors du déroulement d'une partie
 */
public class InspectorSetBateau {
	Logger log = Logger.getLogger(InspectorSetBateau.class);
	
	private int tailleGrille;

	
	
	public InspectorSetBateau(int tailleGrille) {
		this.tailleGrille = tailleGrille;
	}
	
	
	public int checkTypeBateau(int typeBateau) {
		boolean isTypeBateauOk = false;
		
		do {
			if (typeBateau < 1 && typeBateau > 3) {
				log.info("Valeur incorrecte ! Veuillez choisir entre 1 et 3");
				typeBateau = Saisie.saisirValeurTexteToInt("Quel bateau voulez-vous créer ?\n 1- Croiseur  2- Escorteur  3- Sous-Marin");
			}else 
				isTypeBateauOk = true;
		} while (!isTypeBateauOk);
		

		return typeBateau;
	}
	
	public int checkPosX(int posX) {
		boolean isPositionX_Ok = false;
		
		do {
			if (posX < 1 || posX > tailleGrille) {
				log.info("Valeur en dehors des limites de la grille !");
				posX = Saisie.saisirValeurTexteToInt("Veillez définir ça position en X");
			}else
				isPositionX_Ok = true;
		}while (!isPositionX_Ok);
		
		return posX;
	}
	
	public int checkPosY(int posY) {
		boolean isPositionY_Ok = false;
		
		do {
			if (posY < 1 || posY > tailleGrille) {
				log.info("Valeur en dehors des limites de la grille !");
				posY = Saisie.saisirValeurTexteToInt("Veillez définir ça position en Y");
			}else
				isPositionY_Ok = true;
		}while (!isPositionY_Ok);
		
		return posY;
	}
	
	public boolean checkIsHorizontal() {
		boolean isHorizontalBool = false;

		int isHorizontal = Saisie.saisirValeurTexteToInt("Définissez sa position\n Horizontal : 1 --- Vertical : 2");

		switch (isHorizontal) {
		case 1:
			log.info("Bateau en position horizontale !");
			isHorizontalBool = true;
			break;
		case 2:
			log.info("Bateau en position verticale !");
			isHorizontalBool = false;
			break;
		default:
			log.info("Erreur ! veuillez recommencer");
			isHorizontal = Saisie.saisirValeurTexteToInt("Définissez sa position\n Horizontal : 1 --- Vertical : 2");
			break;
		}
		return isHorizontalBool;
	}

}
