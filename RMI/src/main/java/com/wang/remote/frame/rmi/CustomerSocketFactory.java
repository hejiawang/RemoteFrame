package com.wang.remote.frame.rmi;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.server.RMISocketFactory;

/**
 * RMI穿透防火墙
 * @Author HeJiawang
 * @Date 2017/12/13 19:49
 */
public class CustomerSocketFactory extends RMISocketFactory{

    /**
     * 指定通信端口，防止被防火墙拦截
     * @param host
     * @param port
     * @return
     * @throws IOException
     */
    @Override
    public Socket createSocket(String host, int port) throws IOException {
        return new Socket(host, port);
    }

    /**
     *
     * @param port
     * @return
     * @throws IOException
     */
    @Override
    public ServerSocket createServerSocket(int port) throws IOException {
        if( port == 0 ){
            port = 8501;
        }

        System.out.println("RMI notify port:" + port);
        return new ServerSocket(port);
    }
}
