package com.artemis.demo.quick.systems;

import com.artemis.Filter;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.demo.quick.components.PositionComponent;
import com.artemis.systems.EntitySystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.utils.Array;

public class RenderingSystem extends EntitySystem {

    ComponentMapper<PositionComponent> pm;

    OrthographicCamera camera;
    ShapeRenderer shapeRenderer;

    @SuppressWarnings("unchecked")
    public RenderingSystem(OrthographicCamera camera) {
        super(Filter.allComponents(PositionComponent.class));

        this.camera = camera;
        this.shapeRenderer = new ShapeRenderer();
        shapeRenderer.begin(ShapeType.Filled);
        shapeRenderer.setColor(1f, 1f, 1f, 1f);
    }

    @Override
    public void initialize() {
        pm = world.getMapper(PositionComponent.class);
    }

    @Override
    protected void processEntities(Array<Entity> entities) {

        // clear screen
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

        // update camera and shape renderer
        camera.update();
        shapeRenderer.setProjectionMatrix(camera.combined);
        shapeRenderer.identity();

        // render each entity
        for (Entity entity : entities) {
            PositionComponent positionComponent = pm.get(entity);
            shapeRenderer.circle(positionComponent.position.x, positionComponent.position.y, 10);
        }
    }

}