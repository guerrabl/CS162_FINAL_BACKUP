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
                mob.add(new Zombie(this.p,(int) p.random(0, p.width),(int) p.random(0, p.height/2)));
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
    void removeFromSimulation(Zombie zombie) {
        mob.
    }

    @Override
    void addToSimulation() {

    }

}
