package com.wang.remote.frame.cxf;

import javax.jws.WebService;

/**
 * @Author HeJiawang
 * @Date 2017/12/13 20:55
 */
@WebService
public interface HelloService {

    String sayHello(String content);
}
