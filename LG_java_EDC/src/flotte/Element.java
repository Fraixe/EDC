package flotte;



public class Element {

	private int positionX;
	private int positionY;
	private Bateau bateau;
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
		this.bateau = bateau;
		System.out.println("Element crée en " + positionX + "," + positionY +"  pour le bateau : "+ bateau);
	}
	
	public int estTouche(int pX,int pY) {
		return 0;
	}
	
	public  void avancer(int depX, int depY) {
		 
	}
}
