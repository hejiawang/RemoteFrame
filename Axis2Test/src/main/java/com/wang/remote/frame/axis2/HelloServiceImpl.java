package com.wang.remote.frame.axis2;

/**
 * @Author HeJiawang
 * @Date 2017/12/13 21:32
 */
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String content) {
        return "hello, " + content;
    }
}
