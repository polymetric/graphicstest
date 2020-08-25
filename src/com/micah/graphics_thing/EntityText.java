package com.micah.graphics_thing;

import java.awt.*;

public class EntityText extends Entity {
    public String text;
    public Color color;
    public HitboxRect hitbox;

    public EntityText(String text, Color color, int posX, int posY) {
        super(posX, posY);
        this.color = color;
        this.text = text;
    }

    @Override
    public void tick() {
//        System.out.println(posX);
        if (posX >= 400 - 30 || posX <= 0) {
            motionX *= -1;
        }
        if (posY >= 400 || posY <= 15) {
            motionY *= -1;
        }

        super.tick();
    }

    @Override
    public void render(Graphics g) {
        g.setColor(color);
        g.drawString(text, (int) posX, (int) posY);
    }
}
