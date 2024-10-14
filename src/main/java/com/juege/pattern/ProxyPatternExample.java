package com.juege.pattern;

/**
 * 代理模式为其他对象提供一种代理以控制对这个对象的访问。
 */
// 接口
interface Subject {
    void request();
}

// 真实主题
class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("RealSubject request");
    }
}

// 代理类
class Proxy implements Subject {
    private RealSubject realSubject;

    @Override
    public void request() {
        if (realSubject == null) {
            realSubject = new RealSubject();
        }
        System.out.println("Proxy request");
        realSubject.request();
    }
}

// 示例使用
public class ProxyPatternExample {
    public static void main(String[] args) {
        Proxy proxy = new Proxy();
        proxy.request();
    }
}
