package flotte;



public class Element {

	private int positionX;
	private int positionY;
	private Bateau bateau;
	private boolean bTouche = false;
	
	


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
	
	
	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	public Bateau getBateau() {
		return bateau;
	}

	public void setBateau(Bateau bateau) {
		this.bateau = bateau;
	}

	public boolean isbTouche() {
		return bTouche;
	}

	public void setbTouche(boolean bTouche) {
		this.bTouche = bTouche;
	}
}
