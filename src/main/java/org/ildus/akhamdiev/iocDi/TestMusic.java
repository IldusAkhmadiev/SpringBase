package org.ildus.akhamdiev.iocDi;

import org.ildus.akhamdiev.base_core.BeanEx;
import org.ildus.akhamdiev.config.SpringConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMusic {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        MusicPlayer musicPlayer = context.getBean("musicPlayer2",MusicPlayer.class);
        MusicPlayer musicPlayer2 = context.getBean("musicPlayer2",MusicPlayer.class);
        MusicPlayer musicPlayer3 = context.getBean("musicPlayer2",MusicPlayer.class);
        musicPlayer.playMusic();
        musicPlayer2.playMusic();
        musicPlayer3.playMusic();
        context.close();

    }
}
