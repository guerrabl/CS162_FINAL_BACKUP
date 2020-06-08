// Zombie Outbreak Simulator
// CS162 -Intro to Computer Science II
// Program Created by Blaize Guerra
// This program runs a probabilistic zombie outbreak simulation.
import processing.core.PApplet;
import java.util.ArrayList;

public class HumanMob extends Mob{


    HumanMob(PApplet p){
        super(p);
        this.mob = new ArrayList<Automata>();

    }

    @Override
    public void fillMob(){
        for(int i=0; i < UI.mobPopulation; ++i){
            int randomNumber = (int) p.random(0,100);
            float randomXPosition = p.random(0, p.width);
            float randomYPosition = p.random(p.height*.85f,p.height+10);
            if(randomNumber < 50){
                mob.add(new Human(this.p,randomXPosition,randomYPosition));
            }
        }
    }



    public void listenForInfections(){
        for(int i = mob.size()-1; i >= 0; i--){
            Human h = (Human) mob.get(i);
            if(h.isInfected()){
                this.mob.remove(h);
            }
        }
    }

}
