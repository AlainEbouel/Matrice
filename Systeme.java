
public class Systeme {
	private Matrice A;
	private Matrice B;

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
}
