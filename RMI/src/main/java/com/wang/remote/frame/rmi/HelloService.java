package com.wang.remote.frame.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 定义RMI对外服务接口
 * @Author HeJiawang
 * @Date 2017/12/13 19:28
 */
public interface HelloService extends Remote{

    String sayHello(String someOne) throws RemoteException;
}
