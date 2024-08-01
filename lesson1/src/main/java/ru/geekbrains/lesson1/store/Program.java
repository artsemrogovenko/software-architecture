package ru.geekbrains.lesson1.store;

import ru.geekbrains.lesson1.store.inmemorymodel.Store;
import ru.geekbrains.lesson1.store.modelelements.Buyer;
import ru.geekbrains.lesson1.store.modelelements.Order;
import ru.geekbrains.lesson1.store.modelelements.OrderItem;
import ru.geekbrains.lesson1.store.modelelements.Product;

import java.util.List;

public class Program {

    public static void main(String[] args) {
        Store store = new Store();

        Product product1 = new Product("AA1", 100);
        Product product2 = new Product("BB1", 100);

        OrderItem orderItem1 = new OrderItem(product1, 2);
        OrderItem orderItem2 = new OrderItem(product2, 3);

        Buyer buyer1 = new Buyer("Buyer1");


        Order order1 = new Order("Adress", "+797123", buyer1, List.of(orderItem1, orderItem2));
        store.addOrder(order1);
    }

}
