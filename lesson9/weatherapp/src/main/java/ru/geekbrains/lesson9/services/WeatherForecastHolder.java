package ru.geekbrains.lesson9.services;

import org.springframework.stereotype.Service;
import ru.geekbrains.lesson9.Models.WeatherForecast;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Объект на базе класса WeatherForecastHolder будет хранить список показателей по температуре
 */
@Service
public class WeatherForecastHolder {

    // Коллекция для хранения показателей по температуре
    private List<WeatherForecast> values;

    // Конструктор
    public WeatherForecastHolder() {
        values = new ArrayList<>();
    }

    /**
     * Добавить новый показатель по температуре
     *
     * @param date          Дата измерения
     * @param temperatureC  Температура в градусах Цельсия
     * @return true, если данные успешно добавлены
     */
    public boolean add(LocalDate date, int temperatureC) {
        WeatherForecast forecast = new WeatherForecast();
        forecast.setDate(date);
        forecast.setTemperatureC(temperatureC);
        values.add(forecast);
        return true;
    }

    /**
     * Обновить показатель по температуре
     *
     * @param date          Дата измерения
     * @param temperatureC  Температура в градусах Цельсия
     * @return true, если данные успешно обновлены
     */
    public boolean update(LocalDate date, int temperatureC) {
        for (WeatherForecast forecast : values) {
            if (forecast.getDate().equals(date)) {
                forecast.setTemperatureC(temperatureC);
                return true;
            }
        }
        return false;
    }

    /**
     * Получить показатели по температуре за период
     *
     * @param from  Начало периода
     * @param to    Конец периода
     * @return Список показателей по температуре за указанный период
     */
    public List<WeatherForecast> get(LocalDate from, LocalDate to) {
        List<WeatherForecast> resultList = new ArrayList<>();
        for (WeatherForecast forecast : values) {
            if (!forecast.getDate().isBefore(from) && !forecast.getDate().isAfter(to)) {
                resultList.add(forecast);
            }
        }
        return resultList;
    }

    /**
     * Удалить показатели по дате
     * @param date Дата
     * @return boolean
     */
    public boolean delete(LocalDate date) {
        for (WeatherForecast forecast : values) {
            if (forecast.getDate()==date) {
                values.remove(forecast);
                return true;
            }
        }
        return false;
    }
}