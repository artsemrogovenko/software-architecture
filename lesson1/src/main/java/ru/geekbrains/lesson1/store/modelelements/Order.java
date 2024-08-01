package ru.geekbrains.lesson1.store.modelelements;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.*;

@Setter
@Getter
public class Order {


    public Order(String address, String phone, Buyer buyer, List<OrderItem> items) {
        if (buyer==null){
            throw new RuntimeException("Покупатель должен существовать");
        }
        if (items==null || items.size() == 0){
            throw new RuntimeException("Для заказа должна быть минимум одна позиция");
        }
        this.address = address;
        this.phone = phone;
        this.buyer = buyer;
        this.items = items;
    }

    {
        id = ++counter;
    }

    public int getId() {
        return id;
    }


    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private static int counter = 10000;
    private int id;
    private LocalDateTime orderDate;
    private String address;
    private String phone;
    private Buyer buyer;

    private List<OrderItem> items = new ArrayList<>();

}
