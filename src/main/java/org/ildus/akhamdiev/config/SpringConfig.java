package org.ildus.akhamdiev.config;

import org.ildus.akhamdiev.base_core.BeanEx;
import org.ildus.akhamdiev.beanLifeCycle.Prototype;
import org.ildus.akhamdiev.beanLifeCycle.Singleton;
import org.ildus.akhamdiev.iocDi.*;
import org.springframework.context.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
       return new MusicPlayer();
    }

    @Bean
    public List<Music> musicList() {
        return Arrays.asList(rockMusic());
    }
}
