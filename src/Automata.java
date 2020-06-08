import processing.core.PApplet;
import java.util.ArrayList;

public abstract class Automata {
    public static int SMALLER_THAN_ODDS = 20;
    public static int EQUIVALENT_ODDS = 50;
    public static int LARGER_THAN_ODDS = 75;

    private boolean dead;
    private boolean currentlyInBattle;

    protected PApplet p;
    protected float xPosition;
    protected float yPosition;
    protected int size;
    protected int colour;


    Automata(PApplet p, float xPosition, float yPosition){
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.dead = false;
        this.currentlyInBattle = false;
        this.p = p;
    }

    public void display(){
        this.p.fill(colour);
        this.p.circle(this.xPosition,this.yPosition,this.size);
    }

    public int probabilisticSize(){
        int randomNumber = (int) this.p.random(90);
        if (randomNumber < 30){
            return (int) p.random(4,12);
        } else if (randomNumber < 60){
            return (int) p.random(12,24);
        } else {
            return (int) p.random(24,36);
        }
    }

    public boolean detectCollision(Automata automata){
        return (p.dist(this.xPosition,this.yPosition, automata.xPosition, automata.yPosition) < ((this.size/2)+(automata.size/2)));
    }

    public void addToExplosions(PApplet p){
        Mob.explosions.add(new ParticleSystem(this.getxPosition(), this.getyPosition(), p));
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public float getxPosition() {
        return xPosition;
    }
    public float getyPosition() {
        return yPosition;
    }

    public void setCurrentlyInBattle() {
        this.currentlyInBattle = !this.currentlyInBattle;
    }

    public boolean isDead() {
        return dead;
    }

    public void died() {
        this.dead = true;
    }

    public abstract void walk();

}
