package ru.geekbrains.lesson1.store3d.inmemorymodel;

public class Observer2 implements ModelChangedObserver {

    @Override
    public void applyUpdateModel(String message) {
        System.out.println("observer$2: " + message);
    }
}