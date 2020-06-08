import processing.core.PApplet;
import processing.sound.*;

public class Human extends Automata {

    private boolean infected;
    SoundFile sound;
    Human(PApplet sketch, float xPosition, float yPosition) {
        super(sketch, xPosition, yPosition);
        colour = sketch.color(0, 40, 200, (int) sketch.random(0, 255));
        infected = false;
        size = probabilisticSize();
        sound = new SoundFile(sketch, "ouch.wav");
    }

    @Override
    public void walk() {
        int randomNumber = (int) this.p.random(100);
        if (randomNumber < 25) {
            this.xPosition++;
        } else if (randomNumber < 50) {
            this.xPosition--;
        } else if (randomNumber < 90) {
            this.yPosition--;
        } else {
            this.yPosition++;
        }
    }

    public void decideCollisonOutcome(Zombie zombie, Mob zombieMob, PApplet p) {
        int randomNumber = (int) this.p.random(100);
        if (this.getSize() > zombie.getSize()) {
            if (randomNumber < LARGER_THAN_ODDS) {
                humanWinsBranch(zombie);
            } else {
                zombieWinsBranch(zombie, zombieMob);
            }

        } else if (this.getSize() == zombie.getSize()){
            if(randomNumber < EQUIVALENT_ODDS){
                humanWinsBranch(zombie);
            }
            else {
                zombieWinsBranch(zombie, zombieMob);
            }
        }
        else{
            if(randomNumber < SMALLER_THAN_ODDS){
                humanWinsBranch(zombie);
            }
            else {
                zombieWinsBranch(zombie, zombieMob);
            }
        }
    }

    public boolean isInfected () {
        return infected;
    }

    public void setInfected () {
        this.infected = true;
    }

    public boolean infectedByZombie(int probability){
        int humanBecomesZombieProb = 10; //TODO CHANGE LATER. TAKE IN USER SIMULATION INPUT
        int rand = (int) this.p.random(100);
        return rand < humanBecomesZombieProb;
    }

    public void humanWinsBranch(Automata zombie){
        // Human wins confrontation branch
        zombie.addToExplosions(p);
        zombie.died();
        // Mob classes will include event listener that listens for when zombies dead flag is true, and remove those instances from arraylist while loop?
        sound.play();
        this.setCurrentlyInBattle();
    }

    public void zombieWinsBranch(Automata zombie, Mob zombieMob){
        if (infectedByZombie(20)) {
            float tempX = this.getxPosition();
            float tempY = this.getyPosition();
            int tempSize = this.getSize();
            this.setInfected();

            Zombie infectedHuman = new Zombie(p,tempX, tempY);
            infectedHuman.setSize(tempSize);
            zombieMob.addToSimulation(infectedHuman);
            zombie.setCurrentlyInBattle();

        } else {
            this.died();
            zombie.setCurrentlyInBattle();
        }
    }
}