package flotte;

public class SousMarin extends Bateau{

	private final static int NBELEMENTS = 1;
	
	public SousMarin(int x, int y, boolean bhorizontal, int taille) {
		super(x, y, bhorizontal, NBELEMENTS);
		System.out.println("Sous-marin crée !");
	}

	
	
	
}
