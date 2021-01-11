package flotte;



public class Element {

	private int positionX;
	private int positionY;
	private boolean bTouche;
	


	//Getter
	int getPositionX() {
		return positionX;
	}
	public int getPositionY() {
		return positionY;
	}
	public boolean isbTouche() {
		return bTouche;
	}
	
	
	
	public Element(int positionX, int positionY, Bateau bateau) {
		this.positionX = positionX;
		this.positionY = positionY;
		System.out.println("Element crée en " + positionX + "," + positionY);
	}
	
	public int estTouche(int pX,int pY) {
		return 0;
	}
	
	public static void avancer(int depX, int depY) {
		
	}
}
