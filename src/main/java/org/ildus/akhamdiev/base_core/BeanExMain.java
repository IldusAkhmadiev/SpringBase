package org.ildus.akhamdiev.base_core;

import org.ildus.akhamdiev.config.SpringConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanExMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        BeanEx bean = context.getBean(BeanEx.class);
        System.out.println(bean);
        System.out.println(bean.getName());
        context.close();
    }
}
