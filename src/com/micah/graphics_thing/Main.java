package com.micah.graphics_thing;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Main {
    public double targetTps = 60;
    public int targetFps = 60;
    public static final double NANOS_PER_SECOND = 1e9D;

    public static Main main;

    public JFrame frame;
    public BufferedImage canvas;
    public Graphics graphics;

    public KeyHandler keyHandler;

    // List of entities
    public ArrayList<Entity> entities;

    // game logic
    public double tps;
    private long lastTick;
    private long logicDelta;
    public long ticks;

    // renderer
    public int fps;
    private long lastRender;
    private long renderDelta;
    public long frames;

    public int displayWidth;
    public int displayHeight;

    public boolean fastFwd;

    public Main() {
        // game logic
        lastTick = System.nanoTime();
        ticks = 0;

        // renderer
        lastRender = System.nanoTime();
        frames = 0;

        displayWidth = 1000;
        displayHeight = 1000;

        frame = new JFrame();
        canvas = new BufferedImage(displayWidth, displayHeight, BufferedImage.TYPE_INT_RGB);
        graphics = canvas.getGraphics();

        keyHandler = new KeyHandler();

        setupFrame();

        entities = new ArrayList<Entity>();
        init();
    }

    private void setupFrame() {
//        frame.setUndecorated(true);
//        frame.setResizable(false);
        frame.setSize(displayWidth, displayHeight);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.addKeyListener(keyHandler);
    }

    private void init() {
        entities.add(new EntityText("dong", Color.MAGENTA, 500, 500));
    }

    public void run() {
        while (true) {
            long now = System.nanoTime();
            logicDelta = now - lastTick;
            renderDelta = now - lastRender;

            if (logicDelta >= NANOS_PER_SECOND / targetTps) {
                tps = NANOS_PER_SECOND / logicDelta;
                this.tick();
//                System.out.println(tps);
                lastTick = System.nanoTime();
                ticks++;
            }

            if (renderDelta >= NANOS_PER_SECOND / targetFps) {
                fps = (int) Math.ceil(NANOS_PER_SECOND / renderDelta);
                this.render();
//                System.out.println(fps);
                lastRender = System.nanoTime();
                frames++;
            }
        }
    }

    public void tick() {
        if (fastFwd) {
            if (targetTps < 60 * 8) {
                targetTps += 2.5;
            }
        } else {
            for (int i = 0; i < 20; i++) {
                if (targetTps > 60) {
                    targetTps -= .5;
                }
            }
        }

        for (Entity e : entities) {
            e.tick();
        }
    }

    public void render() {
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, displayWidth, displayHeight);

        for (Entity e : entities) {
            e.render(canvas.getGraphics());
        }

        graphics.setColor(Color.GRAY);
        graphics.drawString(String.format("FPS: %d", fps), 0, 15);
        graphics.drawString(String.format("TPS: %.2f", tps), 0, 30);

        frame.getGraphics().drawImage(canvas, 0, 0, frame);
    }
}
