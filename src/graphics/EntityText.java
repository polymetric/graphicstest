package graphics;

import java.awt.*;

public class EntityText extends Entity {
    public Color color;
    public String text;

    public EntityText(int posX, int posY, Color color, String text) {
        super(posX, posY);
        this.color = color;
        this.text = text;
    }

    @Override
    public void render(Graphics g) {
        super.render(g);
        g.setColor(this.color);
        System.out.println(this.text);
        g.drawString(this.text, this.posX, this.posY);
    }
}
