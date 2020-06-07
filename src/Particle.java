import processing.core.PApplet;
public class Particle {

    PApplet p;

    final double ACCELERATION = 0.1;

    float x;
    float y;
    float xVelocity;
    float yVelocity;
    int colour;
    float size;

    Particle(PApplet p) {
        this.p=p;
        x = p.mouseX;
        y = p.mouseY;
        xVelocity = p.random(-5, 5);
        yVelocity = p.random(-4, 0);
        colour = p.color(p.random(100, 255), p.random(100, 255), p.random(100, 255), 75);
        size = p.random(10, 20);
    }

    Particle(int x, int y, PApplet p) {
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

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getxVelocity() {

        return xVelocity;
    }

    public void setxVelocity(float xVelocity) {
        this.xVelocity = xVelocity;
    }

    public int getColour() {
        return colour;
    }

    public void setColour(int colour) {

        this.colour = colour;
    }
}