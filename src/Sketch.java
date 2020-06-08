import processing.core.PApplet;
import java.util.ArrayList;

public class Sketch extends PApplet{

    HumanMob humanMob;
    ZombieMob zombieMob;
    ArrayList<Automata[]> collidingObjects = new ArrayList<Automata[]>();
    final String openingString = "Enter number between 0 and 100 to set the probability for the event that ";
    int userNumber = UI.getUserInput("Enter a Number");
    int SMALLPROBABILITY = UI.getUserInput(openingString + "Smaller defeats ");

    public void settings(){
        size(500,500);
    }

    public void setup(){
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
        findCollidingPairs();
        for(int i=collidingObjects.size()-1; i >= 0; --i){
            Automata[] pair = collidingObjects.get(i);
            Human human = (Human)pair[0];
            Zombie zombie = (Zombie)pair[1];
            humanMob.listenForInfections();
            humanMob.listenForDead();
            zombieMob.listenForDead();
            human.decideCollisonOutcome(zombie, zombieMob, this);
            collidingObjects.remove(i);
        }

        for(int i=0; i < Mob.explosions.size(); ++i){
            Mob.explosions.get(i).draw();
            Mob.explosions.get(i).update();
        }
    }

    public Automata[] addCollidingPairs(Human human, Zombie zombie){
        Automata[] collidingPair = new Automata[2];
        collidingPair[0] = human;
        collidingPair[1] = zombie;
        return collidingPair;
    }

    public void findCollidingPairs(){
        for(Automata human: humanMob.getMob()){
            for(Automata zombie: zombieMob.getMob()){
                human = (Human)human;
                if(human.detectCollision(zombie)) {
                    collidingObjects.add(addCollidingPairs((Human)human, (Zombie) zombie));
                }
            }
        }
    }
}

