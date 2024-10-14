package com.juege.pattern;

/**
 * 外观模式是一种结构型设计模式，提供了一个统一的接口，用于访问子系统中的一群接口。外观定义了一个高层接口，使得子系统更容易使用。
 *
 * 结构
 * Facade（外观）：提供了一个统一的高层接口，用于访问子系统中的一群接口。
 * Subsystem（子系统）：实现子系统功能的类。
 */
// Subsystem 1
class Engine {
    public void start() {
        System.out.println("Engine started");
    }
}

// Subsystem 2
class FuelInjector {
    public void injectFuel() {
        System.out.println("Fuel injected");
    }
}

// Subsystem 3
class AirFlowController {
    public void takeAir() {
        System.out.println("Air taken");
    }
}

// Facade
class CarEngineFacade {
    private Engine engine;
    private FuelInjector fuelInjector;
    private AirFlowController airFlowController;

    public CarEngineFacade() {
        this.engine = new Engine();
        this.fuelInjector = new FuelInjector();
        this.airFlowController = new AirFlowController();
    }

    public void startEngine() {
        engine.start();
        fuelInjector.injectFuel();
        airFlowController.takeAir();
        System.out.println("Engine ready");
    }
}

// Client
public class FacadePatternExample {
    public static void main(String[] args) {
        CarEngineFacade facade = new CarEngineFacade();
        facade.startEngine();
    }
}
