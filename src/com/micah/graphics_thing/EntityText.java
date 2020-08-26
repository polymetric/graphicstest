package com.micah.graphics_thing;

import java.awt.*;

public class EntityText extends Entity {
    public String text;
    public Color color;

    public EntityText(String text, Color color, int posX, int posY) {
        super(posX, posY);
        this.color = color;
        this.text = text;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(color);
        g.drawString(text, (int) posX, (int) posY);
    }
}
