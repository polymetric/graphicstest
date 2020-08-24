package graphics;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Main extends Canvas {
	public long ticks;
	public long frames;
	public ArrayList<Entity> entities;
	public EntityText fpsCounter;

	public Main() {
		entities = new ArrayList<Entity>();
		init();
	}

	public void init() {
		ticks = 0;
		frames = 0;
		entities.add(new EntityText(200, 200, Color.MAGENTA, "dong"));
		fpsCounter = new EntityText(0, 15, Color.BLACK, "FPS: 0");
		entities.add(fpsCounter);
	}

	public void paint(Graphics g) {
		setBackground(Color.BLACK);

		g.setColor(Color.MAGENTA);
		g.fillRect(0, 0, 200, 200);
		g.setColor(Color.MAGENTA);
		g.fillRect(200, 200, 200, 200);

		for (Entity e : entities) {
			e.render(g);
		}
	}

	public void tick() {
		for (Entity e : entities) {
			e.tick();
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

		// game logic
		final int targetTps = 20;
		double tps = 0;
		long lastTick = System.nanoTime();
		long logicDelta = 0;

		// renderer
		final int targetFps = 24;
		int fps = 0;
		long lastRender = System.nanoTime();
		long renderDelta = 0;

		while (true) {
			long now = System.nanoTime();
			logicDelta = now - lastTick;
			renderDelta = now - lastRender;

			if (logicDelta > 1e9D / targetTps) {
				m.tick();
				tps = 1e9D / logicDelta;
//				System.out.println(tps);
				lastTick = System.nanoTime();
				m.ticks++;
			}

			if (renderDelta > 1e9D / targetFps) {
				fps = (int) Math.ceil(1e9D / renderDelta);
//				fps = (int) Math.round(1e9D / renderDelta);
//				System.out.println(fps);
				m.fpsCounter.text = Integer.toString(fps);
				m.paint(f.getGraphics());
				lastRender = System.nanoTime();
				m.frames++;
			}
		}
	}
}