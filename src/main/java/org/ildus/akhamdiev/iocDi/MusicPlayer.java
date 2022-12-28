package org.ildus.akhamdiev.iocDi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.Random;


public class MusicPlayer {
    @Autowired
    @Qualifier("musicList")
    private List<Music> music;


    public MusicPlayer() {
        System.out.println("default Music player");
    }

    public MusicPlayer(List<Music> music) {
        this.music = music;
    }

    public List<Music> getMusic() {
        return music;
    }

    public void setMusic(List<Music> music) {
        this.music = music;
    }

    public void playMusic() {
        Random random = new Random();
        int i = random.nextInt(music.size());
        System.out.println(music.get(i).getSong());
    }
}
