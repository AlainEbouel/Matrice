

public class Matrice
{
	private double[][] matrice ;
	private double trace;
	private double determinant;
	private Matrice transposee;
	private Matrice coMatrice;
	private Matrice matriceInverse;
	private boolean estCarree;
	private boolean estReguliere;
	
	public Matrice(double[][] matrice)
	{
		this.matrice = matrice;
	}
	
	
	/* Il faut compléter l'implémentation des 7 propriétés ci-dessous*/
	public double getTrace()
	{
		return trace;
	}
	
	public double getDeterminant() 
	{
		return determinant;
	}
	
	public Matrice getTransposee() 
	{
		return transposee;
	}
	
	public Matrice getCoMatrice() 
	{
		return coMatrice;
	}
	
	public Matrice getMatriceInverse() 
	{
		return matriceInverse;
	}
	
	public boolean isEstCarree() 
	{
		return estCarree;
	}
	
	public boolean isEstReguliere()
	{
		return estReguliere;
	}
	
	
	
	Matrice CreerMatrice() 
	{
		throw new UnsupportedOperationException("Not implemented yet");
	}
	
}
