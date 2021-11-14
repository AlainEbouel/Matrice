
import java.util.Scanner;

public class Matrice {
	private double[][] matrice;

	public Matrice() {
		matrice = null;
	}

	public Matrice(double[][] matrice) {
		this.matrice = matrice;
	}

	public double[][] getMatrice() {
		return matrice;
	}

	public void setMatrice(double[][] matrice) {
		this.matrice = matrice;
	}

	public int getNbrLigne() {
		return matrice.length;
	}

	public int getNbrCol() {
		return matrice[0].length;
	}

	public double getTrace() {
		if (!isEstCarree())
			return 0;

		int trace = 0;
		for (int i = 0; i < getNbrLigne(); i++)
			trace += matrice[i][i];

		return trace;
	}

	public double getDeterminant() {
		return 0;
	}

	public Matrice getTransposee() {

		double[][] transpose = new double[getNbrCol()][getNbrLigne()];

		for (int i = 0; i < getNbrLigne(); i++) {
			for (int j = 0; j < getNbrCol(); j++) {
				transpose[j][i] = matrice[i][j];
			}
		}

		return new Matrice(transpose);
	}

	/* TO DO : completer l'implementation des 4 proprietes ci-dessous */
	public Matrice getCoMatrice() {
		return new Matrice();
	}

	public Matrice getMatriceInverse() {
		return new Matrice();
	}

	public boolean isEstCarree() {
		return false;
	}

	public boolean isEstReguliere() {
		// Matrice inversible
		return isEstCarree() && (getDeterminant() > 0);
	}

	public double getNumber(int ligne, int colonne) {
		return this.matrice[ligne][colonne];
	}

	public void setNumber(int ligne, int colonne, double nbr) {
		this.matrice[ligne][colonne] = nbr;
	}

	// Multiply the matrice by another
	public Matrice multiply(Matrice matrice) {
		/*
		 * We first check if we actually can multiply the two matrices together
		 */
		if (getNbrCol() != matrice.getNbrLigne())
			return null;

		double[][] multipliedMatrice = new double[getNbrLigne()][matrice.getNbrCol()];

		for (int i = 0; i < getNbrLigne(); i++) {
			for (int j = 0; j < matrice.getNbrCol(); j++) {
				for (int k = 0; k < getNbrCol(); k++) {
					multipliedMatrice[i][j] += this.matrice[i][k] * matrice.getMatrice()[k][j];
				}
			}
		}

		return new Matrice(multipliedMatrice);
	}
	
	// Multiply the matrice by a scalar
	public Matrice multiply(int scalaire) {
		double[][] newMatrice = new double[getNbrLigne()][getNbrCol()];

		for (int i = 0; i < getNbrLigne(); i++) {
			for (int j = 0; j < getNbrCol(); j++) {

				newMatrice[i][j] = this.matrice[i][j] * scalaire;
			}
		}

		return new Matrice(newMatrice);
	}

	Matrice TrouverXParInversionMatricielle(Matrice B) {
		if (!isEstReguliere()) {
			System.out.println("Impossible de trouver les inconus par inversion matricielle : Matrice non inversible");
			return null;
		}

		return getMatriceInverse().multiply(B);
	}

	/* Méthode d'initialisation du tableau à deux dimension */
	public static double[][] UserCreationMatrice() {
		double[][] matrice;
		int nbrLigne = 0, nbrCol = 0;
		String line, col;
		boolean userInputIsOk;

		Scanner clavier = new Scanner(System.in);

		do {
			System.out.println(
					"Entrez tour à tour le nombre lignes, puis le nombre de colonnes de la matrice que vous souhaitez creer : ");
			userInputIsOk = true;

			line = clavier.nextLine();
			col = clavier.nextLine();

			if (!UserInputValidationForInt(line) || !UserInputValidationForInt(col)) {
				System.out.println(
						"Entrer invalide. La dimension doit être un entier strictement positif. Appuyez sur 'Enter' pour recommencer");
				userInputIsOk = false;
				clavier.nextLine();
				clearScreen();
			} else {
				nbrLigne = Integer.parseInt(line);
				nbrCol = Integer.parseInt(col);

				if (nbrLigne == 0 || nbrCol == 0) {
					System.out.println(
							"Entrer invalide. La dimension doit être un entier strictement positif. Appuyez sur 'Enter' pour recommencer");
					userInputIsOk = false;
					clavier.nextLine();
				}
				clearScreen();
			}
		} while (!userInputIsOk);

		matrice = new double[nbrLigne][nbrCol];

		for (int i = 0; i < nbrLigne; i++) {
			String input;

			System.out.println("Entrez tour à tour les valeurs de la " + (i + 1) + "e ligne.");

			for (int j = 0; j < nbrCol; j++) {

				do {
					input = clavier.nextLine();
					userInputIsOk = true;

					if (!UserInputValidationForDouble(input)) {
						System.out.println("Entrée invalide. Appuyez sur 'Enter' pour recommencer");
						userInputIsOk = false;
						clavier.nextLine();
						clearScreen();
					} else {
						matrice[i][j] = Double.parseDouble(input);
					}
				} while (!userInputIsOk);
			}
		}

		clavier.close();

		return matrice;
	}

	/* Méthode de validation de la saisie d'un entier par l'utilisateur */
	private static boolean UserInputValidationForInt(String userInput) {

		try {
			Integer.parseInt(userInput);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	/* Méthode de validation de la saisie d'un réel par l'utilisateur */
	public static boolean UserInputValidationForDouble(String userInput) {

		try {
			Double.parseDouble(userInput);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	/* Nettoyage de la console */
	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	public String toString() {
		String affichageMatrice = "";

		for (int i = 0; i < getNbrLigne(); i++) {
			affichageMatrice += "| ";

			for (int j = 0; j < getNbrCol(); j++) {
				affichageMatrice += Double.toString(this.matrice[i][j]) + "  ";
			}
			affichageMatrice += "|\n";
		}
		return affichageMatrice;
	}

}
