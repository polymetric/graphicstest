package graphics;

import java.awt.*;

public class Entity {
    public int posX;
    public int posY;

    public Entity() {}

    public Entity(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public void render(Graphics g) {}

    public void tick() {
        posX++;
    }
}
