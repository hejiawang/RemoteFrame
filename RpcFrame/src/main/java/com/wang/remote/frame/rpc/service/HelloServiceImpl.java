package com.wang.remote.frame.rpc.service;

/**
 * 远程服务接口实现
 * @Author HeJiawang
 * @Date 2017/12/14 21:33
 */
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String content) {
        return "Hello, " + content;
    }
}
