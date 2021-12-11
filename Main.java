public class Main {

	public static void main(String[] args )
			 {

		/* Affichage temporaire */
		
		
	double[][] tabMatrice1;
	tabMatrice1 = Matrice.UserCreationMatrice();
	Matrice tabMatrice=new Matrice(tabMatrice1);
	System.out.println("la matrice  entrée est :\n"+ tabMatrice);


	Matrice matrice = new Matrice(tabMatrice1);
	matrice = matrice.multiply(3);
	System.out.println( "la multiplication scalaire est:\n" + matrice  );
	
	
	double determinant ;
	determinant=matrice.getDeterminant();
		System.out.println("le determinant est :" + determinant);

	matrice = matrice.multiply(matrice);
	System.out.println(  "la multiplication par une autre matrice  est:\n"+matrice  );


	
		Matrice additionner;
	additionner=matrice.Additionner(tabMatrice1);
	System.out.print("l'addition est : \n" + additionner);

		Matrice transpose;
	transpose=matrice.getTransposee();
	System.out.print("la transposêe est : \n" + transpose);
	

	boolean isEstCarree;
	isEstCarree=matrice.isEstCarree();
	System.out.println( "Est ce que la matrice est carrée?: " + isEstCarree);
	

	
	boolean Reguliere;
	Reguliere=matrice.isEstReguliere();
	System.out.println( "Est ce que la matrice est reguliere?: " + Reguliere);

	Matrice inverse;
	inverse=matrice.getMatriceInverse();
	System.out.print("la matrice inverse est : \n" + inverse);
	
	
	


			}

	
 

	
	}
    