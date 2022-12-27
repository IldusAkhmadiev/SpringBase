package org.ildus.akhamdiev.beanLifeCycle;

public class Singleton {

//    {
//        System.out.println("NON STATIC INIT");
//    }
//
//    static {
//        System.out.println("STATIC INIT");
//    }
//
//    public Singleton() {
//        System.out.println("Constructor ");
//    }

    public void init() {
        System.out.println("Singleton init");
    }

    public  void destroy() {
        System.out.println("Singleton destroy");
    }
}
