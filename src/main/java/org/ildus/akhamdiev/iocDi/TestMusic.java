package org.ildus.akhamdiev.iocDi;

import org.ildus.akhamdiev.base_core.BeanEx;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMusic {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        MusicPlayer musicPlayer = context.getBean("musicPlayer2",MusicPlayer.class);
        MusicPlayer musicPlayer2 = context.getBean("musicPlayer2",MusicPlayer.class);
        BeanEx testBean1 = context.getBean("testBean", BeanEx.class);
        BeanEx testBean2 = context.getBean("testBean", BeanEx.class);
        musicPlayer.playMusic();
        System.out.println("Singleton " + (musicPlayer == musicPlayer2) );
        System.out.println(testBean1);
        System.out.println(testBean2);
        context.close();

    }
}
