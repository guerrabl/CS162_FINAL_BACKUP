import processing.core.PApplet;

import java.util.ArrayList;

public interface Simulator {
    public void findCollidingPairs(Mob humanMob, Mob zombieMob);
    public Automata[] addCollidingPairs(Human human, Zombie zombie);
    public  void updateExplosions();
    public  void runSimulation(HumanMob humanMob, Mob zombieMob, PApplet p);
}
