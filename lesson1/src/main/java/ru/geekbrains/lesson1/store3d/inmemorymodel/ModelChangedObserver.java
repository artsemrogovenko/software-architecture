package ru.geekbrains.lesson1.store3d.inmemorymodel;

public interface ModelChangedObserver {

    void applyUpdateModel(String message);
}
