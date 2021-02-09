package flotte;

public class SousMarin extends Bateau{

	private final static int NBELEMENTS = 1;
	
	public SousMarin(int x, int y) {
		super(x, y, true, NBELEMENTS);
		System.out.println("Sous-marin crée !");
	}

	
	
	
}
