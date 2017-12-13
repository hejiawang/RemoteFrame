package com.wang.remote.frame.rmi;

import java.rmi.Naming;

/**
 * 客户端远程调用RMI服务代码
 * @Author HeJiawang
 * @Date 2017/12/13 19:42
 */
public class ClientMain {

    public static void main(String[] args) throws Exception {
        //服务引用
        HelloService helloService = (HelloService) Naming.lookup("rmi://localhost:8802/helloService");
        System.out.println("RMI 服务器返回的结果是:" + helloService.sayHello("张ss"));
    }
}
