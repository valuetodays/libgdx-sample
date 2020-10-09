package com.billy.games.core;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;

import java.util.Map;

public class MyGdxGame extends ApplicationAdapter {
    private final String TAG = getClass().getSimpleName();

    private SpriteBatch batch;
    private Texture img;
    private OrthographicCamera camera;
    private Sprite sprite;
    private float rot;


    @Override
    public void create() {
        Gdx.app.log(TAG, "game created");

        Preferences prefs = Gdx.app.getPreferences("settings.prefs");
        Map<String, ?> stringMap = prefs.get();
        Gdx.app.log(TAG, "prefs is " + stringMap);

        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();

        camera = new OrthographicCamera(1, h/w);
        batch = new SpriteBatch();
        img = new Texture("badlogic.jpg");
        img.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        TextureRegion region = new TextureRegion(img, 0, 0, 512, 275);
        sprite = new Sprite(region);
        sprite.setSize(0.9f, 0.9f * sprite.getHeight() /
                sprite.getWidth());
        sprite.setOrigin(sprite.getWidth()/2,
                sprite.getHeight()/2);
        sprite.setPosition(-sprite.getWidth()/2, -
                sprite.getHeight()/2);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        int fps = Gdx.graphics.getFramesPerSecond();
        Gdx.app.log(TAG, "fps is " + fps);

        int width = Gdx.graphics.getWidth();
        int height = Gdx.graphics.getHeight();
        Gdx.app.log(TAG, "width/height = " + width + "/" + height);

//        Gdx.audio.newSound(Gdx.files.internal("001-System01.ogg"));

        batch.setProjectionMatrix(camera.combined);
        batch.begin();
//        batch.draw(img, 0, 0);
//        sprite.setRotation(45);
        final float degreesPerSecond = 10.0f;
        rot = (rot + Gdx.graphics.getDeltaTime() *
                degreesPerSecond) % 360;
//        sprite.setRotation(rot);
        sprite.setRotation(MathUtils.sin(rot) * 5.0f);
        sprite.draw(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        Preferences prefs = Gdx.app.getPreferences("settings.prefs");
        prefs.putLong("offset", System.currentTimeMillis());
        prefs.flush();
        Gdx.app.log(TAG, "prefs was saved.");

        batch.dispose();
        img.dispose();
    }
}
