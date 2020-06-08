// Zombie Outbreak Simulator
// CS162 -Intro to Computer Science II
// Program Created by Blaize Guerra
// This program runs a probabilistic zombie outbreak simulation.
import processing.core.PApplet;

public class Zombie extends Automata{


    Zombie(PApplet sketch, float xPosition, float yPosition){
        super(sketch, xPosition, yPosition);
        colour = sketch.color(200,40,0, (int)sketch.random(0,255));
        size = probabilisticSize();
    }

    @Override
    public void walk() {
        int randomNumber = (int) this.p.random(100);
        if (randomNumber < 25){
            this.xPosition++;
        } else if (randomNumber < 50){
            this.xPosition--;
        } else if (randomNumber < 90){
            this.yPosition++;
        } else{
            this.yPosition--;
        }
    }


}
