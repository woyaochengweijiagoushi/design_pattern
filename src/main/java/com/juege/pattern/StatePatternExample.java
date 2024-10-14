package com.juege.pattern;

/**
 * 状态模式允许对象在内部状态改变时改变其行为，对象看起来好像修改了其类。
 *
 */
// 状态接口
interface State {
    void handle(Contextt context);
}

// 具体状态A
class ConcreteStateA implements State {
    @Override
    public void handle(Contextt context) {
        System.out.println("State A handling. Switching to State B.");
        context.setState(new ConcreteStateB());
    }
}

// 具体状态B
class ConcreteStateB implements State {
    @Override
    public void handle(Contextt context) {
        System.out.println("State B handling. Switching to State A.");
        context.setState(new ConcreteStateA());
    }
}

// 上下文
class Contextt {
    private State state;

    public Contextt(State state) {
        this.state = state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void request() {
        state.handle(this);
    }
}

// 示例使用
public class StatePatternExample {
    public static void main(String[] args) {
        Contextt context = new Contextt(new ConcreteStateA());
        context.request();
        context.request();
        context.request();
    }
}
