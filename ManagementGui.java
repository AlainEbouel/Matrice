public class ManagementGui extends Gui {

    @Override
    public void Draw() {
        System.out.println(
            "Gestion de matrices:\n\n" + 
            "1) Definir nouvelle matrice\n" +
            "2) Afficher matrice\n" +
            "3) Supprimer matrice\n" +
            "\n" +
            "4) Retour au Menu principal\n" +
            "\n"
        );
        
    }

    @Override
    public Gui GetNextMenu() {
        return UserSelectedGui(new NewMatrixGui(), new DisplayMatrixGui(), new DeleteMatrixGui(), new MainGui());
    }
    
}
