// Zombie Outbreak Simulator
// CS162 -Intro to Computer Science II
// Program Created by Blaize Guerra
// This program runs a probabilistic zombie outbreak simulation.
import processing.core.PApplet;
public class Particle {

    PApplet p;

    final double ACCELERATION = 0.1;

    private float x;
    private float y;
    private float xVelocity;
    private float yVelocity;
    private int colour;
    private float size;

    Particle(PApplet p) {
        this.p=p;
        x = p.mouseX;
        y = p.mouseY;
        xVelocity = p.random(-5, 5);
        yVelocity = p.random(-4, 0);
        colour = p.color(p.random(100, 255), p.random(100, 255), p.random(100, 255), 75);
        size = p.random(10, 20);
    }

    Particle(float x, float y, PApplet p) {
        this.x = x;
        this.y = y;
        this.p=p;
        xVelocity = p.random(-2, 2);
        yVelocity = p.random(-4, 0);
        colour = p.color(p.random(100, 255), p.random(100, 255), p.random(100, 255), 75);
        size = p.random(2, 10);
    }

    void draw() {
        p.stroke(150);
        p.fill(colour);
        p.ellipse(x, y, size, size);
    }

    void move() {
        x += xVelocity;
        y += yVelocity;
        yVelocity += ACCELERATION;
    }

    boolean onScreen(){
        return x < p.width && x > 0 && y > 0 && y < p.height;
    }
}