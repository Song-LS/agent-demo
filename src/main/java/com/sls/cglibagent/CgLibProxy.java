package com.sls.cglibagent;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author sls
 * 创建CGLib的工厂
 **/
public class CgLibProxy implements MethodInterceptor {

    private Canteen3 canteen;

    CgLibProxy(Canteen3 canteen) {
        this.canteen = canteen;
    }

    Canteen3 proxy() {
        // 创建Enhancer对象
        Enhancer enhancer = new Enhancer();
        // 设置代理的目标类
        enhancer.setSuperclass(Canteen3.class);
        // 设置回调方法， this代表当前类，因为当前类实现了CallBack
        enhancer.setCallback(this);
        return (Canteen3) enhancer.create();
    }

    //这个方法就是回调方法了
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("----------小卖部卖货前----------");
        Object invoke = method.invoke(canteen, objects);
        System.out.println("----------小卖部卖货后----------");
        return invoke;
    }
}
