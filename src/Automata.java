import processing.core.PApplet;
import java.util.ArrayList;

public abstract class Automata {
    public static ArrayList<ParticleSystem> explosions = new ArrayList<ParticleSystem>();
    public static int SMALLER_THAN_ODDS;
    public static int EQUIVALENT_ODDS;
    public static int LARGER_THAN_ODDS;
    public boolean dead;
    public int xPosition;
    public int yPosition;
    public PApplet p;
    public int size;
    int colour;


    Automata(PApplet p, int xPosition, int yPosition){
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.dead = false;
        this.p = p;
    }

    public void display(){
        this.p.fill(colour);
        this.p.circle(this.xPosition,this.yPosition,this.size);
    }

    public int probabilisticSize(){
        int randomNumber = (int) this.p.random(90);
        if (randomNumber < 30){
            return 15;
        } else if (randomNumber < 60){
            return 30;
        } else {
            return 45;
        }
    }

    public boolean detectCollision(Automata automata){
        return (p.dist(this.xPosition,this.yPosition, automata.xPosition, automata.yPosition) < ((this.size/2)+(automata.size/2)));
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }


    public void addToExplosions(PApplet p){
        this.explosions.add(new ParticleSystem(this.getxPosition(), this.getyPosition(), p));
    }

    public int getxPosition() {
        return xPosition;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public boolean isDead() {
        return dead;
    }

    public void died() {
        this.dead = true;
    }

    public abstract void walk();
    public abstract void initiateDecisionTree(Automata a);

}
