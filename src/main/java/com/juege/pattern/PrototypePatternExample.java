package com.juege.pattern;

/**
 * 原型模式是一种创建型设计模式，允许对象通过克隆自身来创建新的实例。原型模式使用了原型实例指定要创建对象的类型，并且通过复制这个原型来创建新的对象。
 *
 * 结构
 * Prototype（原型）：声明一个克隆自身的接口。
 * Concrete Prototype（具体原型）：实现克隆方法以生成新的实例。
 */
// Prototype
interface Prototype {
    Prototype clone();
}

// Concrete Prototype
class ConcretePrototype implements Prototype {
    private String property;

    public ConcretePrototype(String property) {
        this.property = property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getProperty() {
        return property;
    }

    @Override
    public Prototype clone() {
        return new ConcretePrototype(property);
    }
}

// Client
public class PrototypePatternExample {
    public static void main(String[] args) {
        // Create prototype instance
        ConcretePrototype prototype = new ConcretePrototype("Prototype");

        // Clone prototype
        ConcretePrototype clone = (ConcretePrototype) prototype.clone();

        // Modify clone
        clone.setProperty("Clone");

        // Verify properties
        System.out.println("Prototype property: " + prototype.getProperty());
        System.out.println("Clone property: " + clone.getProperty());
    }
}
