package ru.geekbrains.lesson8.Views;

import ru.geekbrains.lesson8.Models.Table;
import ru.geekbrains.lesson8.Presenters.View;
import ru.geekbrains.lesson8.Presenters.ViewObserver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class BookingView implements View {

    private Collection<ViewObserver> observers = new ArrayList<>();

    @Override
    public void registerObserver(ViewObserver observer) {
        observers.add(observer);
    }

    @Override
    public void showTables(Collection<Table> tables) {
        for (Table table : tables) {
            System.out.println(table);
        }
    }

    @Override
    public void showReservationTableResult(int reservationNo) {
        if (reservationNo > 0)
            System.out.printf("Столик успешно забронирован. Номер резерва #%d\n", reservationNo);
        else
            System.out.println("Невозможно забронировать столик.\nПовторите попытку позже.");
    }

    @Override
    public void showCancelReservationTableResult(int tableNo, int status) {
        if (status > 0)
            System.out.printf("Столик #%d доступен для брони.\n", tableNo);
        else
            System.out.println("Введены некоректные данные.");
    }

    public void reservationTable(Date reservtionDate, int tableNo, String name) {
        for (ViewObserver observer : observers)
            observer.onReservationTable(reservtionDate, tableNo, name);
    }

    public void changeReservationTable(int oldReservation, Date reservtionDate, int tableNo, String name) {
        for (ViewObserver observer : observers) {
            try {
                observer.endReservationTable(oldReservation);
                reservationTable(reservtionDate, tableNo, name);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
