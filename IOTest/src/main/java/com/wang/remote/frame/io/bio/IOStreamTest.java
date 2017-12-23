package com.wang.remote.frame.io.bio;

import java.io.*;
import java.nio.charset.Charset;

/**
 * java 字节流
 * @Author HeJiawang
 * @Date 2017/12/23 13:04
 */
public class IOStreamTest {

    public static void main(String[] args) throws Exception {
        IOStreamTest.byteArrayStream();
    }

    /**
     * 字节操作
     * @throws Exception
     */
    public static void byteArrayStream() throws Exception{
        String content = "你好，java Blocking I/O!";
        byte[] inputBytes = content.getBytes(Charset.forName("utf-8"));

        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputBytes);

        byte[] bytes = new byte[1024];
        int size = 0;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        while ( (size = inputStream.read(bytes)) != -1){
            outputStream.write(bytes, 0, size);
        }

        System.out.println(outputStream.toString("utf-8"));
    }

    /**
     * 常用于图片等二进制文件操作
     * @throws Exception
     */
    public static void fileStream() throws Exception{
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;

        File srcFile = new File("/src.txt");
        File targetFile = new File("/target");

        try {
            inputStream = new FileInputStream(srcFile);
            outputStream = new FileOutputStream(targetFile);

            int byt ;
            while ((byt = inputStream.read()) != -1){
                outputStream.write(byt);
            }
        } finally {
            if( inputStream != null ){
                inputStream.close();
            }
            if( outputStream != null ){
                outputStream.close();
            }
        }
    }

    /**
     * 提高IO性能
     * @throws Exception
     */
    public static void bufferedStream() throws Exception{
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;

        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;

        File srcFile = new File("/src.txt");
        File targetFile = new File("/target");

        try {
            inputStream = new FileInputStream(srcFile);
            outputStream = new FileOutputStream(targetFile);

            bufferedInputStream = new BufferedInputStream(inputStream);
            bufferedOutputStream = new BufferedOutputStream(outputStream);

            byte[] buff = new byte[1024];
            int byt;
            while ( (byt = bufferedInputStream.read(buff, 0, buff.length)) != -1 ){
                bufferedOutputStream.write(buff, 0, byt);
            }
            bufferedOutputStream.flush();
        } finally {
            if( inputStream != null ){
                inputStream.close();
            }
            if( outputStream != null ){
                outputStream.close();
            }
        }
    }

    /**
     * 常用于网络数据传输，能够对java原生类型直接写入于读取
     * @throws Exception
     */
    public static void dataStream() throws Exception{
        String fileName = "/data.txt";
        FileOutputStream fout = new FileOutputStream(fileName);
        DataOutputStream dos = new DataOutputStream(fout);

        dos.writeInt(2017);
        dos.writeUTF("你好， Java Blocking I/O !");
        dos.writeBoolean(true);

        dos.close();
        fout.close();

        FileInputStream fin = new FileInputStream(fileName);
        DataInputStream dis = new DataInputStream(fin);

        System.out.println(dis.readInt());
        System.out.println(dis.readUTF());
        System.out.println(dis.readBoolean());

        dis.close();
        fin.close();
    }

    /**
     * 常用于日志输出组件
     * @throws Exception
     */
    public static void printStream() throws Exception{
        File file = new File("/p.txt");
        PrintStream printStream = new PrintStream(file);
        printStream.println("你好， Java Blocking I/O !");
        printStream.close();
    }

    /**
     * 常用于序列化反序列化
     * @throws Exception
     */
    public static void objectStream() throws Exception{
        User user = new User();
        user.setEmail("");
        user.setName("");

        FileOutputStream fout = new FileOutputStream("/user.txt");
        ObjectOutputStream oout = new ObjectOutputStream(fout);
        oout.writeObject(user);
        oout.close();
        fout.close();

        FileInputStream fin = new FileInputStream("/user.txt");
        ObjectInputStream oin = new ObjectInputStream(fin);
        User newUser = (User) oin.readObject();
        System.out.println(newUser.getEmail());
        oin.close();
        fin.close();
    }

    static class User{
        private String email;
        private String name;

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
