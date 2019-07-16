package com.sls.cglibagent;

/**
 * @author sls
 **/
public class TestCglibProxy {

    public static void main(String[] args) {
        Canteen3 canteen3 = new Canteen3();
        Canteen3 proxy = new CgLibProxy(canteen3).proxy();
        proxy.sell();
    }
}
