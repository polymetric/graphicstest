package com.micah.graphics_thing;

public class HitboxRect implements Hitbox {
    public int posX;
    public int posY;
    public int sizeX;
    public int sizeY;

    public HitboxRect(Entity parent, int sizeX, int sizeY) {
        this(sizeX, sizeY);
    }

    public HitboxRect(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }

    @Override
    public boolean intersectsWith(Hitbox h) {
        if(h instanceof HitboxRect) {

        }
        return false;
    }
}
