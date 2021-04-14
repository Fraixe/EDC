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
			if (typeBateau < 1 && typeBateau > 4) {
				log.info(Partie.getBundle().getString("erreurcheckTypeBateau"));
				typeBateau = Saisie.saisirValeurTexteToInt(Partie.getBundle().getString("choixBateau"));
			}else 
				isTypeBateauOk = true;
		} while (!isTypeBateauOk);
		

		return typeBateau;
	}
	
	public int checkPosX(int posX) {
		boolean isPositionX_Ok = false;
		
		do {
			if (posX < 1 || posX > tailleGrille) {
				log.info(Partie.getBundle().getString("erreurCheckPos"));
				posX = Saisie.saisirValeurTexteToInt(Partie.getBundle().getString("setPositionX"));
			}else
				isPositionX_Ok = true;
		}while (!isPositionX_Ok);
		
		return posX;
	}
	
	public int checkPosY(int posY) {
		boolean isPositionY_Ok = false;
		
		do {
			if (posY < 1 || posY > tailleGrille) {
				log.info(Partie.getBundle().getString("erreurCheckPos"));
				posY = Saisie.saisirValeurTexteToInt(Partie.getBundle().getString("setPositionY"));
			}else
				isPositionY_Ok = true;
		}while (!isPositionY_Ok);
		
		return posY;
	}
	
	public boolean checkIsHorizontal() {
		boolean isHorizontalBool = false;

		int isHorizontal = Saisie.saisirValeurTexteToInt(Partie.getBundle().getString("setCheckIsHorizontal"));

		switch (isHorizontal) {
		case 1:
			log.info(Partie.getBundle().getString("bateauHoriz"));
			isHorizontalBool = true;
			break;
		case 2:
			log.info(Partie.getBundle().getString("bateauVertical"));
			isHorizontalBool = false;
			break;
		default:
			log.info(Partie.getBundle().getString("erreurCheckIsHorizontal"));
			isHorizontal = Saisie.saisirValeurTexteToInt(Partie.getBundle().getString("setCheckIsHorizontal"));
			break;
		}
		return isHorizontalBool;
	}

}
