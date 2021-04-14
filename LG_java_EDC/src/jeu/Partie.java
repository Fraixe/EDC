package jeu;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.ResourceBundle.Control;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import flotte.Croiseur;
import flotte.Escorteur;
import flotte.SousMarin;
import utilitaire.Saisie;

public class Partie {

	Logger log = Logger.getLogger(Partie.class);
	
	static ResourceBundle.Control rbc = ResourceBundle.Control.getControl(Control.FORMAT_DEFAULT);

	static ResourceBundle bundle;
	
	final static int TAILLEMINGRILLE = 10;
	final static int NOMBREMINBATEAU = 3;

	private String joueurUn = null;
	private String joueurDeux = null;

	private int tailleGrille = 0;
	private int nombreBateau =0;
	Tableau tabJoueurUn = null;
	Tableau tabJoueurDeux= null;
	boolean isHorizontalBool = false;

	List<Integer> listeTypeBateau = new ArrayList<Integer>();


	public Partie() {
	}

	public void selectLangue() {
		int choixLangue = Saisie.saisirValeurTexteToInt("En quelle langue voulez-vous jouer?\n1-Fran�ais   2-Anglais");
		
		switch (choixLangue) {
		case 1:
			bundle = ResourceBundle.getBundle("textes", Locale.FRENCH, rbc);
			break;
		case 2:
			bundle = ResourceBundle.getBundle("textes", Locale.UK, rbc);
			break;
			
		default:
			selectLangue();
			break;
		}
	}
	
	//Permets de saisir le nom des joueurs
	public boolean saisirNomJoueurs() {

		log.info(bundle.getString("welcomeTitre"));
		this.joueurUn = Saisie.saisirValeurTexte(bundle.getString("defNomJoueurUn"));
		this.joueurDeux = Saisie.saisirValeurTexte(bundle.getString("defNomJoueurDeux"));

		if (joueurUn.isEmpty()){
			joueurUn = "Joueur 1";
		}

		if (joueurDeux.isEmpty()){
			joueurDeux = "Joueur 2";
		}
		return true;
	}

	//Permets de d�finir la taille de la grille
	public boolean definirTailleGrille() {
		boolean isTailleOK = false;

		//on r�cup�re la saisie utilisateur pour d�finir la taille de grille
		tailleGrille = Saisie.saisirValeurTexteToInt("Veuillez d�finir la taille de la grille de jeu\nTaille minimum :"+ TAILLEMINGRILLE);
		//tant que la taille n'est pas valide on demande a l'utilisateur de la resaisir
		do {
			if (tailleGrille < TAILLEMINGRILLE) {
				System.out.println("Taille de grille trop petite ! \nTaille minimum :"+ TAILLEMINGRILLE);
				tailleGrille = Saisie.saisirValeurTexteToInt("Veuillez d�finir la taille de la grille de jeu\nTaille minimum :"+ TAILLEMINGRILLE);
			}
			else 
				isTailleOK = true;
		} while (!isTailleOK);

		//A partir de la saisie valid� utilisateur on cr�es les 2 grilles des joueurs
		tabJoueurUn = new Tableau(tailleGrille, tailleGrille);
		tabJoueurDeux = new Tableau(tailleGrille, tailleGrille);
		log.info("Taille de grille d�finie : " + tailleGrille + " x " + tailleGrille);
		return true;
	}

	//M�thode donnant le nombre de Bateau pour les deux joueurs
	public boolean definirNombreBateau() {
		log.info("-------------------Mise en place des bateaux-------------------");
		this.nombreBateau = Saisie.saisirValeurTexteToInt("Veuillez d�finir un nombre de bateaux pour les deux joueurs");

		boolean isNombreBateauOk = false;
		do {
			if (nombreBateau < NOMBREMINBATEAU ) {
				log.info("Pas assez de bateaux !\n Nombre de bateaux minimum : "+NOMBREMINBATEAU);
				this.nombreBateau = Saisie.saisirValeurTexteToInt("Veuillez d�finir un nombre de bateaux pour les deux joueurs");
			}else 
				isNombreBateauOk = true;

		} while (!isNombreBateauOk);

		System.out.println("Nombre de bateaux d�finis pour les deux joueurs :" + this.nombreBateau);
		return isNombreBateauOk;
	}


	public List<Integer> setTypeBateauPartie(){		
		InspectorSetBateau verif = new InspectorSetBateau(tailleGrille);


		for (int i =0; i < nombreBateau; i++) {
			int typeBateau = Saisie.saisirValeurTexteToInt("Quel bateau voulez-vous cr�er ?\n 1- Croiseur  2- Escorteur  3- Sous-Marin");
			verif.checkTypeBateau(typeBateau);
			listeTypeBateau.add(typeBateau);
		}
		return listeTypeBateau;
	}


	public void definirBateauJoueur1() {
		System.out.println(joueurUn + " positionnez vos b�teaux");
		for(int i = 0;i < listeTypeBateau.size(); i++) {
			definirPosBateauJoueur1(listeTypeBateau.get(i));
		}
	}

	public void definirBateauJoueur2() {
		System.out.println(joueurDeux+ " positionnez vos b�teaux");
		for(int i = 0;i < listeTypeBateau.size(); i++) {
			definirPosBateauJoueur2(listeTypeBateau.get(i));
		}
	}


	public void definirPosBateauJoueur1(int typeBateau) {
		InspectorSetBateau verif = new InspectorSetBateau(tailleGrille);

		int positionX = Saisie.saisirValeurTexteToInt("Veillez d�finir �a position en X");
		verif.checkPosX(positionX);


		int positionY = Saisie.saisirValeurTexteToInt("Veillez d�finir �a position en Y");
		verif.checkPosY(positionY);

		if(typeBateau != 3) 
			isHorizontalBool = verif.checkIsHorizontal();


		placerBateauxJoueur1(typeBateau, positionX, positionY);

	}

	public void definirPosBateauJoueur2(int typeBateau) {
		InspectorSetBateau verif = new InspectorSetBateau(tailleGrille);

		int positionX = Saisie.saisirValeurTexteToInt("Veillez d�finir �a position en X");
		verif.checkPosX(positionX);


		int positionY = Saisie.saisirValeurTexteToInt("Veillez d�finir �a position en Y");
		verif.checkPosY(positionY);

		if(typeBateau != 3) 
			isHorizontalBool = verif.checkIsHorizontal();


		placerBateauxJoueur2(typeBateau, positionX, positionY);
	}


	public boolean	placerBateauxJoueur1(int typeBateau, int positionX, int positionY) {
		boolean isBateauSetOk = false;
		switch (typeBateau) {
		case 1:

			isBateauSetOk = tabJoueurUn.ajouterBateau(new Croiseur(positionX, positionY, isHorizontalBool));
			if (!isBateauSetOk)
				definirPosBateauJoueur1(typeBateau);
			break;
		case 2:

			isBateauSetOk =tabJoueurUn.ajouterBateau(new Escorteur(positionX, positionY, isHorizontalBool));
			if (!isBateauSetOk)
				definirPosBateauJoueur1(typeBateau);
			break;
		case 3:

			isBateauSetOk = tabJoueurUn.ajouterBateau(new SousMarin(positionX, positionY));
			if (!isBateauSetOk)
				definirPosBateauJoueur1(typeBateau);
			break;
		}
		return isBateauSetOk;
	}

	public boolean	placerBateauxJoueur2(int typeBateau, int positionX, int positionY) {
		boolean isBateauSetOk = false;
		switch (typeBateau) {
		case 1:

			isBateauSetOk = tabJoueurDeux.ajouterBateau(new Croiseur(positionX, positionY, isHorizontalBool));
			if (!isBateauSetOk)
				definirPosBateauJoueur2(typeBateau);
			break;
		case 2:

			isBateauSetOk =tabJoueurDeux.ajouterBateau(new Escorteur(positionX, positionY, isHorizontalBool));
			if (!isBateauSetOk)
				definirPosBateauJoueur2(typeBateau);
			break;
		case 3:

			isBateauSetOk = tabJoueurDeux.ajouterBateau(new SousMarin(positionX, positionY));
			if (!isBateauSetOk)
				definirPosBateauJoueur2(typeBateau);
			break;
		}
		return isBateauSetOk;
	}

	//D�roulement de la partie 2 attribut, un chrono qui mesure la dur�e de la partie et un compteur de coups jou�s
	public void partieDeroulement() {
		boolean jouerUnPlayed = false; // boolean servant pour d�finir le joueur qui doit jouer

		log.info("-----Debut de la partie !");
		int compteurCoups = 0;
		long startTime = System.nanoTime();

		do {
			int coupX = Saisie.saisirValeurTexteToInt("Definissez votre coup en X");
			int coupY = Saisie.saisirValeurTexteToInt("Definissez votre coup en Y");

			if (!jouerUnPlayed) {
				System.out.println("Coup de "+ joueurUn);
				tabJoueurUn.effectuerCoup(coupX, coupY);
				compteurCoups++;
				jouerUnPlayed = true;
			} else {
				System.out.println("Coup de "+ joueurDeux);
				tabJoueurDeux.effectuerCoup(coupX, coupY);
				compteurCoups++;
				jouerUnPlayed = false;
			}
		} while ((tabJoueurUn.getListeBateau().size() != 0) || (tabJoueurDeux.getListeBateau().size() != 0));

		long endTime = System.nanoTime();
		long tempsTotal = endTime - startTime;

		//Converti le temps total en secondes
		long convert = TimeUnit.SECONDS.convert(tempsTotal, TimeUnit.NANOSECONDS);

		if(tabJoueurUn.getListeBateau().size() == 0) {
			log.info("Partie termin�e !\n");
			log.info(joueurUn + "a gagn� !\n");
			log.info("Temps jou� : " + convert + "\n Nombre de coups jou�s : " +  compteurCoups);
		} else {
			log.info("Partie termin�e !\n");
			log.info(joueurDeux + " a gagn� !\n");
			log.info("Temps jou� : " + convert +" secondes"+ "\nNombre de coups jou�s : " +  compteurCoups);
		}

	}

	public boolean isPartyOver() {
		boolean isPartyOver = false;

		int choix = Saisie.saisirValeurTexteToInt("Voulez-vous rejouer ? 1- OUI   2- NON");

		switch (choix) {
		case 1:
			isPartyOver = false;
			break;
		case 2:
			isPartyOver = true;
			
			break;

		default:
			System.out.println("Mauvais choix !");
			isPartyOver();
			break;
		}
		return isPartyOver;
	}

	public int getTailleGrille() {
		return tailleGrille;
	}

}
