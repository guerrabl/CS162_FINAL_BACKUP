import processing.core.PApplet;
import java.util.ArrayList;

public class ZombieMob extends Mob{


    ZombieMob(PApplet sketch){
        super(sketch);
        this.mob = new ArrayList<Automata>();

    }
    @Override
    public void fillMob(){
        for(int i=0; i < mobPopulation; ++i){
            if(rGen.nextBoolean()){
                mob.add(new Zombie(this.sketch,(int) sketch.random(0, sketch.width),(int) sketch.random(0, sketch.height/2)));
            }
        }
    }
    public void moveMob(){
        for(Automata a: this.mob){
            a.display();
            a.walk();
        }
    }
    @Override
    void removeFromSimulation() {

    }

    @Override
    void addToSimulation() {

    }

}
