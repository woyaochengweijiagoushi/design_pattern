package com.juege.pattern;

import java.util.HashMap;
import java.util.Map;


/**
 * 享元模式（Flyweight Pattern）
 * 目标
 * 享元模式的主要目标是减少内存使用和提高性能。它通过共享大量细粒度对象的相同实例来实现这一点。
 *
 * 核心思想
 * 享元模式通过将多个相似对象的公共部分抽取出来，共享同一个对象实例，从而减少内存消耗。具体实现中，享元模式会使用一个工厂来管理和返回这些共享对象。
 *
 * 使用场景
 * 享元模式适用于以下场景：
 *
 * 需要大量创建相似对象的情况。
 * 内存开销成为系统性能的瓶颈时。
 * 对象的状态可以分为内部状态和外部状态，其中内部状态可以共享。
 */
interface Flyweight {
    void operation(String externalState);
}

class ConcreteFlyweight implements Flyweight {
    private final String internalState;
    private String externalState;

    public ConcreteFlyweight(String internalState) {
        this.internalState = internalState;
    }

    @Override
    public void operation(String externalState) {
        this.externalState = externalState;
        System.out.println("Internal State: " + internalState + ", External State: " + externalState);
    }
}

class FlyweightFactory {
    private final Map<String, Flyweight> flyweights = new HashMap<>();

    public Flyweight getFlyweight(String key) {
        if (!flyweights.containsKey(key)) {
            flyweights.put(key, new ConcreteFlyweight(key));
        }
        return flyweights.get(key);
    }
}

public class FlyweightPatternExample {
    public static void main(String[] args) {
        FlyweightFactory factory = new FlyweightFactory();
        Flyweight flyweight1 = factory.getFlyweight("state1");
        Flyweight flyweight2 = factory.getFlyweight("state1");
        Flyweight flyweight3 = factory.getFlyweight("state2");

        flyweight1.operation("external1");
        flyweight2.operation("external2");
        flyweight3.operation("external3");
    }
}
