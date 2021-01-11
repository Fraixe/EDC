package flotte;

public class Escorteur  extends Bateau{
	
	private final static int NBELEMENTS = 2;
	
	public Escorteur(int x, int y, boolean bhorizontal) {
		super(x, y, bhorizontal, NBELEMENTS);
		System.out.println("Escorteur crée !");
	}
}
