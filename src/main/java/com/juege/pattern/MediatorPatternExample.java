package com.juege.pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 中介者模式定义一个中介对象来封装一系列对象交互。中介者使各对象不需要
 * 显式地相互引用，从而使其耦合松散，并可以独立地改变它们之间的交互。
 */
// 中介者接口
interface Mediator {
    void sendMessage(String message, Colleague colleague);
}

// 具体中介者
class ConcreteMediator implements Mediator {
    private List<Colleague> colleagues = new ArrayList<>();

    public void addColleague(Colleague colleague) {
        colleagues.add(colleague);
    }

    @Override
    public void sendMessage(String message, Colleague sender) {
        for (Colleague colleague : colleagues) {
            if (colleague != sender) {
                colleague.receiveMessage(message);
            }
        }
    }
}

// 同事类
abstract class Colleague {
    protected Mediator mediator;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }

    public abstract void sendMessage(String message);
    public abstract void receiveMessage(String message);
}

// 具体同事类A
class ConcreteColleagueA extends Colleague {
    public ConcreteColleagueA(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void sendMessage(String message) {
        System.out.println("ColleagueA sends: " + message);
        mediator.sendMessage(message, this);
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println("ColleagueA receives: " + message);
    }
}

// 具体同事类B
class ConcreteColleagueB extends Colleague {
    public ConcreteColleagueB(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void sendMessage(String message) {
        System.out.println("ColleagueB sends: " + message);
        mediator.sendMessage(message, this);
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println("ColleagueB receives: " + message);
    }
}

// 示例使用
public class MediatorPatternExample {
    public static void main(String[] args) {
        ConcreteMediator mediator = new ConcreteMediator();

        Colleague colleagueA = new ConcreteColleagueA(mediator);
        Colleague colleagueB = new ConcreteColleagueB(mediator);

        mediator.addColleague(colleagueA);
        mediator.addColleague(colleagueB);

        colleagueA.sendMessage("Hello from A");
        colleagueB.sendMessage("Hello from B");
    }
}
