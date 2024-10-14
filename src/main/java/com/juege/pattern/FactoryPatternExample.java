package com.juege.pattern;


/**
 * 工厂模式定义一个用于创建对象的接口，但由子类决定实例化哪个类。
 */

// 产品接口
interface Product {
    void use();
}

// 具体产品类A
class ConcreteProductA implements Product {
    @Override
    public void use() {
        System.out.println("Using Product A");
    }
}

// 具体产品类B
class ConcreteProductB implements Product {
    @Override
    public void use() {
        System.out.println("Using Product B");
    }
}

// 工厂类
class ProductFactory {
    public static Product createProduct(String type) {
        if (type.equals("A")) {
            return new ConcreteProductA();
        } else if (type.equals("B")) {
            return new ConcreteProductB();
        }
        return null;
    }
}

// 示例使用
public class FactoryPatternExample {
    public static void main(String[] args) {
        Product productA = ProductFactory.createProduct("A");
        productA.use();

        Product productB = ProductFactory.createProduct("B");
        productB.use();
    }
}
