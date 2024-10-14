package com.juege.pattern;

/**
 * 模板方法模式定义一个操作中的算法的框架，而将一些步骤延迟到子类中。
 * 模板方法使得子类可以不改变一个算法的结构即可重定义该算法的某些特定步骤。
 */
// 抽象类
abstract class AbstractClass {
    // 模板方法
    public final void templateMethod() {
        primitiveOperation1();
        primitiveOperation2();
        concreteOperation();
    }

    // 基本方法，由子类实现
    protected abstract void primitiveOperation1();
    protected abstract void primitiveOperation2();

    // 具体方法
    private void concreteOperation() {
        System.out.println("Concrete operation");
    }
}

// 具体类
class ConcreteClass extends AbstractClass {
    @Override
    protected void primitiveOperation1() {
        System.out.println("ConcreteClass primitiveOperation1");
    }

    @Override
    protected void primitiveOperation2() {
        System.out.println("ConcreteClass primitiveOperation2");
    }
}

// 示例使用
public class TemplateMethodPatternExample {
    public static void main(String[] args) {
        AbstractClass abstractClass = new ConcreteClass();
        abstractClass.templateMethod();
    }
}
