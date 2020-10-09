package com.billy.games.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;
import com.billy.games.core.CanyonBunnyMain;

public class CanyonBunny {
    private static boolean rebuildAtlas = !true;
    private static boolean drawDebugOutline = true;

    public static void main(String[] arg) {
        if (rebuildAtlas) {
            TexturePacker.Settings settings = new TexturePacker.Settings();
            settings.maxWidth = 1024;
            settings.maxHeight = 1024;
            settings.duplicatePadding = false;
            settings.debug = drawDebugOutline;

            TexturePacker.process(settings,
                    "./core/src/main/resources/assets-raw/images",
                    "./core/src/main/resources/assets/images",
            "canyonbunny.pack");
        }

        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.width = 800;
        config.height = 480;
        config.title = CanyonBunny.class.getSimpleName();
        new LwjglApplication(new CanyonBunnyMain(), config);
    }
}
