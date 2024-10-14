package com.juege.pattern;

/**
 * 抽象工厂模式提供一个接口，用于创建一系列相关或依赖对象，而不指定它们具体的类。
 */

// 抽象产品A
interface AbstractProductA {
    void operationA();
}

// 抽象产品B
interface AbstractProductB {
    void operationB();
}

// 具体产品A1
class ConcreteProductA1 implements AbstractProductA {
    @Override
    public void operationA() {
        System.out.println("Operation A1");
    }
}

// 具体产品B1
class ConcreteProductB1 implements AbstractProductB {
    @Override
    public void operationB() {
        System.out.println("Operation B1");
    }
}

// 具体产品A2
class ConcreteProductA2 implements AbstractProductA {
    @Override
    public void operationA() {
        System.out.println("Operation A2");
    }
}

// 具体产品B2
class ConcreteProductB2 implements AbstractProductB {
    @Override
    public void operationB() {
        System.out.println("Operation B2");
    }
}

// 抽象工厂
interface AbstractFactory {
    AbstractProductA createProductA();
    AbstractProductB createProductB();
}

// 具体工厂1
class ConcreteFactory1 implements AbstractFactory {
    @Override
    public AbstractProductA createProductA() {
        return new ConcreteProductA1();
    }

    @Override
    public AbstractProductB createProductB() {
        return new ConcreteProductB1();
    }
}

// 具体工厂2
class ConcreteFactory2 implements AbstractFactory {
    @Override
    public AbstractProductA createProductA() {
        return new ConcreteProductA2();
    }

    @Override
    public AbstractProductB createProductB() {
        return new ConcreteProductB2();
    }
}

// 示例使用
public class AbstractFactoryPatternExample {
    public static void main(String[] args) {
        AbstractFactory factory1 = new ConcreteFactory1();
        AbstractProductA productA1 = factory1.createProductA();
        AbstractProductB productB1 = factory1.createProductB();
        productA1.operationA();
        productB1.operationB();

        AbstractFactory factory2 = new ConcreteFactory2();
        AbstractProductA productA2 = factory2.createProductA();
        AbstractProductB productB2 = factory2.createProductB();
        productA2.operationA();
        productB2.operationB();
    }
}
