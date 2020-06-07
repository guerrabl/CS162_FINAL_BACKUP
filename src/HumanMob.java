import processing.core.PApplet;
import java.util.ArrayList;

public class HumanMob extends Mob{


    HumanMob(PApplet p){
        super(p);
        this.mob = new ArrayList<Automata>();

    }
    @Override
    public void fillMob(){
        for(int i=0; i < mobPopulation; ++i){
            if(rGen.nextBoolean()){
                mob.add(new Human(this.p,(int) p.random(0, p.width),(int) p.random(p.height/2, p.height)));
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
