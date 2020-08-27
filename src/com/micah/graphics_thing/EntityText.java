package com.micah.graphics_thing;

import java.awt.*;
import java.util.Random;

public class EntityText extends Entity {
    public String text;
    public Color color;
    private Random rand = new Random();

    public EntityText(String text, Color color, int posX, int posY) {
        super(posX, posY);
        this.color = color;
        this.text = text;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(color);
        g.drawString(text, (int) (posX + (rand.nextDouble()*10 - rand.nextDouble()*10)), (int) (posY + (rand.nextDouble()*10 - rand.nextDouble()*10)));
    }
}
