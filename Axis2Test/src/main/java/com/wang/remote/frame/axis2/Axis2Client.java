package com.wang.remote.frame.axis2;

import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;
import org.apache.axis2.transport.http.HTTPConstants;

import javax.xml.namespace.QName;

/**
 * @Author HeJiawang
 * @Date 2017/12/13 21:48
 */
public class Axis2Client {

    public static void main(String[] args) {
        try {
            EndpointReference targetEPR = new EndpointReference("http://localhost:8080/services/HelloService");

            RPCServiceClient serviceClient = new RPCServiceClient();
            Options options = serviceClient.getOptions();
            options.setManageSession(true);
            options.setProperty(HTTPConstants.REUSE_HTTP_CLIENT, true);
            options.setTo(targetEPR);

            QName opQName = new QName("http://axis2.frame.remote.wang.com", "sayHello");
            //设置调用参数
            Object[] paramArgs = new Object[]{"张三"};
            //处理返回数据
            Class[] returnTypes = new Class[]{String.class};
            Object[] response = serviceClient.invokeBlocking(opQName, paramArgs, returnTypes);
            serviceClient.cleanupTransport();
            String result = (String)response[0];
            if( result == null ){
                System.out.println("HelloService didnt initialize!");
            } else {
                System.out.println(result);
            }
        } catch (AxisFault axisFault) {
            axisFault.printStackTrace();
        }

    }
}
