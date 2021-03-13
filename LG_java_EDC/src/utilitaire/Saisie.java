package utilitaire;

import java.util.Scanner;

public class Saisie {

	// Retourner une valeur saisie
	public static int saisirValeur(String p_texte) {	

		// Cr�ation d'un objet Scanner permettant la saisie au clavier
		Scanner sc = new Scanner(System.in);

		// Affichage du texte
		System.out.print("\n" + p_texte);

		// Attendre la saisie et stocker la valeur dans valeurEntree
		int valeurEntree = sc.nextInt();

		// Retourner la valeur sous forme d'une String
		return valeurEntree;
	}
	
	
	public static String saisirValeurTexte(String p_texte) {	

		// Création d'un objet Scanner permettant la saisie au clavier
		Scanner sc = new Scanner(System.in);

		// Affichage du texte
		System.out.print("\n" + p_texte);

		// Attendre la saisie et stocker la valeur dans valeurEntree
		String texteEntree = sc.nextLine();

		// Retourner la valeur sous forme d'une String
		return texteEntree;
	}
	
	
	public static int saisirValeurTexteToInt(String p_texte) {	
		int nombreReturn = 0;

		// Création d'un objet Scanner permettant la saisie au clavier
		Scanner sc = new Scanner(System.in);

		// Affichage du texte
		System.out.print("\n" + p_texte);

		// Attendre la saisie et stocker la valeur dans valeurEntree
		String texteEntree = sc.nextLine();
		
		if(!isNumeric(texteEntree)) {
			System.out.println("Erreur ! nombre attendu");
			saisirValeurTexteToInt(p_texte);
		}
		else
			nombreReturn = Integer.parseInt(texteEntree);
			

		// Retourner la valeur sous forme d'une String
		return nombreReturn;
	}
	
	//Vérifie que le string en paramétre est bien un entier
	public static boolean isNumeric(String str) { 
		  try {  
		    Integer.parseInt(str);  
		    return true;
		  } catch(NumberFormatException e){  
		    return false;  
		  }  
		}

}
