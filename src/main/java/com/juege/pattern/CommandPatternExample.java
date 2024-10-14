package com.juege.pattern;

/**
 * 命令模式将请求封装成对象，从而使得可以用不同的请求对客户进行参数化、
 * 对请求排队或记录请求日志，以及支持可撤销的操作。
 */

// 命令接口
interface Command {
    void execute();
}

// 具体命令
class ConcreteCommand implements Command {
    private Receiver receiver;

    public ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.action();
    }
}

// 接收者
class Receiver {
    public void action() {
        System.out.println("Receiver action");
    }
}

// 调用者
class Invoker {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void executeCommand() {
        command.execute();
    }
}

// 示例使用
public class CommandPatternExample {
    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        Command command = new ConcreteCommand(receiver);
        Invoker invoker = new Invoker();
        invoker.setCommand(command);
        invoker.executeCommand();
    }
}
