package com.wang.remote.frame.io.bio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * @Author HeJiawang
 * @Date 2017/12/23 15:00
 */
public class BIOEchoClient {

    public static void main(String[] args) throws Exception{
        int port = 8082;
        String serverIP = "127.0.0.1";
        Socket socket = null;
        BufferedReader reader = null;
        BufferedWriter writer = null;

        try {
            socket = new Socket(serverIP, port);

            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            writer.write("hello, b;ock io. \n");
            writer.flush();

            String echo = reader.readLine();
            System.out.println("echo: " + echo);
        } finally {
            if( reader != null ){
                reader.close();
            }
            if( socket != null ){
                socket.close();
            }
        }
    }
}
