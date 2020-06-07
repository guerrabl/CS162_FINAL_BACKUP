import processing.core.PApplet;
import java.util.ArrayList;
import acm.util.*;


public abstract class Mob {

    public static RandomGenerator rGen = RandomGenerator.getInstance();
    public static int mobPopulation = 200;
    public PApplet p;
    
    protected ArrayList<Automata> mob;

    Mob(PApplet p){
        this.p = p;
    }

    public int getMobPopulation() {

        return mobPopulation;
    }

    public ArrayList<Automata> getMob() {

        return mob;
    }
    public void whoIsTouching(ArrayList<Automata> checkMob){
        for(Automata a: mob){
            for(Automata z: checkMob){
                if (a.detectCollision(z)){

                }
            }
        }
    }
    abstract void removeFromSimulation();
    abstract void addToSimulation();
    abstract void fillMob();
}
