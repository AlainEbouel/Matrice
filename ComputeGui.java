public class ComputeGui extends Gui {

    private MatrixOperations operator;
    private String guiTitle;
    private int minMatrices;
    private Matrice firstMatrix, secondMatrix = null;
    private double scalar = 0;

    public ComputeGui(MatrixOperations operator) {
        this.operator = operator;
    }

    private boolean IsIntBetween(int value, int bottom, int top) {
        return ((value >= bottom) && (value <= top));
    }

    @Override
    public void Draw() {
        Init();

        if (Main.matrixList.size() < minMatrices) {
            System.out.printf(guiTitle + "Il faut au moins %d matrices pour effectuer cette opération.\n", minMatrices);
            return;
        }

        GetValuesFromUser();

        DisplayResult(Compute());
    }

    private void DisplayResult(Matrice resultat) {
        ConsoleManagement.ClearConsole();
        System.out.println(guiTitle + "Resultat:\n" + resultat);
    }

    private void GetValuesFromUser() {
        int indexFirstMatrix;
        int indexSecondMatrix = 1;
        do {
            ConsoleManagement.ClearConsole();
            System.out.printf(guiTitle + "Veuillez selectioner %d matrice(s): ", minMatrices);
            indexFirstMatrix = ConsoleManagement.GetSafeInteger();
            if (minMatrices > 1)
                indexSecondMatrix = ConsoleManagement.GetSafeInteger();
        } while (!IsIntBetween(indexFirstMatrix, 1, Main.matrixList.size()) || !IsIntBetween(indexSecondMatrix, 1, Main.matrixList.size()));

        firstMatrix = Main.matrixList.get(indexFirstMatrix - 1);
        if (minMatrices > 1)
            secondMatrix = Main.matrixList.get(indexSecondMatrix - 1);
        else {
            ConsoleManagement.ClearConsole();
            System.out.print(guiTitle + "Veuillez entrer un scalaire: ");
            scalar = ConsoleManagement.GetSafeDouble();
        }
    }

    private void Init() {
        switch (operator) {
            default:
            case MatrixAddition:
                guiTitle = "Addition (Matrice + Matrice):\n\n";
                minMatrices = 2;
                break;
            case MatrixByMatrixProduct:
                guiTitle = "Produit (Matrice * Matrice):\n\n";
                minMatrices = 2;
                break;
            case MatrixByScalarProduct:
                guiTitle = "Produit (Scalaire * Matrice):\n\n";
                minMatrices = 1;
                break;
        }
    }

    private Matrice Compute() {
        Matrice resultMatrice;
        switch (operator) {
            default:
            case MatrixAddition:
                resultMatrice = firstMatrix.Additionner(secondMatrix);
                break;
            case MatrixByMatrixProduct:
                resultMatrice = firstMatrix.multiply(secondMatrix);
                break;
            case MatrixByScalarProduct:
                resultMatrice = firstMatrix.multiply(scalar);
                break;
        }
        return resultMatrice;
    }

    @Override
    public Gui GetNextMenu() {
        ConsoleManagement.WaitForUserInput();
        return new ArithmeticsGui();
    }
    
}
