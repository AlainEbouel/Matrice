
import java.util.Scanner;

public class Matrice {
	private double[][] matrice;
	private int  NbrCol;

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

	
	//Methode de verification si une matrice est triangulaire
	public boolean estTriangulaire(int pVt, int pVs) {

		//un premier paramètre doit dire si on souhaite vérifier si la méthode est triangulaire
		Matrice A = this;
		boolean triangleSup = false,triangleInf = false, triangleStr = false;
		if(pVt ==1) {
			//Matrice triangulaire supérieure
			//si bi,j = 0 chaque fois que i > j
			for (int i = 0; i < A.getNbrLigne(); i++) {
				for (int j = 0; i > j; j++) {
					if (A.matrice[i][j]==0) 
					{
						triangleSup = true;
						System.out.println("La matrice est triangulaire superieur");
					}else {
						triangleSup = false;
						System.out.println("La matrice n'est pas triangulaire superieur");
					}
				}
			}

			//Matrice triangulaire inférieure
			//si ci,j = 0 chaque fois que i < j
			for (int i = 0; i < A.getNbrLigne(); i++) {
				for (int j = 0; i < j; j++) {
					if (A.matrice[i][j]==0) 
					{
						triangleInf = true;
						System.out.println("La matrice est triangulaire inferieur");
					}else {
						triangleInf = false;
						System.out.println("La matrice n'est pas triangulaire inferieur");
					}
				}
			}
		}
		if(pVs==2) {
			//Matrice triangulaire stricte
			//si ci,j = 0 chaque fois que i >= j ou chaque fois que i <= j
			for (int i = 0; i < A.getNbrLigne(); i++) {
				for (int j = 0; i >= j||i <= j; j++) {
					if (A.matrice[i][j]==0) 
					{
						triangleStr = true;
						System.out.println("La matrice est triangulaire strict");
					}else {
						triangleStr  = false;
						System.out.println("La matrice n'est pas triangulaire strict");
					}
				}
			}
		}
		if(triangleInf == true ||triangleSup == true ||triangleStr == true) {
		return true;
				}else return false;
	}

	//Methode permettant de calculer la sous-matrice
	public Matrice subMatrix( int exclude_row, int exclude_col)
	{
		Matrice result = new Matrice(matrice);

		for (int row = 0, p = 0; row < this.getNbrLigne(); ++row) {
			if (row != exclude_row - 1) {
				for (int col = 0, q = 0; col < this.getNbrCol(); ++col) {
					if (col != exclude_col - 1) {
						result.matrice[p][q] = this.matrice[row][col];

						++q;
					}
				}
				++p;
			}
		}

		return result;
	}

	
	public Matrice coMatrice()
		{
			if(this.isEstCarree()==false)
			{
				return null;
			}
			else{
				Matrice Comatrice=new Matrice(matrice);
				for (int i = 0; i < getNbrLigne(); i++)
				{
					for (int j = 0; j < getNbrCol(); j++)
					{
						Matrice sub = subMatrix(i+1, j + 1);
						Comatrice.matrice[j][i]=Math.pow(-1,i+j)*sub.getDeterminant();
					}

				}
				return Comatrice;
			}

		}

		//Methode permettant de trouver l'inverse d'une matrice
		public Matrice matriceInverse()
		{
			double det=this.getDeterminant();
			//Verifie si la matrice est régulière et carrée
			if(this.isEstReguliere()==false || this.isEstCarree()==false)
			{
				System.out.println("IMPOSSIBLE DE CALCULER L'INVERSE DE CETTE MATRICE");
				return null ;
			}
			else
			{
				Matrice coMa=this.coMatrice();

				Matrice inverse= coMa.FaireProduitScalaire(1/det);
				return inverse;
			}

		}


	private Matrice FaireProduitScalaire(double d) {
			// TODO Auto-generated method stub
			return null;
		}


	public double getDeterminant() {

		double newMatrice[][];
		double deter = 0;

		if (matrice.length == 1) {
			deter = matrice[0][0];
			return (deter);
		}

		if (matrice.length == 2) {
			deter = ((matrice[0][0] * matrice[1][1]) - (matrice[0][1] * matrice[1][0]));
			return (deter);
		}

		for (int i = 0; i < matrice[0].length; i++) {
			newMatrice = new double[matrice.length - 1][matrice[0].length - 1];

			for (int j = 1; j < matrice.length; j++) {
				for (int k = 0; k < matrice[0].length; k++) {
					if (k < i) {
						newMatrice[j - 1][k] = matrice[j][k];
					} else if (k > i) {
						newMatrice[j - 1][k - 1] = matrice[j][k];
					}
				}
			}

			deter += matrice[0][i] * Math.pow(-1, (double) i) * new Matrice(newMatrice).getDeterminant();
		}
		return (deter);
	}

	public Matrice Additionner(Matrice matrice) {
		double[][] somme = new double[getNbrLigne()][getNbrCol()];
		for (int i = 0; i < getNbrLigne(); i++) {
			for (int j = 0; j < getNbrCol(); j++) {
				somme[i][j] = this.matrice[i][j] + matrice.matrice[i][j];
			}
		}
		return new Matrice(somme);
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
		return (getNbrLigne() == getNbrCol());
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
	public Matrice multiply(double scalaire) {
		double[][] newMatrice = new double[getNbrLigne()][getNbrCol()];

		for (int i = 0; i < getNbrLigne(); i++) {
			for (int j = 0; j < getNbrCol(); j++) {

				newMatrice[i][j] = this.matrice[i][j] * scalaire;
			}
		}

		return new Matrice(newMatrice);
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
	public static boolean UserInputValidationForInt(String userInput) {

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

	//Methode permettant d'afficher la matrice
	public void Afficher() {
		for(int i = 0; i < getNbrLigne(); ++i) {
			System.out.print("[");
			for(int j = 0; j < getNbrCol(); ++j) {
				System.out.print(this.matrice[i][j]+"\t");
			}
			System.out.println("]");
		}
	}

}
