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
        motionX = 0;
        motionY = 0;
    }

    public void tick() {
        tickVelocity();
        tickAirResistance();
        tickGravity();
    }

    public void tickVelocity() {
        posX += motionX;
        posY += motionY;
    }

    public void tickAirResistance() {
        motionX /= 1.2;
        motionY /= 1.2;
    }

    public void tickGravity() {
        if (motionY < 20) {
            motionY++;
        }
    }

    public void render(Graphics g) {}
}
