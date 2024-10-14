package com.juege.pattern;

/**
 * 单例模式（Singleton Pattern）
 * 目标
 * 单例模式的主要目标是确保一个类只有一个实例，并提供一个全局访问点。
 *
 * 核心思想
 * 单例模式通过控制实例的创建过程，保证一个类在内存中只有一个实例。通常通过私有构造函数和一个静态方法来实现这一点。
 *
 * 使用场景
 * 单例模式适用于以下场景：
 *
 * 当需要确保一个类只有一个实例时，比如日志记录器、配置管理器、数据库连接池等。
 * 当需要提供一个全局访问点时。
 */
class Singleton {
    private static Singleton instance;

    private Singleton() {
        // private constructor to prevent instantiation
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello, Singleton!");
    }
}

public class SingletonPatternExample {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        singleton.showMessage();
    }
}
