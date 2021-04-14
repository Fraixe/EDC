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
import flotte.PorteAvion;
import flotte.SousMarin;
import utilitaire.Message;
import utilitaire.Saisie;

/**
 * @author Lucas
 *
 */
public class Partie {

	Logger log = Logger.getLogger(Partie.class);
	
	static ResourceBundle.Control rbc = ResourceBundle.Control.getControl(Control.FORMAT_DEFAULT);
	private static ResourceBundle bundle;
	
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

	//M�thode servant a selectionner la langue du jeu
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
		tailleGrille = Saisie.saisirValeurTexteToInt(bundle.getString("tailleDefGrille")+bundle.getString("minGrille")+ TAILLEMINGRILLE);
		//tant que la taille n'est pas valide on demande a l'utilisateur de la resaisir
		do {
			if (tailleGrille < TAILLEMINGRILLE) {
				System.out.println(bundle.getString("erreurTaille") + bundle.getString("minGrille")+ TAILLEMINGRILLE);
				tailleGrille = Saisie.saisirValeurTexteToInt(bundle.getString("tailleDefGrille")+bundle.getString("minGrille")+ TAILLEMINGRILLE);
			}
			else 
				isTailleOK = true;
		} while (!isTailleOK);

		//A partir de la saisie valid� utilisateur on cr�es les 2 grilles des joueurs
		tabJoueurUn = new Tableau(tailleGrille, tailleGrille);
		tabJoueurDeux = new Tableau(tailleGrille, tailleGrille);
		log.info(bundle.getString("tailleDefinie") + tailleGrille + " x " + tailleGrille);
		return true;
	}

	//M�thode donnant le nombre de Bateau pour les deux joueurs
	public boolean definirNombreBateau() {
		log.info(bundle.getString("miseEnPlaceTitre"));
		this.nombreBateau = Saisie.saisirValeurTexteToInt(bundle.getString("defNbBateaux"));

		//Tant que le nombre est inferieur au nombre min de bateaux, on continu a demander
		boolean isNombreBateauOk = false;
		do {
			if (nombreBateau < NOMBREMINBATEAU ) {
				log.info(bundle.getString("erreurNbBateaux")+NOMBREMINBATEAU);
				this.nombreBateau = Saisie.saisirValeurTexteToInt(bundle.getString("defNbBateaux"));
			}else 
				isNombreBateauOk = true;

		} while (!isNombreBateauOk);

		System.out.println(bundle.getString("nbBateauxDef") + this.nombreBateau);
		return isNombreBateauOk;
	}

	//Les joueurs definissent au d�but les bateaux avec ils vont jouer
	public List<Integer> setTypeBateauPartie(){		
		InspectorSetBateau verif = new InspectorSetBateau(tailleGrille);


		for (int i =0; i < nombreBateau; i++) {
			int typeBateau = Saisie.saisirValeurTexteToInt(bundle.getString("choixBateau"));
			verif.checkTypeBateau(typeBateau);
			listeTypeBateau.add(typeBateau);
		}
		return listeTypeBateau;
	}

	//M�thode qui fait une boucle pour mettre en place les bateaux d�finis auparavant pour le joueur1
	public void definirBateauJoueur1() {
		log.info(joueurUn + bundle.getString("defPosBateau"));
		for(int i = 0;i < listeTypeBateau.size(); i++) {
			definirPosBateauJoueur1(listeTypeBateau.get(i));
		}
	}
	
 // m�me m�thode mais pour le joueur 2
	public void definirBateauJoueur2() {
		log.info(joueurDeux+ bundle.getString("defPosBateau"));
		for(int i = 0;i < listeTypeBateau.size(); i++) {
			definirPosBateauJoueur2(listeTypeBateau.get(i));
		}
	}


	//permets de d�finir la position du premier element du bateau et sa position (vertical/horizontal)
	public void definirPosBateauJoueur1(int typeBateau) {
		//on instancie un inspecteur qui nous aidera a v�rifier la saisie utilisateur
		InspectorSetBateau verif = new InspectorSetBateau(tailleGrille);

		//saisie position en X
		int positionX = Saisie.saisirValeurTexteToInt(bundle.getString("setPositionX"));
		verif.checkPosX(positionX);

		//saisie position en Y
		int positionY = Saisie.saisirValeurTexteToInt(bundle.getString("setPositionY"));
		verif.checkPosY(positionY);

		//Si le bateau choisi est un sousmarin, on ne v�rifie pas sa position
		if(typeBateau != 3) 
			isHorizontalBool = verif.checkIsHorizontal();

		//on appelle placerBateauxJoueur pour mettre en place le bateau
		placerBateauxJoueur1(typeBateau, positionX, positionY);
	}
	//meme methode mais pour le joueur2
	public void definirPosBateauJoueur2(int typeBateau) {
		InspectorSetBateau verif = new InspectorSetBateau(tailleGrille);

		int positionX = Saisie.saisirValeurTexteToInt(bundle.getString("setPositionX"));
		verif.checkPosX(positionX);


		int positionY = Saisie.saisirValeurTexteToInt(bundle.getString("setPositionY"));
		verif.checkPosY(positionY);

		if(typeBateau != 3) 
			isHorizontalBool = verif.checkIsHorizontal();


		placerBateauxJoueur2(typeBateau, positionX, positionY);
	}

 //m�thode mettant en place le bateau sur la grille joueur, si �a ne fonctionnne pas, on rappelle la m�thode definirPosBateauJoueur pour red�finir les positions
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
		case 4:
			isBateauSetOk =tabJoueurUn.ajouterBateau(new PorteAvion(positionX, positionY, isHorizontalBool));
			if (!isBateauSetOk)
				definirPosBateauJoueur1(typeBateau);
			break;
		}
		return isBateauSetOk;
	}

	//meme methode mais pour le joueur2
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
		case 4:
			isBateauSetOk =tabJoueurUn.ajouterBateau(new PorteAvion(positionX, positionY, isHorizontalBool));
			if (!isBateauSetOk)
				definirPosBateauJoueur1(typeBateau);
			break;
		}
		return isBateauSetOk;
	}

	//D�roulement de la partie 2 attribut, un chrono qui mesure la dur�e de la partie et un compteur de coups jou�s
	public void partieDeroulement() {
		boolean jouerUnPlayed = false; // boolean servant pour d�finir le joueur qui doit jouer

		log.info(bundle.getString("startParty"));
		int compteurCoups = 0;
		long startTime = System.nanoTime(); //d�marrage du compteur

		do {
			int coupX = Saisie.saisirValeurTexteToInt(bundle.getString("coupEnX"));
			int coupY = Saisie.saisirValeurTexteToInt(bundle.getString("coupEnY"));

			if (!jouerUnPlayed) {
				log.info(bundle.getString("coupDe")+ joueurUn);
				Message.obtenirMessage(tabJoueurUn.effectuerCoup(coupX, coupY));
				compteurCoups++;
				jouerUnPlayed = true;
			} else {
				log.info(bundle.getString("coupDe")+ joueurDeux);
				Message.obtenirMessage(tabJoueurDeux.effectuerCoup(coupX, coupY));
				compteurCoups++;
				jouerUnPlayed = false;
			}
		} while ((tabJoueurUn.getListeBateau().size() != 0) || (tabJoueurDeux.getListeBateau().size() != 0));

		long endTime = System.nanoTime(); //marque la fin de la partie
		long tempsTotal = endTime - startTime; //calcul du temps de la partie

		//Converti le temps total en secondes
		long convert = TimeUnit.SECONDS.convert(tempsTotal, TimeUnit.NANOSECONDS);

		if(tabJoueurUn.getListeBateau().size() == 0) {
			log.info(bundle.getString("partyOver"));
			log.info(joueurUn + bundle.getString("aWin"));
			log.info(bundle.getString("tempsJoue") + convert + bundle.getString("secondes") + bundle.getString("NbCoupJoue") + compteurCoups);
		} else {
			log.info(bundle.getString("partyOver"));
			log.info(joueurDeux + bundle.getString("aWin"));
			log.info(bundle.getString("tempsJoue") + convert +bundle.getString("secondes")+ bundle.getString("NbCoupJoue") +  compteurCoups);
		}

	}

	//m�thode renvoyant un booleen qui permets de savoir si les joueurs veulent rejouer ou pas
	public boolean isPartyOver() {
		boolean isPartyOver = false;

		int choix = Saisie.saisirValeurTexteToInt(bundle.getString("replay"));

		switch (choix) {
		case 1:
			isPartyOver = false;
			break;
		case 2:
			isPartyOver = true;
			
			break;

		default:
			log.info(bundle.getString("mauvaixChoix"));
			isPartyOver();
			break;
		}
		return isPartyOver;
	}

	//getter de la taille de grille
	public int getTailleGrille() {
		return tailleGrille;
	}

	//getter du bundle pour l'internationalisation de l'application
	public static ResourceBundle getBundle() {
		return bundle;
	}


}
