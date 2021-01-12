package utilitaire;

public class Message {

	static final int COUPENDEHORSDUTABLEAU = -1;
	static final int COUPDANSEAU = 0;
	static final int COUPSURELEMENTTOUCHE = 1;
	static final int COUPSURELEMENTTOUCHEPREM = 2;
	static final int COUPSURBATEAUCOULE = 3;


	private Message() {

	}

	public static String obtenirMessage(int numero) {

		String retourPhrase = null;


		switch (numero) {
		case COUPENDEHORSDUTABLEAU:
			retourPhrase = ("Le coup joué est en dehors du tableau");
			break;
		case COUPDANSEAU:
			retourPhrase = ("Dans l'eau !");
			break;
		case COUPSURELEMENTTOUCHE:
			retourPhrase = ("Element déjà touché !");
			break;
		case COUPSURELEMENTTOUCHEPREM:
			retourPhrase = ("Bateau touché !");
			break;
		case COUPSURBATEAUCOULE:
			retourPhrase = ("Bateau coulé !");
			break;
		default:
			retourPhrase = ("Cassé");
			
		}

		System.out.println(retourPhrase);
		return retourPhrase;

	}
}
