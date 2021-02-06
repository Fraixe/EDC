package utilitaire;

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
			retourPhrase = ("Le coup jou� est en dehors du tableau");
			break;
		case COUPDANSEAU:
			retourPhrase = ("Dans l'eau !");
			break;
		case COUPSURELEMENTTOUCHE:
			retourPhrase = ("Element d�j� touch� !");
			break;
		case COUPSURELEMENTTOUCHEPREM:
			retourPhrase = ("Bateau touch� !");
			break;
		case COUPSURBATEAUCOULE:
			retourPhrase = ("Bateau touch� et coul� !");
			break;
		default:
			retourPhrase = ("Cass�");
			
		}

		System.out.println(retourPhrase);
		return retourPhrase;

	}
}
