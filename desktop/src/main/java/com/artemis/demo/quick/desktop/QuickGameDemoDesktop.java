package com.artemis.demo.quick.desktop;

import com.artemis.demo.quick.QuickGameDemo;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class QuickGameDemoDesktop {
    public static void main (String[] args) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.width = QuickGameDemo.GAME_WIDTH;
        config.height = QuickGameDemo.GAME_HEIGHT;
        config.useGL20 = false;
        new LwjglApplication(new QuickGameDemo(), config);
    }
}
