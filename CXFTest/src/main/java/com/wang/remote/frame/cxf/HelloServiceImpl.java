package com.wang.remote.frame.cxf;

import javax.jws.WebService;

/**
 * @Author HeJiawang
 * @Date 2017/12/13 20:55
 */
@WebService(endpointInterface = "com.wang.remote.frame.cxf.HelloService")
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String content) {
        return "Hello, " + content;
    }
}
