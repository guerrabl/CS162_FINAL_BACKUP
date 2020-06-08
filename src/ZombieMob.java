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
            float randomXPosition =  p.random(0, p.width);
            float randomYPosition =  p.random(-10, p.height*.15f);
            if(rGen.nextBoolean()){
                mob.add(new Zombie(this.p, randomXPosition ,randomYPosition));
            }
        }
    }
    public void moveMob(){
        for(Automata a: this.mob){
            a.display();
            a.walk();
        }
    }

}
