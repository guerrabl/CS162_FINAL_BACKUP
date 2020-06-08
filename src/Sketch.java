import processing.core.PApplet;
import java.util.ArrayList;

public class Sketch extends PApplet{

    HumanMob humanMob;
    ZombieMob zombieMob;
    UI sim;
    final String openingString = "Enter number between 0 and 100 to set the probability for the event that ";
//    int userNumber = UI.getUserInput("Enter a Number");
//    int SMALLPROBABILITY = UI.getUserInput(openingString + "Smaller defeats ");

    public void settings(){
        size(500,500);
    }

    public void setup(){
        sim = new UI();
        humanMob = new HumanMob(this);
        humanMob.fillMob();
        zombieMob = new ZombieMob(this);
        zombieMob.fillMob();
    }

    public void draw(){
        background(255);
        fill(50);
        UI.displayCounts(humanMob,zombieMob,this);
        humanMob.moveMob();
        zombieMob.moveMob();
        sim.findCollidingPairs(humanMob, zombieMob);
        sim.runSimulation(humanMob, zombieMob, this);
        sim.updateExplosions();
    }

}

