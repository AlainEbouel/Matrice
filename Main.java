import java.util.LinkedList;
import java.util.List;

public class Main {

    public static List<Matrice> matrixList = new LinkedList<Matrice>();

<<<<<<< Updated upstream
    public static void main(String[] args) {
        Gui currentGui = new MainGui();
=======
		/* Affichage temporaire pour tests */
		// ********************************************************************** */
		double A1[][] = { { 3, 1, -1 }, { 1, 5, 2 }, { 2, 1, 4 } };
		double A2[][] = { { 3, 1, -1, 0 }, { 1, 5, 2, 5 }, { 2, 1, 4, 4 }, { 1, 2, 4, 3 } };
		double B1[][] = { { 40 }, { 130 }, { 170 } };

		Matrice A = new Matrice(A1);
		Matrice B = new Matrice(A2);
		// System.out.println("A * A-1\n" + A.multiply(A.getMatriceInverse()));
		// System.out.println("A\n" + A);
		// System.out.println("A COMATRICE\n" + A.getCoMatrice());
		System.out.println("B\n" + B);
		System.out.println("B CO\n" + B.getCoMatrice());
		// System.out.println("INVERSION DE A : \n" +
		// A.multiply(A.getMatriceInverse()));

		/*
		 * Systeme sys = new Systeme(new Matrice(A), new Matrice(B));
		 * 
		 * System.out.println("Cramer :\n" + sys.TrouverXParCramer());
		 * 
		 * System.out.println("Jacobi :\n" + sys.TrouverXParJacobi(5));
		 * 
		 * System.out.println("Inversion matricielle :\n" +
		 * sys.TrouverXParInversionMatricielle());
		 */
		// Solution attendue : X = {3, 5, 8}.

		// ************************************************************************* */
		/*
		 * double[][] tabMatrice1;
		 * tabMatrice1 = Matrice.UserCreationMatrice();
		 * Matrice tabMatrice = new Matrice(tabMatrice1);
		 * System.out.println("la matrice  entrée est :\n" + tabMatrice);
		 * 
		 * Matrice matrice = new Matrice(tabMatrice1);
		 * matrice = matrice.multiply(3);
		 * System.out.println("la multiplication scalaire est:\n" + matrice);
		 * 
		 * double determinant;
		 * determinant = matrice.getDeterminant();
		 * System.out.println("le determinant est :" + determinant);
		 * 
		 * matrice = matrice.multiply(matrice);
		 * System.out.println("la multiplication par une autre matrice  est:\n" +
		 * matrice);
		 * 
		 * Matrice additionner;
		 * additionner = matrice.Additionner(tabMatrice1);
		 * System.out.print("l'addition est : \n" + additionner);
		 * 
		 * Matrice transpose;
		 * transpose = matrice.getTransposee();
		 * System.out.print("la transposêe est : \n" + transpose);
		 * 
		 * boolean isEstCarree;
		 * isEstCarree = matrice.isEstCarree();
		 * System.out.println("Est ce que la matrice est carrée?: " + isEstCarree);
		 * 
		 * boolean Reguliere;
		 * Reguliere = matrice.isEstReguliere();
		 * System.out.println("Est ce que la matrice est reguliere?: " + Reguliere);
		 * 
		 * Matrice inverse;
		 * inverse = matrice.getMatriceInverse();
		 * System.out.print("la matrice inverse est : \n" + inverse);
		 */

	}
>>>>>>> Stashed changes

        while (currentGui != null) {
            ConsoleManagement.ClearConsole();
            currentGui.Draw();
            currentGui = currentGui.GetNextMenu();
        }
    }
}
