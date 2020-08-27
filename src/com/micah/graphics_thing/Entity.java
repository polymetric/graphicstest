package com.micah.graphics_thing;

import java.awt.*;

public class Entity {
    public static final double LIMIT_VEL_UPPER = 10;
    public static final double LIMIT_VEL_LOWER = 0.1;

    public double posX;
    public double posY;
    public double velX;
    public double velY;
    public int entityId;

    public Entity() {
    }

    public Entity(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
        velX = 200;
        velY = -200;
    }

    public void tick() {
        tickCollisions();
        tickAirResistance();
        tickGravity();

        tickVelocity();
    }

    public void tickVelocity() {
        posX += velX/Main.main.tps;
        posY += velY/Main.main.tps;
    }

    public void tickAirResistance() {
        velX *= 0.98D;
        velY *= 0.98D;
    }

    public void tickGravity() {
        velY += 20;
    }

    public void tickCollisions() {
        if (posX >= Main.main.displayWidth - 30 || posX <= 0) {
            velX *= -1;
        }
        if (posY >= Main.main.displayHeight || posY <= 15) {
            velY *= -1;
        }
    }

    public void render(Graphics g) {}
}
