package ru.geekbrains.lesson1.store3d.inmemorymodel;

public class Observer1 implements ModelChangedObserver {

    @Override
    public void applyUpdateModel(String message) {
        System.out.println("\u001B[34mobserver$1: " + message + "\u001B[0m");
    }
}
