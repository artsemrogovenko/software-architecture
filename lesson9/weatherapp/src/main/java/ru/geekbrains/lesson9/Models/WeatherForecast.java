package ru.geekbrains.lesson9.Models;

import java.time.LocalDate;

public class WeatherForecast {

    /**
     * Дата измерения
     */
    private LocalDate date;

    /**
     * Температура в градусах Цельсия
     */
    private int temperatureC;

    /**
     * Температура в градусах Фаренгейта
     */
    public int getTemperatureF() {
        return 32 + (int) (temperatureC / 0.5556);
    }

    // Геттеры и сеттеры
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getTemperatureC() {
        return temperatureC;
    }

    public void setTemperatureC(int temperatureC) {
        this.temperatureC = temperatureC;
    }
}