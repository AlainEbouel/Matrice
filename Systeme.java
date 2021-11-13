
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
}
