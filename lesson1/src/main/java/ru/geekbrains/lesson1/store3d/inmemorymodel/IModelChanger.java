package ru.geekbrains.lesson1.store3d.inmemorymodel;

public interface IModelChanger {
    /**
     * Сообщает о изменении в modelstore
     */
    void notifyChange(String message);

    void registerModelChanger(ModelChangedObserver o);

    void removeModelChanger(ModelChangedObserver o);

}
