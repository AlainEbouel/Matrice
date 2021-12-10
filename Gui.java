import java.util.Scanner;

public abstract class Gui {
    public abstract void Draw();
    public abstract Gui GetNextMenu();
    public void Clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    
    protected Gui UserSelectedGui(Gui... Options) {
        int userChoice = UserChoice();

        if ((userChoice < 1) || (userChoice > Options.length))
            return this;
        return Options[userChoice - 1];
    }

    @SuppressWarnings("resource")
    private int UserChoice() {
        Scanner inputScanner = new Scanner(System.in);
        
        System.out.println("Veuillez choisir une option: ");
        
        while (inputScanner.hasNext()) {
            if (inputScanner.hasNextInt())
                return inputScanner.nextInt();
            else
                inputScanner.next();
        }
        return 0;
    }
}