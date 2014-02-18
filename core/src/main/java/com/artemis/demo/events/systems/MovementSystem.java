package com.artemis.demo.events.systems;


import com.artemis.Filter;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.demo.events.ResetPositionEvent;
import com.artemis.demo.events.EventGameDemo;
import com.artemis.demo.events.components.PositionComponent;
import com.artemis.demo.events.components.VelocityComponent;
import com.artemis.systems.EntityProcessingSystem;
import com.badlogic.gdx.math.Vector2;

public class MovementSystem extends EntityProcessingSystem {

    ComponentMapper<PositionComponent> pm;
    ComponentMapper<VelocityComponent> vm;

    @SuppressWarnings("unchecked")
    public MovementSystem() {
        super(Filter.allComponents(
                PositionComponent.class, VelocityComponent.class));
    }

    @Override
    public void initialize() {
        pm = world.getMapper(PositionComponent.class);
        vm = world.getMapper(VelocityComponent.class);
    }

    @Override
    protected void process(Entity e) {
        // Get the components from the entity using component mappers.
        PositionComponent positionComponent = pm.get(e);
        VelocityComponent velocityComponent = vm.get(e);

        Vector2 position = positionComponent.position;

        // Update the position.
        position.x += velocityComponent.velocity.x * world.getDelta();
        position.y += velocityComponent.velocity.y * world.getDelta();

        if (position.x < 0 || position.x > EventGameDemo.GAME_WIDTH ||
                position.y < 0 || position.y > EventGameDemo.GAME_HEIGHT) {
            ResetPositionEvent event = world.createEvent(ResetPositionEvent.class);
            event.bouncer = e;
            world.postEvent(this, event);
        }
    }
}
