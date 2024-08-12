package ru.geekbrains.lesson3;

public class CarWashStation implements Wiping {
    private Car currentCar; // Поле для хранения текущего автомобиля

    public void setCurrentCar(Car car) {
        this.currentCar = car; // Установка текущего автомобиля
    }

    public void processWashing() {
        System.out.println(currentCar.info() + " Вымыта от грязи");
    }

    @Override
    public void wipMirrors() {
        System.out.println(currentCar.info() + " Зеркала протерты");
    }

    @Override
    public void wipWindshield() {
        System.out.println(currentCar.info() + " Протирка лобового стекла");
    }

    @Override
    public void wipHeadlights() {
        System.out.println(currentCar.info() + " Фары протерты");
    }
}
