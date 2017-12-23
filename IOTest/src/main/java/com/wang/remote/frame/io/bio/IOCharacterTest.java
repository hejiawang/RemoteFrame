package com.wang.remote.frame.io.bio;

import java.io.*;

/**
 * java 字符流
 * @Author HeJiawang
 * @Date 2017/12/23 14:00
 */
public class IOCharacterTest {

    //Write  and  Read

    public static void bufferedAndFile() throws Exception{
        FileReader fr = new FileReader("/src.txt");
        FileWriter fw = new FileWriter("/target.txt");

        BufferedReader bufReader = new BufferedReader(fr);
        BufferedWriter bufWriter = new BufferedWriter(fw);

        String line = null;
        while ((line = bufReader.readLine()) != null){
            bufWriter.write(line);
            bufWriter.newLine();
        }
        bufWriter.flush();

        bufReader.close();
        bufWriter.close();
    }

    public static void charArray() throws Exception{
        String content = "你好，java Blocking I/O!";
        CharArrayReader charReader = new CharArrayReader(content.toCharArray());

        char[] chars = new char[1024];
        int size = 0;
        CharArrayWriter charWriter = new CharArrayWriter();
        while ( (size = charReader.read(chars)) != -1 ){
            charWriter.write(chars, 0, size);
        }

        System.out.println(charWriter.toString());

        char[] charArray = charWriter.toCharArray();
        for( char c : charArray ){
            System.out.println(c);
        }
    }

    public static void stream() throws Exception{
        FileInputStream inputStream = new FileInputStream("/src.txt");
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        FileOutputStream outputStream = new FileOutputStream("/target.txt");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

        String line = null;
        while ( (line = bufferedReader.readLine()) != null ){
            bufferedWriter.write(line);
            bufferedWriter.newLine();
        }
        bufferedWriter.flush();

        bufferedReader.close();
        bufferedWriter.close();
        inputStream.close();
        outputStream.close();
    }

    public static void print() throws Exception{
        File file = new File("/p.txt");
        PrintWriter pw = new PrintWriter(file);
        pw.format("你好， %s %s %s %s", "java", "Blocking", "I/O", "!");
        pw.flush();
        pw.close();
    }
}
