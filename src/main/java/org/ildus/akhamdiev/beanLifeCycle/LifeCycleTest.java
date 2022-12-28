package org.ildus.akhamdiev.beanLifeCycle;

import org.ildus.akhamdiev.config.SpringConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LifeCycleTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        Singleton single1 = context.getBean("singleton", Singleton.class);
        Prototype prototype1 = context.getBean("prototype",Prototype.class);
        Singleton single2 = context.getBean("singleton", Singleton.class);
        Prototype prototype2 = context.getBean("prototype",Prototype.class);
        context.close();
    }
}
