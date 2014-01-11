package com.artemis.demo.events.desktop;

import com.artemis.demo.events.EventGameDemo;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class EventGameDemoDesktop {
    public static void main (String[] args) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.width = EventGameDemo.GAME_WIDTH;
        config.height = EventGameDemo.GAME_HEIGHT;
        config.useGL20 = false;
        new LwjglApplication(new EventGameDemo(), config);
    }
}
