import processing.core.PApplet;

public class Human extends Automata{

    public boolean infected;
    Human(PApplet sketch, int xPosition, int yPosition){
        super(sketch, xPosition, yPosition);
        colour = sketch.color(0,40,200, (int)sketch.random(0,255));
        infected = false;
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
            this.yPosition = this.yPosition++;
        } else{
            this.yPosition--;
        }
    }
    public void decideCollisionOutcome(Automata zombie, PApplet p){
        int randomNumber = (int) this.p.random(100);
        if(this.getSize() > zombie.getSize()){
            if(randomNumber < LARGER_THAN_ODDS){
                zombie.died();
                // Mob classes will include event listener that listens for when zombies dead flag is true, and remove those instances from arraylist while loop?
                //TODO make sound go off
                zombie.addToExplosions(p);
            } else {
               if (infectedByZombie(20)){
                   //take humans x,y coordinates and size and stores them in temp variables
                   float tempX = this.getxPosition();
                   float tempY = this.getyPosition();
                   int tempSize = this.getSize();
                   //sets infected to true
                   this.hasBeenInfected();
                   //Humanmob class should include listener function that listens for when infected flags return true, and removes it from arraylist
                   // instantiates new zombie object in the zombiemob with the temp parameters declared above

            }
        }
    }

    public boolean isInfected() {
        return infected;
    }

    public void hasBeenInfected() {
        this.infected = true;
    }
    //public void initiateDecisionTree(Automata zombie){
        // if(human.getSize() > z.getSize()){
        //     if(randomNumber < LARGER_THAN_ODDS){
        //     } else{
            //     3. else block of second if-statement. Executes when second condition returns false. Zombie wins battle.
            //     4. runs another meta-simulation on whether human was infected by zombie. 
            //     if block turns human in to zombie
        //         if(infectedByZombie(odds)){
        //             Either typecast the human into zombie, or instantiate new zombie, adding the new zombie to zombies arraylist at exact same coordinates, and size.
        //         }else{
        //             else block destroys human
        //             set off particle system at human coordinates
        //             remove human from arraylist
        //         }
        //     } else if(human.getSize() == z.getSize()){
        //          if(randomNumber < EQUIVALENT_ODDS){
                        //HUMAN WINS! 
                        //set off particle system at human coordinates
                        //play defeat sound
                        //remove z from arrayList   
                //} else{
                        //Zombie wins!
            //         if(infectedByZombie(odds)){
            //             Either typecast the human into zombie, or instantiate new zombie, adding the new zombie to zombies arraylist at exact same coordinates, and size.
            //         }else{
            //             else block destroys human
            //             set off particle system at human coordinates
            //             remove human from arraylist
            //         }
                    //}
                //}
        // } else{
            // ! Small Human Branch
            //2. second if-statement makes a decision on whether human wins or loses based on the weighted probability. 
            //     If block is human winning sequence
            //     if(randomNumber < SMALLER_THAN_ODDS){
            //             zombie loses!
            //             set off particle system at human coordinates
            //             play defeat sound
            //             remove z from arrayList 
            //     } else{
            //          3. else block of second if-statement. Executes when second condition returns false. Zombie wins battle.
            //          4. runs another meta-simulation on whether human was infected by zombie. 
            //          if block turns human in to zombie
            //              if(infectedByZombie(odds)){
            //                  Either typecast the human into zombie, or instantiate new zombie, adding the new zombie to zombies arraylist at exact same coordinates, and size.
            //              }else{
            //                  else block destroys human
            //                  set off particle system at human coordinates
            //                  remove human from arraylist
            //}
        //}
    //}


    public boolean infectedByZombie(int probability){
        int humanBecomesZombie = probability; //TODO CHANGE LATER. TAKE IN USER SIMULATION INPUT
        int rand = (int) this.p.random(100);
        return rand < humanBecomesZombie;
    }
}
