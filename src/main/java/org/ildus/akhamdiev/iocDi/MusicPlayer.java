package org.ildus.akhamdiev.iocDi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("musicPlayer2")
@Scope("singleton")
public class MusicPlayer {
    private Music music;
    @Value("${musicPlayer.name}")
    private String name;
    @Value("${musicPlayer.volume}")
    private int volume;

//    @Autowired
//    @Qualifier("popMusic")
    private Music music2;
//    @Autowired
//    @Qualifier("popMusic")
    private Music music3;

    public MusicPlayer() {
        System.out.println("default");
    }

    @Autowired
    public MusicPlayer(@Qualifier("popMusic") Music music2 ,@Qualifier("popMusic") Music music3) {
        this.music2 = music2;
        this.music3 = music3;
        System.out.println(music2.getSong() + " " + music3.getSong());
    }

    public Music getMusic() {
        return music;
    }

    @Autowired
    @Qualifier("popMusic")
    public void setMusic(Music music) {
        this.music = music;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public MusicPlayer(Music music) {
        this.music = music;
    }

    public void playMusic() {
        System.out.println("Playing: " + music.getSong());
        System.out.println(name + " " + volume);
    }
}
