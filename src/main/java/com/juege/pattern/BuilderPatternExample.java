package com.juege.pattern;

import lombok.Builder;

/**
 * 建造者模式用于创建复杂对象的构建步骤，允许按步骤创建对象，并控制其构建过程
 */
class Person {
    private String name;
    private int age;

    // private constructor, can only get instance from builder
    private Person(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
    }

    // 静态内部类 Builder
    public static class Builder {
        private String name;
        private int age;

        private Builder() {}

        public static Builder builder() {
            return new Builder();
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        // method used to new instance
        public Builder age(int age) {
            this.age = age;
            return this;
        }
        public Person build() {
            return new Person(this);
        }
    }

    @Override
    public String toString() {
        return "Person(name=" + this.name + ", age=" + this.age + ")";
    }

}

public class BuilderPatternExample {
    public static void main(String[] args) {
        Person person = Person.Builder.builder().name("libai").age(3).build();
        System.out.println(person);
    }
}
