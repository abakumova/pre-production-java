package com.viktoriia_abakumova.task6.subtask3;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.Objects;

public class Product implements Serializable {

    private long id;
    private String name;
    private double price;
    private transient String color;

    public Product(long id, String name, double price, String color) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.color = color;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() throws FileNotFoundException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(""));
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id &&
                Double.compare(product.price, price) == 0 &&
                Objects.equals(name, product.name) &&
                Objects.equals(color, product.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, color);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                '}';
    }
}
