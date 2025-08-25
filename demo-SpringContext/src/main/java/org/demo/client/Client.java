package org.demo.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;


public class Client {
    public static void main(String[] args) {
        // ClassPathXmlApplicationContext context
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        Freight freight = (Freight) context.getBean("freight");
        System.out.println("Frieght Object: " + freight);

// FileSystemXmlApplicationContext context
        /*ApplicationContext filecontext = new FileSystemXmlApplicationContext("C:/my-workspace/spring-config.xml");
        Freight freight_new = (Freight) context.getBean("freight");
        System.out.println("Frieght Object: " + freight_new);
        ((AbstractApplicationContext) context).close();*/
    }
}
