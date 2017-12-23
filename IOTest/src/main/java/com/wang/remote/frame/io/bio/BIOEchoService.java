package com.wang.remote.frame.io.bio;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author HeJiawang
 * @Date 2017/12/23 15:43
 */
public class BIOEchoService {

    private static final ExecutorService executor = Executors.newCachedThreadPool();

    public static void main(String[] args) throws Exception {

        int port = 8082;
        ServerSocket serverSocket = null;
        try{
            serverSocket = new ServerSocket(port);
            Socket socket = null;
            while (true){
                socket = serverSocket.accept();
                executor.submit(new BIOEchoServerHandler(socket));
            }
        } finally {
            if(serverSocket != null) serverSocket.close();
        }
    }
}
