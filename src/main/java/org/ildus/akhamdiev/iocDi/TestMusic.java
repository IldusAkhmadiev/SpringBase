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
        BeanEx testBean1 = context.getBean("beanEx", BeanEx.class);
        BeanEx testBean2 = context.getBean("beanEx", BeanEx.class);
        musicPlayer.playMusic();
        System.out.println("Singleton " + (musicPlayer == musicPlayer2) );
        System.out.println(testBean1);
        System.out.println(testBean2);
        context.close();

    }
}
