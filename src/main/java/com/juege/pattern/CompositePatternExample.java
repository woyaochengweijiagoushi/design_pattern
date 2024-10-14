package com.juege.pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合模式将对象组合成树形结构以表示“部分-整体”的层次结构。
 * 组合模式使得用户对单个对象和组合对象的使用具有一致性。
 */
// 组件接口
interface Componenttt {
    void operation();
}

// 叶子节点
class Leaf implements Componenttt {
    @Override
    public void operation() {
        System.out.println("Leaf operation");
    }
}

// 组合节点
class Composite implements Componenttt {
    private List<Componenttt> children = new ArrayList<>();

    public void add(Componenttt component) {
        children.add(component);
    }

    public void remove(Componenttt component) {
        children.remove(component);
    }

    @Override
    public void operation() {
        System.out.println("Composite operation");
        for (Componenttt child : children) {
            child.operation();
        }
    }
}

// 示例使用
public class CompositePatternExample {
    public static void main(String[] args) {
        Composite root = new Composite();
        Composite branch1 = new Composite();
        Composite branch2 = new Composite();

        Leaf leaf1 = new Leaf();
        Leaf leaf2 = new Leaf();
        Leaf leaf3 = new Leaf();

        root.add(branch1);
        root.add(branch2);
        branch1.add(leaf1);
        branch1.add(leaf2);
        branch2.add(leaf3);

        root.operation();
    }
}
