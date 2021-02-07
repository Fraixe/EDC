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

}
