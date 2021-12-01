package me.berniga;

public class Product {
    private final int id;
    private String name;
    private String category;
    private double price;
    private static int registered=0;

    public Product(String name,String category,double price){
        id=++registered;
        this.name=name;
        this.category=category;
        this.price=price;
    }

    public Product(Product p){
        id=++registered;
        this.name=p.name;
        this.category=p.category;
        this.price=p.price;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public String toString() {
        return
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price;
    }
}
