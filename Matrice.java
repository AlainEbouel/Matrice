
import java.util.Scanner;

public class Matrice {
	private double[][] matrice;
	private int nbrLigne;
	private int nbrCol;

	public Matrice() {
	}

	public double[][] getMatrice() {
		return matrice;
	}

	public void setMatrice(double[][] matrice) {
		this.matrice = matrice;
	}

	public int getNbrLigne() {
		return nbrLigne;
	}

	public int getNbrCol() {
		return nbrCol;
	}

	/* TO DO : completer l'implementation des 7 proprietes ci-dessous */
	public double getTrace() {
		return 0;
	}

	public double getDeterminant() {
		return 0;
	}
    
	public Matrice getTransposee() {
		return new Matrice();
	}
	
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
		return false;
	}

	/* Méthode d'initialisation du tableau à deux dimension */
	public double[][] CreerMatrice() {

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
				this.nbrLigne = Integer.parseInt(line);
				this.nbrCol = Integer.parseInt(col);

				if (this.nbrLigne == 0 || this.nbrCol == 0) {
					System.out.println(
							"Entrer invalide. La dimension doit être un entier strictement positif. Appuyez sur 'Enter' pour recommencer");
					userInputIsOk = false;
					clavier.nextLine();
				}
				clearScreen();
			}
		} while (!userInputIsOk);

		this.matrice = new double[nbrLigne][nbrCol];

		for (int i = 0; i < this.nbrLigne; i++) {
			String input;

			System.out.println("Entrez tour à tour les valeurs de la " + (i + 1) + "e ligne.");

			for (int j = 0; j < this.nbrCol; j++) {

				do {
					input = clavier.nextLine();
					userInputIsOk = true;

					if (!UserInputValidationForDouble(input)) {
						System.out.println("Entrée invalide. Appuyez sur 'Enter' pour recommencer");
						userInputIsOk = false;
						clavier.nextLine();
						clearScreen();
					} else {
						this.matrice[i][j] = Double.parseDouble(input);
					}
				} while (!userInputIsOk);
			}
		}

		clavier.close();

		return this.matrice;
	}

	/* Méthode de validation de la saisie d'un entier par l'utilisateur */
	private boolean UserInputValidationForInt(String userInput) {

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

		for (int i = 0; i < this.nbrLigne; i++) {
			affichageMatrice += "| ";

			for (int j = 0; j < this.nbrCol; j++) {
				affichageMatrice += Double.toString(this.matrice[i][j]) + " ";
			}
			affichageMatrice += "|\n";
		}
		return affichageMatrice;
	}

}
