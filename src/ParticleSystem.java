import processing.core.PApplet;

import java.util.ArrayList;

public class ParticleSystem {

    final int NUMBER_OF_PARTICLES = 100;
    ArrayList<Particle> particles;
    PApplet p;
    int x;
    int y;

    ParticleSystem(PApplet p) {
        particles = new ArrayList<Particle>();
        this.p = p;
        x = p.width / 2;
        y = p.height / 2;
        for (int i = 0; i < NUMBER_OF_PARTICLES; ++i) {
            particles.add(new Particle(x, y,p));
        }
    }

    ParticleSystem(int x, int y, PApplet p) {
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

    public int getNUMBER_OF_PARTICLES() {
        return NUMBER_OF_PARTICLES;
    }

    public ArrayList<Particle> getParticles() {
        return particles;
    }

    public void setParticles(ArrayList<Particle> particles) {
        this.particles = particles;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}