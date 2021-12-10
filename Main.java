public class Main {

    public static void main(String[] args) {

        Gui currentGui = new MainGui();

        while (currentGui != null) {
            currentGui.Clear();            
            currentGui.Draw();
            currentGui = currentGui.GetNextMenu();
        }
    }

}
