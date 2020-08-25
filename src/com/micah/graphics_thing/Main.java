package com.micah.graphics_thing;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Main {
    public static final int TARGET_TPS = 20;
    public static final int TARGET_FPS = 60;
    public static final double NANOS_PER_SECOND = 1e9D;

    public static Main main;

    public JFrame frame;
    public BufferedImage canvas;
    public Graphics graphics;

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

    public Main() {
        // game logic
        lastTick = System.nanoTime();
        ticks = 0;

        // renderer
        lastRender = System.nanoTime();
        frames = 0;

        displayWidth = 400;
        displayHeight = 400;

        frame = new JFrame();
        canvas = new BufferedImage(displayWidth, displayHeight, BufferedImage.TYPE_INT_RGB);
        graphics = canvas.getGraphics();

        setupFrame();

        entities = new ArrayList<Entity>();
        init();
    }

    private void setupFrame() {
        frame.setUndecorated(true);
        frame.setSize(displayWidth, displayHeight);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    private void init() {

        entities.add(new EntityText("dong", Color.MAGENTA, 200, 200));
    }

    public void run() {
        while(true) {
            long now = System.nanoTime();
            logicDelta = now - lastTick;
            renderDelta = now - lastRender;

            if (logicDelta >= NANOS_PER_SECOND / TARGET_TPS) {
                tps = NANOS_PER_SECOND / logicDelta;
                this.tick();
//                System.out.println(tps);
                lastTick = System.nanoTime();
                ticks++;
            }

            if (renderDelta >= NANOS_PER_SECOND / TARGET_FPS) {
                fps = (int) Math.ceil(NANOS_PER_SECOND / renderDelta);
                this.render();
//                System.out.println(fps);
                lastRender = System.nanoTime();
                frames++;
            }
        }
    }

    public void tick() {
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
        graphics.drawString("FPS: " + Integer.toString(fps), 0, 15);
        graphics.drawString("TPS: " + Integer.toString((int) tps), 0, 30);

        frame.getGraphics().drawImage(canvas, 0, 0, frame);
    }
}
