package Util;

import javafx.scene.media.AudioClip;

public class RenderableHolder {
    private static final RenderableHolder instance = new RenderableHolder();

    public static AudioClip explosionSound, gunShotSound, gameSong;

    static {
        loadResorce();
    }

    public static void loadResorce() {
        gunShotSound = new AudioClip(ClassLoader.getSystemResource("mixkit-game-gun-shot-1662.mp3").toString());
        explosionSound = new AudioClip(
                ClassLoader.getSystemResource("mixkit-arcade-game-explosion-2759.wav").toString());
        
    }

    public static RenderableHolder getInstance() {
        return instance;
    }
}