import processing.core.PApplet;
import java.util.Scanner;

public class UI {
    public static PApplet p = new PApplet();
    public static int mobPopulation = mobPopulation = (int)p.random(50,300);
    public static void displayCounts(HumanMob m, ZombieMob z, PApplet p){
        p.text(m.getMob().size(), p.width/2, (float) ((float) p.height*.9));
        p.text(z.getMob().size(), p.width/2, (float) ((float) p.height*.1));
    }

    public static int getUserInput(String string) {
        // Create a Scanner object that monitors keyboard input
        Scanner userInput = new Scanner(System.in);
        System.out.print(string);   //user prompt
        return (int) userInput.nextFloat();  //return the integer that the user enters
    }
}
