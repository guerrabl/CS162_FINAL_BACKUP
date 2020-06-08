import processing.core.PApplet;
import java.util.ArrayList;

public class Sketch extends PApplet{
    float increment = 0.05f;
    float zoff = 0.0f;
    float zincrement = 0.05f;

    HumanMob humanMob;
    ZombieMob zombieMob;
    OpenSimplexNoise noise;
    UI sim;
    final String openingString = "Enter number between 0 and 100 to set the probability for the event that.";

    public void settings(){
        size(500,500);
    }

    public void setup(){
        sim = new UI();
        noise = new OpenSimplexNoise();
        humanMob = new HumanMob(this);
        humanMob.fillMob();
        zombieMob = new ZombieMob(this);
        zombieMob.fillMob();
    }

    public void draw(){
        doThings();
//        background(255);
        fill(50);
        UI.displayCounts(humanMob,zombieMob,this);
        humanMob.moveMob();
        zombieMob.moveMob();
        sim.findCollidingPairs(humanMob, zombieMob);
        sim.runSimulation(humanMob, zombieMob, this);
        sim.updateExplosions();
    }
    public void doThings(){
        // Optional: adjust noise detail here
        noiseDetail(8,0.65f);
        loadPixels();
        float xoff = 0.0f; // Start xoff at 0
        // For every x,y coordinate in a 2D space, calculate a noise value and produce a brightness value
        for (int x = 0; x < width; x++) {
            xoff += increment;   // Increment xoff
            float yoff = 0.0f;   // For every xoff, start yoff at 0
            for (int y = 0; y < height; y++) {
                yoff += increment; // Increment yoff
                // Calculate noise and scale by 255
                float n = (float) noise.eval(xoff,yoff,zoff);
                float bright = map(n, -1,1,-0,255);
                // Try using this line instead
                //float bright = random(0,255);
                // Set each pixel onscreen to a grayscale value
                pixels[x+y*width] = color(bright,bright,0);
            }
        }
        updatePixels();
        zoff += zincrement; // Increment zoff
    }
}

