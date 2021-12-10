public class ManagementGui extends Gui {

    @Override
    public void Draw() {
        System.out.println(
            "Gestion de matrices:\n\n" + 
            "1) Definir nouvelle matrice\n" +
            "2) Afficher matrice\n" +
            "\n" +
            "3) Retour au Menu principal\n" +
            "\n"
        );
        
    }

    @Override
    public Gui GetNextMenu() {
        return UserSelectedGui(new NewMatrixGui(), new DisplayMatrixGui(), new MainGui());
    }
    
}
