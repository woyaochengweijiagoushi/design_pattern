package com.juege.pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 备忘录模式在不破坏封装性的前提下，捕获并保存一个对象的内部状态，
 * 以便该对象以后恢复到保存的状态。
 */
// 备忘录
class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

// 发起人
class Originator {
    private String state;

    public void setState(String state) {
        this.state = state;
        System.out.println("State set to: " + state);
    }

    public Memento saveStateToMemento() {
        return new Memento(state);
    }

    public void getStateFromMemento(Memento memento) {
        state = memento.getState();
        System.out.println("State restored to: " + state);
    }
}

// 管理者
class Caretaker {
    private List<Memento> mementoList = new ArrayList<>();

    public void add(Memento state) {
        mementoList.add(state);
    }

    public Memento get(int index) {
        return mementoList.get(index);
    }
}

// 示例使用
public class MementoPatternExample {
    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();

        originator.setState("State 1");
        originator.setState("State 2");
        caretaker.add(originator.saveStateToMemento());

        originator.setState("State 3");
        caretaker.add(originator.saveStateToMemento());

        originator.setState("State 4");

        originator.getStateFromMemento(caretaker.get(0));
        originator.getStateFromMemento(caretaker.get(1));
    }
}
