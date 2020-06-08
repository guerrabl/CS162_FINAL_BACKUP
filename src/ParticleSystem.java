// Zombie Outbreak Simulator
// CS162 -Intro to Computer Science II
// Program Created by Blaize Guerra
// This program runs a probabilistic zombie outbreak simulation.
import processing.core.PApplet;

import java.util.ArrayList;

public class ParticleSystem {

    private final int NUMBER_OF_PARTICLES = 50;
    private ArrayList<Particle> particles;
    private PApplet p;
    private float x;
    private float y;

    ParticleSystem(PApplet p) {
        particles = new ArrayList<Particle>();
        this.p = p;
        x = p.width / 2;
        y = p.height / 2;
        for (int i = 0; i < NUMBER_OF_PARTICLES; ++i) {
            particles.add(new Particle(x, y,p));
        }
    }

    ParticleSystem(float x, float y, PApplet p) {
        this.x = x;
        this.y = y;
        this.p = p;
        particles = new ArrayList<Particle>();
        for (int i = 0; i < NUMBER_OF_PARTICLES; ++i) {
            particles.add(new Particle(x, y,p));
        }
    }

    void update() {
        for (Particle p : particles) {
            p.move();
        }
    }

    void draw() {
        for (Particle p : particles) p.draw();
    }

    public ArrayList<Particle> getParticles() {
        return particles;
    }

    public boolean isFinished(){
        boolean allParticlesOffScreen = true;
        for (Particle p: particles) {
            if(p.onScreen()){
                allParticlesOffScreen = false;
                break;
            }
        }
        return allParticlesOffScreen;
    }
}