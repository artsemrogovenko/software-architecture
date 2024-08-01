package ru.geekbrains.lesson1.store.modelelements;

public class OrderItem {

    public OrderItem(Product product) {
        this.product = product;
    }

    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    {
        id = ++counter;
    }

    private static int counter = 0;
    private  int id;
    private Product product;
    private int quantity = 1;

    public int getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }



}
