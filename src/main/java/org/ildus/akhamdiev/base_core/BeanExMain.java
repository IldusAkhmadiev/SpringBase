package org.ildus.akhamdiev.base_core;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanExMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BeanEx bean = context.getBean(BeanEx.class);
        System.out.println(bean);
        System.out.println(bean.getName());
        context.close();
    }
}
