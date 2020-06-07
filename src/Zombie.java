import processing.core.PApplet;

public class Zombie extends Automata{


    Zombie(PApplet sketch, int xPosition, int yPosition){
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
            this.yPosition = this.yPosition--;
        } else{
            this.yPosition++;
        }
    }

    public void initiateDecisionTree(Automata human){
        // first if-statement does comparision of zombie and human size
        // if(zombie.getSize() > human.getSize()){
        //     if-block is zombie winning sequence
        //     if(randomNumber < LARGER_THAN_ODDS){
        //          zombie wins!
        //          if(human.infectedByZombie(odds)){
        //              Either typecast the human into zombie, or instantiate new zombie, adding the new zombie to zombies arraylist at exact same coordinates, and size.
        //          } else{ 
                            //set off particle system at human coordinates
                            //play defeat sound
                            //remove human from arrayList  
        //                }
        //      }else{
                        //human wins!
                        //set off particle system at human coordinates
                        //play defeat sound
                        //remove human from arrayList
        // } else if(zombie.getSize() == human.getSize()){
        //          if(randomNumber < EQUIVALENT_ODDS){
            //          zombie wins
            //          if(human.infectedByZombie(odds)){
            //              Either typecast the human into zombie, or instantiate new zombie, adding the new zombie to zombies arraylist at exact same coordinates, and size.
        //              } else{ 
                            //set off particle system at human coordinates
                            //play defeat sound
                            //remove human from arrayList  
        //              }
        //  } else{
                    //randomNumber < SMALLER_THAN_ODDS
                    //human wins!
                    //set off particle system at human coordinates
                    //play defeat sound
                    //remove zombie from arrayList
        //      }         
        }
}
