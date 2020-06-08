import processing.core.PApplet;

import java.util.ArrayList;
import java.util.Scanner;

public class UI implements Simulator{
    public static ArrayList<Automata[]> collidingObjects = new ArrayList<Automata[]>();
    public static PApplet p = new PApplet();
    public static int mobPopulation = mobPopulation = (int)p.random(50,300);
//Did not have time user input working properly
//    final static String openingString = "Enter number between 0 and 100 to set the probability for the event that ";
//    public static int SMALLPROBABILITY = UI.getUserInput(openingString + "the smaller automaton defeats the larger ");
//    public static int MEDIUMPROBABILITY = UI.getUserInput(openingString + "the larger automaton defeats the smaller ");
//    public static int LARGEPROBABILITY = UI.getUserInput(openingString + "when both automaton are the same size");
//    public static int INFECTIONPROBBABILITY = UI.getUserInput(openingString + "the human turns in to a zombie rather dying");
    public static int SMALLPROBABILITY = 15;
    public static int MEDIUMPROBABILITY = 50;
    public static int LARGEPROBABILITY = 70;
    public static int INFECTIONPROBBABILITY = 20;
    public static void displayCounts(HumanMob m, ZombieMob z, PApplet p){
        p.text(m.getMob().size(), p.width/2, (float) ((float) p.height*.9));
        p.text(z.getMob().size(), p.width/2, (float) ((float) p.height*.1));
    }

    public static int getUserInput(String string) {
        // Create a Scanner object that monitors keyboard input
        Scanner userInput = new Scanner(System.in);
        System.out.print(string);   //user prompt
        return (int) userInput.nextFloat();  //return the integer that the user enters
    }

    public void findCollidingPairs(Mob humanMob, Mob zombieMob){
        for(Automata human: humanMob.getMob()){
            for(Automata zombie: zombieMob.getMob()){
                human = (Human)human;
                if(human.detectCollision(zombie)) {
                    collidingObjects.add(addCollidingPairs((Human)human, (Zombie) zombie));
                }
            }
        }
    }

    public Automata[] addCollidingPairs(Human human, Zombie zombie){
        Automata[] collidingPair = new Automata[2];
        collidingPair[0] = human;
        collidingPair[1] = zombie;
        return collidingPair;
    }

    public void updateExplosions(){
        for(int i = Mob.explosions.size()-1; i >= 0; i--){
            Mob.explosions.get(i).draw();
            Mob.explosions.get(i).update();
            if(Mob.explosions.get(i).isFinished()){
                Mob.explosions.remove(i);
            }

        }
    }
    public void runSimulation(HumanMob humanMob, Mob zombieMob, PApplet p){
        for(int i=collidingObjects.size()-1; i >= 0; --i){
            Automata[] pair = collidingObjects.get(i);
            Human human = (Human)pair[0];
            Zombie zombie = (Zombie)pair[1];
            humanMob.listenForInfections();
            humanMob.listenForDead();
            zombieMob.listenForDead();
            human.decideCollisonOutcome(zombie, zombieMob, p);
            collidingObjects.remove(i);
        }
    }

}
