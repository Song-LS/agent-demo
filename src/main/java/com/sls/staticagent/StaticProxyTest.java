package com.sls.staticagent;

/**
 * @author sls
 **/
public class StaticProxyTest {

    public static void main(String[] args) {
        Producer producer = new Canteen();
        ProducerProxy producerProxy = new ProducerProxy(producer);
        producerProxy.sell();
    }
}
