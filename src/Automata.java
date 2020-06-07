import processing.core.PApplet;

public abstract class Automata {
    public static int SMALLER_THAN_ODDS;
    public static int EQUIVALENT_ODDS;
    public static int LARGER_THAN_ODDS;
    public boolean wonConfrontation;
    public int xPosition;
    public int yPosition;
    public PApplet p;
    public int size;
    int colour;


    Automata(PApplet p, int xPosition, int yPosition){
        this.xPosition = xPosition;
        this.yPosition = yPosition;
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
    public abstract void walk();
    public abstract void initiateDecisionTree(Automata a);

}
