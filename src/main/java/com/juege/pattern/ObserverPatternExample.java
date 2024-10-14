package com.juege.pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者模式定义了一种一对多的依赖关系，让多个观察者对象同时监听某一个主题对象。
 */

// 主题接口
interface Subjectt {
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObservers();
}

// 具体主题
class ConcreteSubjectt implements Subjectt {
    private List<Observer> observers = new ArrayList<>();
    private String state;

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(state);
        }
    }

    public void setState(String state) {
        this.state = state;
        notifyObservers();
    }
}

// 观察者接口
interface Observer {
    void update(String state);
}

// 具体观察者
class ConcreteObserver implements Observer {
    private String name;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String state) {
        System.out.println(name + " received update: " + state);
    }
}

// 示例使用
public class ObserverPatternExample {
    public static void main(String[] args) {
        ConcreteSubjectt Subjectt = new ConcreteSubjectt();

        Observer observer1 = new ConcreteObserver("Observer 1");
        Observer observer2 = new ConcreteObserver("Observer 2");

        Subjectt.attach(observer1);
        Subjectt.attach(observer2);

        Subjectt.setState("State 1");
        Subjectt.setState("State 2");
    }
}
