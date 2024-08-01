package ru.geekbrains.lesson1.store.inmemorymodel;

import ru.geekbrains.lesson1.store.modelelements.Order;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Store {

    private List<Order> orders = new ArrayList<>();

    public boolean addOrder(Order order) {
        orders.add(order);
        return true;
    }

    public boolean cancelOrder(int id) {
        orders.removeIf(order -> order.getId() == id);
        return true;
    }

    public boolean paymentOrder(int id) {
        for (Order order : orders) {
            if (order.getId() == id) {
                order.setOrderDate(LocalDateTime.now());
                return true;
            }
        }

        return true;
    }

}
