package com.wang.remote.frame.rmi;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.RMISocketFactory;

/**
 * 服务端RMI服务启动代码
 * @Author HeJiawang
 * @Date 2017/12/13 19:36
 */
public class ServerMain {

    public static void main(String[] args) throws Exception{
        LocateRegistry.createRegistry(8802);//注册服务
        RMISocketFactory.setSocketFactory( new CustomerSocketFactory());
        HelloService helloService = new HelloServiceImpl();
        Naming.bind("rmi://localhost:8802/helloService", helloService);
        System.out.println("ServerMain provide RPC service now");
    }
}
