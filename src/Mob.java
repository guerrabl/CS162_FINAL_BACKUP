import processing.core.PApplet;
import java.util.ArrayList;
import acm.util.*;


public abstract class Mob {
    public static ArrayList<ParticleSystem> explosions = new ArrayList<ParticleSystem>();
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

    void removeFromSimulation(Automata a) {
        mob.remove(a);
    }
    public void listenForDead(){
        for(int i = mob.size()-1; i >= 0; i--) {
            Automata a = mob.get(i);
            if (a.isDead()) {
                this.mob.remove(a);
            }
        }
    }

    void addToSimulation(Automata a) {
        mob.add(a);
    }

    abstract void fillMob();
}
