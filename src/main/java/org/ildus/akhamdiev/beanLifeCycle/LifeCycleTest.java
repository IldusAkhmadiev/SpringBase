package org.ildus.akhamdiev.beanLifeCycle;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LifeCycleTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Singleton single1 = context.getBean("single", Singleton.class);
        Prototype prototype1 = context.getBean("prototype",Prototype.class);
        Singleton single2 = context.getBean("single", Singleton.class);
        Prototype prototype2 = context.getBean("prototype",Prototype.class);
        context.close();
    }
}
