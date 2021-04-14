package utilitaire;

import jeu.Partie;

public class Message {

	public static final int COUPENDEHORSDUTABLEAU = -1;
	public static final int COUPDANSEAU = 0;
	public static final int COUPSURELEMENTTOUCHE = 1;
	public static final int COUPSURELEMENTTOUCHEPREM = 2;
	public static final int COUPSURBATEAUCOULE = 3;


	private Message() {

	}

	public static String obtenirMessage(int numero) {

		String retourPhrase = null;

		switch (numero) {
		case COUPENDEHORSDUTABLEAU:
			retourPhrase = (Partie.getBundle().getString("COUPENDEHORSDUTABLEAU"));
			break;
		case COUPDANSEAU:
			retourPhrase = (Partie.getBundle().getString("COUPDANSEAU"));
			break;
		case COUPSURELEMENTTOUCHE:
			retourPhrase = (Partie.getBundle().getString("COUPSURELEMENTTOUCHE"));
			break;
		case COUPSURELEMENTTOUCHEPREM:
			retourPhrase = (Partie.getBundle().getString("COUPSURELEMENTTOUCHEPREM"));
			break;
		case COUPSURBATEAUCOULE:
			retourPhrase = (Partie.getBundle().getString("COUPSURBATEAUCOULE"));
			break;
		default:
			retourPhrase = (Partie.getBundle().getString("casse"));
			
		}

		System.out.println(retourPhrase);
		return retourPhrase;

	}
}
