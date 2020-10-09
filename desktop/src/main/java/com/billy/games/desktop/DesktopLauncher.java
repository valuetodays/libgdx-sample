package com.billy.games.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.billy.games.core.MyGdxGame;

public class DesktopLauncher {
    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
//        config.width = 800;
//        config.height = 500;
        config.title = "game v0.1";
        new LwjglApplication(new MyGdxGame(), config);
    }
}
