package ru.geekbrains.lesson3;

import java.awt.*;

public abstract class Car {

    private Refueling refueling;
    private CarWashStation carWashStation;

    public void setRefuelingStation(Refueling refuelingStation) {
        this.refueling = refuelingStation;
    }

    /**
     * Помыть или протереть
     */
    public void setCarWashStation(CarWashStation carWashStation) {
        this.carWashStation = carWashStation;
        carWashStation.setCurrentCar(this);
    }


    /**
     * Заправить автомобиль
     */
    public void fuel() {
        if (refueling != null) {
            refueling.fuel(fuelType);
        }
    }

    protected void setWheelsCount(int wheelsCount) {
        this.wheelsCount = wheelsCount;
    }

    public int getWheelsCount() {
        return wheelsCount;
    }

    // Движение
    public abstract void movement();
    // Обслуживание
    public abstract void maintenance();
    // Переключение передач
    public abstract boolean gearShifting();

    // Включение фар
    public abstract boolean switchHeadlights();
    // Включение дворников
    public abstract boolean switchWipers();

    //region Конструкторы

    public Car(String make, String model, Color color) {
        this.make = make;
        this.model = model;
        this.color = color;
    }

    //endregion

    //region Поля

    // Марка автомобиля
    private String make;

    // Модель
    private String model;

    // Цвет
    private Color color;

    // Тип
    protected CarType type;

    // Число колес
    private int wheelsCount;

    // Тип топлива
    protected FuelType fuelType = FuelType.Diesel;

    // Тип коробки передач
    private GearboxType gearboxType;

    // Объем двигателя
    private double engineCapacity;

    // Состояние противотуманных фар
    private boolean fogLights = false;

    //endregion

    public String info() {
        return String.format("%s %s %s", make, model, color);
    }

}
