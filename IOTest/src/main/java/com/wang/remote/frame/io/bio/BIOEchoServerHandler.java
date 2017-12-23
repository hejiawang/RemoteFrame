package com.wang.remote.frame.io.bio;

import java.io.*;
import java.net.Socket;

/**
 * @Author HeJiawang
 * @Date 2017/12/23 15:59
 */
public class BIOEchoServerHandler implements Runnable {

    private Socket socket;

    public BIOEchoServerHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        BufferedReader reader = null;
        BufferedWriter writer = null;
        try{
             reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

             while (true){
                 String line = reader.readLine();
                 if( line == null ){
                     break;
                 }

                 writer.write(line + "\n");
                 writer.flush();
             }
        } catch (Exception e){
            if( reader != null ){
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (this.socket != null){
                try {
                    this.socket.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
}
