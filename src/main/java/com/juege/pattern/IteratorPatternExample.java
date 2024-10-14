package com.juege.pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 迭代器模式提供一种方法顺序访问一个聚合对象中的各个元素，
 * 而又不需要暴露该对象的内部表示。
 */
// 迭代器接口
interface Iterator {
    boolean hasNext();
    Object next();
}

// 具体迭代器
class ConcreteIterator implements Iterator {
    private List<Object> items;
    private int position;

    public ConcreteIterator(List<Object> items) {
        this.items = items;
        this.position = 0;
    }

    @Override
    public boolean hasNext() {
        return position < items.size();
    }

    @Override
    public Object next() {
        if (this.hasNext()) {
            return items.get(position++);
        }
        return null;
    }
}

// 聚合接口
interface Aggregate {
    Iterator createIterator();
}

// 具体聚合
class ConcreteAggregate implements Aggregate {
    private List<Object> items = new ArrayList<>();

    public void addItem(Object item) {
        items.add(item);
    }

    @Override
    public Iterator createIterator() {
        return new ConcreteIterator(items);
    }
}

// 示例使用
public class IteratorPatternExample {
    public static void main(String[] args) {
        ConcreteAggregate aggregate = new ConcreteAggregate();
        aggregate.addItem("Item 1");
        aggregate.addItem("Item 2");
        aggregate.addItem("Item 3");

        Iterator iterator = aggregate.createIterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
