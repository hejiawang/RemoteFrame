package com.wang.remote.frame.cxf;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author HeJiawang
 * @Date 2017/12/13 21:03
 */
public class CxfClient {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:cxf-client.xml");
        HelloService client = (HelloService) context.getBean("helloClient");

        System.out.println(client.sayHello("张三"));
    }
}
