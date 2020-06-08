// Zombie Outbreak Simulator
// CS162 -Intro to Computer Science II
// Program Created by Blaize Guerra
// This program runs a probabilistic zombie outbreak simulation.
import processing.core.PApplet;

import java.util.ArrayList;

public interface Simulator {
    public void findCollidingPairs(Mob humanMob, Mob zombieMob);
    public Automata[] addCollidingPairs(Human human, Zombie zombie);
    public  void updateExplosions();
    public  void runSimulation(HumanMob humanMob, Mob zombieMob, PApplet p);
}
