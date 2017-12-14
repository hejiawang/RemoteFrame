package com.wang.remote.frame.rpc.invoke;

import com.wang.remote.frame.rpc.framework.ConsumerProxy;
import com.wang.remote.frame.rpc.service.HelloService;

/**
 * @Author HeJiawang
 * @Date 2017/12/14 21:55
 */
public class RpcConsumerMain {

    public static void main(String[] args) throws Exception {
        HelloService service = ConsumerProxy.consume(HelloService.class, "127.0.0.1", 8083);
        for( int i=0; i<100; i++ ){
            String hello = service.sayHello("赫家旺 " + i);
            System.out.println(hello);
            Thread.sleep(1000);
        }
    }
}
