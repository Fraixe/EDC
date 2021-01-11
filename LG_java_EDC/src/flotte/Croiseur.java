package flotte;

public class Croiseur extends Bateau{
	
	private final static int NBELEMENTS = 3;

	public Croiseur(int x, int y, boolean bhorizontal) {
		super(x, y, bhorizontal, NBELEMENTS);
		System.out.println("Croiseur créée !");
	}

}
