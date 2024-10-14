package com.juege.pattern;

/**
 * 职责链模式为请求创建了一个接收者对象的链。
 * 该模式对请求的发送者和接收者进行解耦，让多个对象都有机会处理这个请求。
 * 它是一种行为设计模式， 允许将请求沿着处理者链进行发送。
 * 收到请求后， 每个处理者均可对请求进行处理， 或将其传递给链上的下个处理者。
 */

// 抽象处理者
abstract class Handler {
    protected Handler successor;

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    public abstract void handleRequest(String request);
}

// 具体处理者A
class ConcreteHandlerA extends Handler {
    @Override
    public void handleRequest(String request) {
        if (request.equals("A")) {
            System.out.println("ConcreteHandlerA handled request " + request);
        } else if (successor != null) {
            successor.handleRequest(request);
        }
    }
}

// 具体处理者B
class ConcreteHandlerB extends Handler {
    @Override
    public void handleRequest(String request) {
        if (request.equals("B")) {
            System.out.println("ConcreteHandlerB handled request " + request);
        } else if (successor != null) {
            successor.handleRequest(request);
        }
    }
}

// 示例使用
public class ChainOfResponsibilityPatternExample {
    public static void main(String[] args) {
        Handler handlerA = new ConcreteHandlerA();
        Handler handlerB = new ConcreteHandlerB();

        handlerA.setSuccessor(handlerB);

        handlerA.handleRequest("A");
        handlerA.handleRequest("B");
        handlerA.handleRequest("C");
    }
}
