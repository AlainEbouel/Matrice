import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		/* Affichage temporaire */
		double[][] tabMatrice;
		tabMatrice = Matrice.UserCreationMatrice();

		Matrice matrice = new Matrice(tabMatrice);
		System.out.println(matrice);
	}

}
