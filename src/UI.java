import processing.core.PApplet;
import java.util.Scanner;
public class UI {
    
    public static void displayCounts(HumanMob m, PApplet p){
        p.text(m.getMob().size(), p.width/2, (float) ((float) p.height*.9));
//        p.text(z.getMob().size(), p.width/2, (float) ((float) p.height*.1));
    }

    private static int getUserInput(String string) {
        // Create a Scanner object that monitors keyboard input
        Scanner userInput = new Scanner(System.in);
        System.out.print(string);   //user prompt
        return (int) userInput.nextFloat();  //return the integer that the user enters
    }
}