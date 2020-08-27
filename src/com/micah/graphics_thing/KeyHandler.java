package com.micah.graphics_thing;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    @Override
    public void keyPressed(KeyEvent e) {
        int k = e.getKeyCode();

        if (k == KeyEvent.VK_L) {
            Main.main.fastFwd = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int k = e.getKeyCode();

        if (k == KeyEvent.VK_L) {
            Main.main.fastFwd = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}
}
