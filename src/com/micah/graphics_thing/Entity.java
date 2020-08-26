package com.micah.graphics_thing;

import java.awt.*;

public class Entity {
    public double posX;
    public double posY;
    public double motionX;
    public double motionY;
    public int entityId;

    public Entity() {}

    public Entity(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
        motionX = 10;
        motionY = -10;
    }

    public void tick() {
        tickCollisions();
        tickVelocity();
        tickAirResistance();
        tickGravity();
    }

    public void tickVelocity() {
        posX += motionX;
        posY += motionY;
    }

    public void tickAirResistance() {
        motionY *= 0.98D;
    }

    public void tickGravity() {
        if (motionY < 10) {
            motionY += .33D;
        }
    }

    public void tickCollisions() {
        if (posX >= Main.main.displayWidth - 30 || posX <= 0) {
            motionX *= -1;
        }
        if (posY >= Main.main.displayHeight || posY <= 15) {
            motionY *= -1;
        }
    }

    public void render(Graphics g) {}
}
