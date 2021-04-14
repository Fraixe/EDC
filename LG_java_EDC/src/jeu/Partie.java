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

	//Méthode servant a selectionner la langue du jeu
	public void selectLangue() {
		int choixLangue = Saisie.saisirValeurTexteToInt("En quelle langue voulez-vous jouer?\n1-Français   2-Anglais");
		
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

	//Permets de définir la taille de la grille
	public boolean definirTailleGrille() {
		boolean isTailleOK = false;

		//on récupère la saisie utilisateur pour définir la taille de grille
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

		//A partir de la saisie validé utilisateur on crées les 2 grilles des joueurs
		tabJoueurUn = new Tableau(tailleGrille, tailleGrille);
		tabJoueurDeux = new Tableau(tailleGrille, tailleGrille);
		log.info(bundle.getString("tailleDefinie") + tailleGrille + " x " + tailleGrille);
		return true;
	}

	//Méthode donnant le nombre de Bateau pour les deux joueurs
	public boolean definirNombreBateau() {
		log.info(bundle.getString("miseEnPlaceTitre"));
		this.nombreBateau = Saisie.saisirValeurTexteToInt(bundle.getString("defNbBateaux"));

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


	public List<Integer> setTypeBateauPartie(){		
		InspectorSetBateau verif = new InspectorSetBateau(tailleGrille);


		for (int i =0; i < nombreBateau; i++) {
			int typeBateau = Saisie.saisirValeurTexteToInt(bundle.getString("choixBateau"));
			verif.checkTypeBateau(typeBateau);
			listeTypeBateau.add(typeBateau);
		}
		return listeTypeBateau;
	}


	public void definirBateauJoueur1() {
		log.info(joueurUn + bundle.getString("defPosBateau"));
		for(int i = 0;i < listeTypeBateau.size(); i++) {
			definirPosBateauJoueur1(listeTypeBateau.get(i));
		}
	}

	public void definirBateauJoueur2() {
		log.info(joueurDeux+ bundle.getString("defPosBateau"));
		for(int i = 0;i < listeTypeBateau.size(); i++) {
			definirPosBateauJoueur2(listeTypeBateau.get(i));
		}
	}


	public void definirPosBateauJoueur1(int typeBateau) {
		InspectorSetBateau verif = new InspectorSetBateau(tailleGrille);

		int positionX = Saisie.saisirValeurTexteToInt(bundle.getString("setPositionX"));
		verif.checkPosX(positionX);


		int positionY = Saisie.saisirValeurTexteToInt(bundle.getString("setPositionY"));
		verif.checkPosY(positionY);

		if(typeBateau != 3) 
			isHorizontalBool = verif.checkIsHorizontal();


		placerBateauxJoueur1(typeBateau, positionX, positionY);
	}

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

	//Déroulement de la partie 2 attribut, un chrono qui mesure la durée de la partie et un compteur de coups joués
	public void partieDeroulement() {
		boolean jouerUnPlayed = false; // boolean servant pour définir le joueur qui doit jouer

		log.info(bundle.getString("startParty"));
		int compteurCoups = 0;
		long startTime = System.nanoTime();

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

		long endTime = System.nanoTime();
		long tempsTotal = endTime - startTime;

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

	public int getTailleGrille() {
		return tailleGrille;
	}

	public static ResourceBundle getBundle() {
		return bundle;
	}


}
