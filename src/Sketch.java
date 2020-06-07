import processing.core.PApplet;
import java.util.ArrayList;

public class Sketch extends PApplet{

    HumanMob humanMob;
    ZombieMob zombieMob;

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
        UI.displayCounts(humanMob, this);
        humanMob.moveMob();
        zombieMob.moveMob();
        humanMob.whoIsTouching(zombieMob.getMob());
    }
}
