package com.artemis.demo.events;

import com.artemis.Entity;
import com.artemis.World;
import com.artemis.demo.events.components.PositionComponent;
import com.artemis.demo.events.components.VelocityComponent;
import com.artemis.demo.events.systems.MovementSystem;
import com.artemis.demo.events.systems.RenderingSystem;
import com.artemis.demo.events.systems.ResetPositionSystem;
import com.artemis.systems.event.BasicEventDeliverySystem;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class EventGameDemo extends Game {

    public static final int GAME_WIDTH = 400;
    public static final int GAME_HEIGHT = 400;

    World world;
    OrthographicCamera camera;

    /**
     * Initializes all of the in-game objects
     */
    @Override
    public void create() {

        // create a camera
        camera = new OrthographicCamera();

        createWorld();

        //create a few of entities
        createEntity(200, 200, 80, 80);
        createEntity(200, 200, -80, 80);
        createEntity(200, 200, 80, -80);
        createEntity(200, 200, -80, -80);
    }

    /**
     * Creates the world and adds entity systems to it.
     */
    protected void createWorld() {
        world = new World();

        world.setEventDeliverySystem(new BasicEventDeliverySystem());
        world.setSystem(new MovementSystem());
        world.setSystem(new ResetPositionSystem());
        world.setSystem(new RenderingSystem(camera));

        world.initialize();
    }

    /**
     * Creates an entity with a given position (x, y) and velocity (vx, vy)
     */
    protected void createEntity(float x, float y, float vx, float vy) {
        Entity e = world.createEntity();

        PositionComponent pc = world.createComponent(PositionComponent.class);
        pc.position.set(x, y);
        e.addComponent(pc);

        VelocityComponent vc = world.createComponent(VelocityComponent.class);
        vc.velocity.set(vx, vy);
        e.addComponent(vc);

        e.addToWorld();
    }

    /**
     * Game loop.
     */
    @Override
    public void render() {
        world.setDelta(Gdx.graphics.getDeltaTime());
        world.process();
    }

    /**
     * Update the camera if the game screen is resized.
     */
    @Override
    public void resize(int width, int height) {
        float centerX = width / 2.0f;
        float centerY = height / 2.0f;

        this.camera.position.set(centerX, centerY, 0);
        this.camera.viewportWidth = width;
        this.camera.viewportHeight = height;
    }
}
