package jeu;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import flotte.Croiseur;
import flotte.Escorteur;
import flotte.SousMarin;
import utilitaire.Saisie;

public class Partie {

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

	//Permets de saisir le nom des joueurs
	public boolean saisirNomJoueurs() {

		this.joueurUn = Saisie.saisirValeurTexte("Entrez le nom du joueur 1 :");
		this.joueurDeux = Saisie.saisirValeurTexte("Entrez le nom du joueur 2 :");

		if (joueurUn.isEmpty()){
			joueurUn = "Joueur 1";
		}

		if (joueurDeux.isEmpty()){
			joueurDeux = "Joueur 2";
		}
		return true;
	}

	//Permets de définir la taille de la grille
	public boolean definirTailleGrille() {
		boolean isTailleOK = false;

		tailleGrille = Saisie.saisirValeurTexteToInt("Veuillez définir la taille de la grille de jeu\nTaille minimum :"+ TAILLEMINGRILLE);
		do {
			if (tailleGrille < TAILLEMINGRILLE) {
				System.out.println("Taille de grille trop petite ! \nTaille minimum :"+ TAILLEMINGRILLE);
				tailleGrille = Saisie.saisirValeurTexteToInt("Veuillez définir la taille de la grille de jeu\nTaille minimum :"+ TAILLEMINGRILLE);
			}
			else 
				isTailleOK = true;
		} while (!isTailleOK);

		tabJoueurUn = new Tableau(tailleGrille, tailleGrille);
		tabJoueurDeux = new Tableau(tailleGrille, tailleGrille);
		System.out.println("Taille de grille définie : " + tailleGrille + " x " + tailleGrille);
		return true;
	}

	//Méthode donnant le nombre de Bateau pour les deux joueurs
	public boolean definirNombreBateau() {
		System.out.println("-------------------Mise en place des bateaux-------------------");
		this.nombreBateau = Saisie.saisirValeurTexteToInt("Veuillez définir un nombre de bateaux pour les deux joueurs");

		boolean isNombreBateauOk = false;
		do {
			if (nombreBateau < NOMBREMINBATEAU ) {
				System.out.println("Pas assez de bateaux !\n Nombre de bateaux minimum : "+NOMBREMINBATEAU);
				this.nombreBateau = Saisie.saisirValeurTexteToInt("Veuillez définir un nombre de bateaux pour les deux joueurs");
			}else 
				isNombreBateauOk = true;

		} while (!isNombreBateauOk);

		System.out.println("Nombre de bateaux définis pour les deux joueurs :" + this.nombreBateau);
		return isNombreBateauOk;
	}


	public List<Integer> setTypeBateauPartie(){		
		InspectorSetBateau verif = new InspectorSetBateau(tailleGrille);


		for (int i =0; i < nombreBateau; i++) {
			int typeBateau = Saisie.saisirValeurTexteToInt("Quel bateau voulez-vous créer ?\n 1- Croiseur  2- Escorteur  3- Sous-Marin");
			verif.checkTypeBateau(typeBateau);
			listeTypeBateau.add(typeBateau);
		}
		return listeTypeBateau;
	}


	public void definirBateauJoueur1() {
		System.out.println(joueurUn + " positionnez vos bâteaux");
		for(int i = 0;i < listeTypeBateau.size(); i++) {
			definirPosBateauJoueur1(listeTypeBateau.get(i));
		}
	}

	public void definirBateauJoueur2() {
		System.out.println(joueurDeux+ " positionnez vos bâteaux");
		for(int i = 0;i < listeTypeBateau.size(); i++) {
			definirPosBateauJoueur2(listeTypeBateau.get(i));
		}
	}


	public void definirPosBateauJoueur1(int typeBateau) {
		InspectorSetBateau verif = new InspectorSetBateau(tailleGrille);

		int positionX = Saisie.saisirValeurTexteToInt("Veillez définir ça position en X");
		verif.checkPosX(positionX);


		int positionY = Saisie.saisirValeurTexteToInt("Veillez définir ça position en Y");
		verif.checkPosY(positionY);

		if(typeBateau != 3) 
			isHorizontalBool = verif.checkIsHorizontal();


		placerBateauxJoueur1(typeBateau, positionX, positionY);

	}

	public void definirPosBateauJoueur2(int typeBateau) {
		InspectorSetBateau verif = new InspectorSetBateau(tailleGrille);

		int positionX = Saisie.saisirValeurTexteToInt("Veillez définir ça position en X");
		verif.checkPosX(positionX);


		int positionY = Saisie.saisirValeurTexteToInt("Veillez définir ça position en Y");
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

	//Déroulement de la partie 2 attribut, un chrono qui mesure la durée de la partie et un compteur de coups joués
	public void partieDeroulement() {
		boolean jouerUnPlayed = false; // boolean servant pour définir le joueur qui doit jouer

		System.out.println("-----Debut de la partie !");
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
			System.out.println("Partie terminée !\n");
			System.out.println(joueurUn + "a gagné !\n");
			System.out.println("Temps joué : " + convert + "\n Nombre de coups joués : " +  compteurCoups);
		} else {
			System.out.println("Partie terminée !\n");
			System.out.println(joueurDeux + " a gagné !\n");
			System.out.println("Temps joué : " + convert + "\nNombre de coups joués : " +  compteurCoups);
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
