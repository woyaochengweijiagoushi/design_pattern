package com.juege.pattern;

/**
 * 适配器模式将一个类的接口转换成客户希望的另一个接口。
 * 适配器模式使得原本由于接口不兼容而不能一起工作的类可以一起工作
 */
// 目标接口
interface Target {
    void request();
}

// 适配者类
class Adaptee {
    public void specificRequest() {
        System.out.println("Adaptee specific request");
    }
}

// 适配器类
class Adapter implements Target {
    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        adaptee.specificRequest();
    }
}

// 示例使用
public class AdapterPatternExample {
    public static void main(String[] args) {
        Adaptee adaptee = new Adaptee();
        Target adapter = new Adapter(adaptee);

        adapter.request();
    }
}
