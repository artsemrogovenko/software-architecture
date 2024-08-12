package ru.geekbrains.lesson3;

import java.awt.*;

public class Program {

    /**
     * 1. Спроектировать абстрактный класс «Car» у которого должны
     * быть свойства: марка, модель, цвет, тип кузова, число колёс, тип
     * топлива, тип коробки передач, объём двигателя; методы:
     * движение, обслуживание, переключение передач, включение
     * фар, включение дворников.
     * <p>
     * 2. Создать конкретный автомобиль путём наследования класса
     * «Car».
     * <p>
     * 3. Расширить абстрактный класс «Car», добавить метод: подметать
     * улицу. Создать конкретный автомобиль путём наследования
     * класса «Car». Провести проверку принципа SRP.
     * <p>
     * 4. Расширить абстрактный класс «Car», добавить метод:
     * включение противотуманных фар, перевозка груза. Провести
     * проверку принципа OCP.
     * <p>
     * 5. Создать конкретный автомобиль путём наследования класса
     * «Car», определить число колёс = 3. Провести проверку принципа LSP.
     * <p>
     * 6. Создать конкретный автомобиль путём наследования класса
     * «Car», определить метод «движение» - «полёт». Провести
     * проверку принципа LSP.
     * <p>
     * 7. Создать интерфейс «Заправочная станция», создать метод:
     * заправка топливом.
     * <p>
     * 8. Имплементировать метод интерфейса «Заправочная станция» в
     * конкретный класс «Car».
     * <p>
     * 9. Добавить в интерфейс «Заправочная станция» методы: протирка
     * лобового стекла, протирка фар, протирка зеркал.
     * <p>
     * 10. Имплементировать все методы интерфейса «Заправочная
     * станция» в конкретный класс «Car». Провести проверку
     * принципа ISP. Создать дополнительный/е интерфейсы и
     * имплементировать их в конкретный класс «Car». Провести
     * проверку принципа ISP.
     * <p>
     * 11. Создать путём наследования класса «Car» два
     * автомобиля: с бензиновым и дизельным двигателями,
     * имплементировать метод «Заправка топливом» интерфейса
     * «Заправочная станция». Реализовать заправку каждого
     * автомобиля подходящим топливом. Провести проверку принципа DIP.
     * <p>
     * TODO: Домашнее задание:
     * Доработать приложение, спроектированное на семинаре. Добавить тип, описывающий "автомойку".
     * Продемонстрировать работу получившейся программы,
     * создать несколько типов автомобилей,
     * загнать каждый автомобиль на заправку, а затем и на автомойку.
     *
     * @param args
     */
    public static void main(String[] args) {

        RefuelingStation refuelingStation = new RefuelingStation();
        RefuelingStationV2 refuelingStation2 = new RefuelingStationV2();

        Car sportcar = new SoprtCar("Ford", "Mustang", Color.BLUE);
        Harvester harvester = new Harvester("Lamborghini", "B", Color.GREEN);

        harvester.setRefuelingStation(refuelingStation2);
        sportcar.setRefuelingStation(refuelingStation2);
        harvester.fuel();
        sportcar.fuel();

        CarWashStation carWashStation = new CarWashStation();

        System.out.println("Загоняю на мойку Ford");
        sportcar.setCarWashStation(carWashStation);
        carWashStation.processWashing();
        carWashStation.wipWindshield();
        carWashStation.wipMirrors();
        carWashStation.wipHeadlights();

        System.out.println("Загоняю на мойку Lamborghini");
        harvester.setCarWashStation(carWashStation);
        carWashStation.processWashing();
        carWashStation.wipWindshield();
        carWashStation.wipMirrors();
        carWashStation.wipHeadlights();
    }


    public static double calculateMaintenance(Car car) {
        if (car.getWheelsCount() == 6) {
            return 1500 * 6;
        } else {
            return 1000 * 4;
        }
    }

}
