package com.juege.pattern;

/**
 * 策略模式定义了一系列算法，将每个算法封装起来，并使它们可以互换。
 */

// 策略接口
interface Strategy {
    int execute(int a, int b);
}

// 具体策略类 - 加法
class AdditionStrategy implements Strategy {
    @Override
    public int execute(int a, int b) {
        return a + b;
    }
}

// 具体策略类 - 减法
class SubtractionStrategy implements Strategy {
    @Override
    public int execute(int a, int b) {
        return a - b;
    }
}

// 上下文类
class Context {
    private Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int a, int b) {
        return strategy.execute(a, b);
    }
}

// 示例使用
public class StrategyPatternExample {
    public static void main(String[] args) {
        Context context = new Context();

        context.setStrategy(new AdditionStrategy());
        System.out.println("10 + 5 = " + context.executeStrategy(10, 5));

        context.setStrategy(new SubtractionStrategy());
        System.out.println("10 - 5 = " + context.executeStrategy(10, 5));
    }
}
