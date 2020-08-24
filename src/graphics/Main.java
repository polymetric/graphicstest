package graphics;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class Main extends Canvas {

	int dongPos = 50;

	public void paint(Graphics g) {
		setBackground(Color.BLACK);
		g.setColor(Color.MAGENTA);
		g.fillRect(0, 0, 200, 200);
		g.setColor(Color.BLACK);
		g.drawString("dong", dongPos, dongPos);
		g.setColor(Color.MAGENTA);
		g.fillRect(200, 200, 200, 200);
		if(!(dongPos < 200)) {
			dongPos++;
			System.out.println(dongPos);
		}
	}

	public static void main(String[] args) {
		Main m = new Main();
		JFrame f = new JFrame();
		f.setUndecorated(true);
		f.add(m);
		f.setSize(400, 400);
		// f.setLayout(null);
		f.setVisible(true);
		f.setLocationRelativeTo(null);
	}

}