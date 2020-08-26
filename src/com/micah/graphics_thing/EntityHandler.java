package com.micah.graphics_thing;

import java.awt.*;
import java.util.ArrayList;

public class EntityHandler {
    private ArrayList<Entity> entities;

    public EntityHandler() {
        entities = new ArrayList<Entity>();
    }

    public void tick() {
        for (Entity e : entities) {
            e.tick();
        }
    }

    public void render(Graphics g) {
        for (Entity e : entities) {
            e.render(g);
        }
    }

    public void add(Entity e) {
        entities.add(e);
        e.entityId = entities.size();
    }

    public Entity getEntityWithId(int entityId) throws Exception {
        for (Entity e : entities) {
            if (e.entityId == entityId) {
                return e;
            }
        }
        throw new Exception(String.format("no entity with id %s", entityId));
    }
}
