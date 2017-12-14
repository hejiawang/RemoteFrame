package com.wang.remote.frame.rpc.invoke;

import com.wang.remote.frame.rpc.framework.ProviderReflect;
import com.wang.remote.frame.rpc.service.HelloService;
import com.wang.remote.frame.rpc.service.HelloServiceImpl;

/**
 * @Author HeJiawang
 * @Date 2017/12/14 21:55
 */
public class RpcProviderMain {

    public static void main(String[] args) throws Exception {
        HelloService service = new HelloServiceImpl();
        ProviderReflect.provider(service, 8083);
    }
}
