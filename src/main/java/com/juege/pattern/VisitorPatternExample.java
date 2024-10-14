package com.juege.pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 访问者模式（Visitor Pattern）是一种行为型设计模式，它允许你在不改变对象结构的前提下定义作用于这些对象元素的新操作。这种模式通常用于解决数据结构与数据操作分离的问题，即要对一个数据结构中的元素进行多种不同的操作，而不希望这些操作污染元素类的结构。
 *
 * 访问者模式包含以下几个角色：
 *
 * Visitor（访问者）：定义了对每个元素类所要访问的操作，它的方法签名确定了在访问元素时调用的具体操作。
 * ConcreteVisitor（具体访问者）：实现了Visitor接口，具体实现了对每个元素的操作。
 * Element（元素）：定义了一个accept方法，该方法接受一个访问者对象作为参数，将自身传递给访问者对象，以便访问者对象可以对自身进行操作。
 * ConcreteElement（具体元素）：实现了Element接口，即被访问的对象。
 * ObjectStructure（对象结构）：可以是一个容器，也可以是一个复杂的对象结构，它能够存放元素对象，并提供访问元素的接口。
 * 以下是一个访问者模式的简单示例，假设我们有两种不同类型的商品，分别是书籍和水果。我们希望实现一个访问者来计算这些商品的总价格
 */
// 访问者接口
interface Visitor {
    void visit(Book book);
    void visit(Fruit fruit);
}

// 具体访问者
class ShoppingCartVisitor implements Visitor {
    @Override
    public void visit(Book book) {
        int price = book.getPrice();
        System.out.println("Book ISBN: " + book.getIsbn() + ", Price: " + price);
    }

    @Override
    public void visit(Fruit fruit) {
        int pricePerKg = fruit.getPricePerKg();
        System.out.println("Fruit: " + fruit.getName() + ", Price: " + pricePerKg * fruit.getWeight());
    }
}

// 元素接口
interface ItemElement {
    void accept(Visitor visitor);
}

// 具体元素：书籍
class Book implements ItemElement {
    private int price;
    private String isbn;

    public Book(int price, String isbn) {
        this.price = price;
        this.isbn = isbn;
    }

    public int getPrice() {
        return price;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

// 具体元素：水果
class Fruit implements ItemElement {
    private int pricePerKg;
    private int weight;
    private String name;

    public Fruit(int pricePerKg, int weight, String name) {
        this.pricePerKg = pricePerKg;
        this.weight = weight;
        this.name = name;
    }

    public int getPricePerKg() {
        return pricePerKg;
    }

    public int getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

// 对象结构
class ShoppingCart {
    private List<ItemElement> items = new ArrayList<>();

    public void addItem(ItemElement item) {
        items.add(item);
    }

    public void removeItem(ItemElement item) {
        items.remove(item);
    }

    public int calculatePrice(Visitor visitor) {
        int sum = 0;
        for (ItemElement item : items) {
            item.accept(visitor);
        }
        return sum;
    }
}

// 示例使用
public class VisitorPatternExample {
    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addItem(new Book(100, "1234"));
        shoppingCart.addItem(new Fruit(5, 2, "Banana"));

        ShoppingCartVisitor visitor = new ShoppingCartVisitor();
        int totalPrice = shoppingCart.calculatePrice(visitor);
        System.out.println("Total price: " + totalPrice);
    }
}
