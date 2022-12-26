package org.ildus.akhamdiev.iocDi;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMusic {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        MusicPlayer musicPlayer = context.getBean("musicList",MusicPlayer.class);

        musicPlayer.playMusic();

        context.close();

    }
}
