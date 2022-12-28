package org.ildus.akhamdiev.config;

import org.ildus.akhamdiev.base_core.BeanEx;
import org.ildus.akhamdiev.beanLifeCycle.Prototype;
import org.ildus.akhamdiev.beanLifeCycle.Singleton;
import org.ildus.akhamdiev.iocDi.ClassicalMusic;
import org.ildus.akhamdiev.iocDi.MusicPlayer;
import org.ildus.akhamdiev.iocDi.PopMusic;
import org.ildus.akhamdiev.iocDi.RockMusic;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("org.ildus.akhamdiev")
@PropertySource("classpath:musicPlayer.properties")
public class SpringConfig {
    // also work @Component
    @Bean
    public BeanEx beanEx() {
        return new BeanEx();
    }

    @Bean
    @Scope("prototype")
    public Prototype prototype() {
        return new Prototype();
    }

    @Bean
    public Singleton singleton() {
        return new Singleton();
    }

    @Bean
    public ClassicalMusic classicalMusic() {
        return new ClassicalMusic();
    }

    @Bean
    public PopMusic popMusic() {
        return new PopMusic();
    }

    @Bean
    public RockMusic rockMusic() {
        return new RockMusic();
    }

    @Bean(name = "musicPlayer2")
    public MusicPlayer musicPlayer() {
        MusicPlayer musicPlayer = new MusicPlayer(popMusic(), rockMusic());
        musicPlayer.setMusic(classicalMusic());
        return musicPlayer;
    }
}
