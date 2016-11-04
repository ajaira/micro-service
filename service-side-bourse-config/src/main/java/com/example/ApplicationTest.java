package com.example;

import java.io.IOException;

public class ApplicationTest {

	public static void main(String[] args) throws IOException {

		// System.out.println("Bonjour, vous devez saisir 5 valeurs qui seront ensuite affichées ");
		// char[] tabchar = new char[6];
		// for (int i = 0; i < 6; i++) {
		// tabchar[i] = caractere();
		// }
		// System.out.println("Les valeurs que vous avez saisies sont : ");
		// for (int i = 0; i < 6; i++) {
		// System.out.println(tabchar[i] + " ");
		// }

		// System.out.println("Entrez un nombre entier, la taille du tableau");
		// int t = entierInt();
		// int[] tab = new int[t];
		//
		// for (int i = 0; i < t; i++) {
		// tab[i] = (int) ((Math.random()*26)-5);
		// }
		//
		// for (int i = 0; i < t; i++) {
		// System.out.println(tab[i] + " ");
		// }

		// double som = 0;
		// double PgNote = 0;
		// double PpNote = 0;
		// double moy = 0;
		// System.out.println("Entrez le nombre des éléves, la taille du tableau");
		// int t = entierInt();
		// double[] tab = new double[t];
		//
		// System.out.println("Entrez la note de chaque éléve sur 20 ");
		// for (int i = 0; i < t; i++) {
		// System.out.println("La note numero " + (i + 1) + " est :");
		// tab[i] = reelDouble();
		// som += tab[i];
		// moy = som / t;
		// PgNote = Math.max(tab[i], PgNote);
		// PpNote = Math.min(tab[i], PpNote);
		// }
		//
		// PpNote = tab[0];
		// for (int i = 0; i < t; i++) {
		// PpNote = Math.min(tab[i], PpNote);
		// }
		//
		// // Affichage somme, moyenne, plus grande note et plus petite.
		// System.out.println("Somme des notes = " + som);
		// System.out.println("Moyenne des notes = " + moy);
		// System.out.println("Plus grande des notes = " + PgNote);
		// System.out.println("Plus petite des notes = " + PpNote);

		// String[] tab = new String[5];
		// tab[0] = "paprika";
		// tab[1] = "cumin";
		// tab[2] = "curry";
		// tab[3] = "canelle";
		// tab[4] = "Gigembre";
		// String reponse = new String("L epice n'existe pas");
		// System.out.println("saisir le nom d'une épice ");
		// String epice = chaine();
		// for (int i = 0; i < 5; i++) {
		// if(tab[i].equals(epice)){
		// reponse = "l epice appartient a la liste";
		// break;
		// }
		// }
		// System.out.println(reponse);

		int[][] tab = new int[3][0];
		for (int i = 0; i < 3; i++) {
			tab[i] = new int[i+1];
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < tab[i].length; j++) {
				System.out.println("sc+" + (j + 1) + " du compartiement c"
						+ (i + 1) + "=" + tab[i][j]);
			}
		}
	}

	// Cette fonction permet de saisir au clavier une variable de type char
	public static char caractere() {
		String tmp = chaine();
		if (tmp.length() == 0) {
			return '\n';
		} else {
			return tmp.charAt(0);
		}
	}

	public static int entierInt() {
		int x = 0;
		try {
			x = Integer.parseInt(chaine());
		} catch (NumberFormatException e) {
			System.out.println("Format numérique incorrect");
			System.exit(0);
		}
		return x;
	}

	public static double reelDouble() {
		double x = 0.0;
		try {
			x = Double.valueOf(chaine()).doubleValue();
		} catch (NumberFormatException e) {
			System.out.println("Format numérique incorrect");
			System.exit(0);
		}
		return x;
	}

	public static String chaine() {
		String tmp = "";
		char C = '\0';
		try {
			while ((C = (char) System.in.read()) != '\n') {
				if (C != '\r')
					tmp = tmp + C;

			}
		} catch (IOException e) {
			System.out.println("Erreur de frappe");
			System.exit(0);
		}
		return tmp;
	}

}
