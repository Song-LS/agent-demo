package com.sls.dynamicagent;

import com.sls.dynamicagent.Canteen2;
import com.sls.dynamicagent.Producer2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author sls
 * 实现代理
 **/
public class Producer2Proxy {

    public static void main(String[] args) {
        Producer2 producer2 = new Canteen2();
        Producer2 producerProxy = (Producer2) Proxy.newProxyInstance(producer2.getClass().getClassLoader(),
                producer2.getClass().getInterfaces(), (proxy, method, args1) -> {
                    System.out.println("----------小卖部卖货前--------");
                    Object invoke = method.invoke(producer2,args1);
                    System.out.println("----------小卖部卖货后--------");
                    return invoke;
                });
        producerProxy.sell();
    }
}
