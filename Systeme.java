
public class Systeme {
	private Matrice A;
	private Matrice B;

	public Systeme(Matrice A, Matrice B) {
		this.A = A;
		this.B = B;
	}

	public Matrice getA() {
		return A;
	}

	public Matrice getB() {
		return B;
	}

	public String toString() {
		return "Systeme:\n\nA:\n" + A + "\n\nB:\n" + B;
	}

	public Matrice TrouverXParInversionMatricielle() {
		if (!A.isEstReguliere()) {
			System.out.println("Impossible de trouver les inconus par inversion matricielle : Matrice non inversible");
			return null;
		}

		return A.getMatriceInverse().multiply(B);
	}

	public Matrice TrouverXParCramer() {

		if (A.getDeterminant() == 0) {
			System.out.println(
					"Impossible de trouver les inconus par la méthode de Cramer : Le déterminant de la Matrice est non nul");

			return null;
		} else {
			double[][] X = new double[A.getNbrCol()][1];

			for (int k = 0; k < A.getNbrCol(); k++) {

				double tabA[][] = new double[A.getNbrLigne()][A.getNbrCol()];

				for (int i = 0; i < A.getNbrLigne(); i++) {
					for (int j = 0; j < A.getNbrCol(); j++) {

						tabA[i][j] = A.getMatrice()[i][j];
					}
				}

				for (int i = 0; i < A.getNbrCol(); i++) {

					tabA[i][k] = B.getMatrice()[i][0];
				}
				X[k][0] = new Matrice(tabA).getDeterminant() / A.getDeterminant();
			}

			return new Matrice(X);
		}
	}
}
