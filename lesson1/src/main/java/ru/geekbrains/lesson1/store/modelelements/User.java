package ru.geekbrains.lesson1.store.modelelements;

import lombok.AccessLevel;
import lombok.Setter;

public abstract class User {
    private static int counter = 1000;

    public int getId() {
        return id;
    }
    protected int id;

    {
        id = ++counter;
    }
}
