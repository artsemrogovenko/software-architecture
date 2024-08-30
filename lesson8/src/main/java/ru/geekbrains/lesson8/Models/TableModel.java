package ru.geekbrains.lesson8.Models;

import ru.geekbrains.lesson8.Presenters.Model;
import ru.geekbrains.lesson8.Models.Reservation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;
import java.util.stream.Collectors;

public class TableModel implements Model {

    private Collection<Table> tables;

    @Override
    public Collection<Table> loadTables() {
        if (tables == null){
            tables = new ArrayList<>();
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
        }
        return tables;
    }

    @Override
    public int reservationTable(Date reservationDate, int tableNo, String name) {
        for (Table table : tables){
            if (table.getNo() == tableNo){
                Reservation reservation = new Reservation(tableNo, reservationDate, name);
                table.getReservations().add(reservation);
                return reservation.getId();
            }
        }
        throw new RuntimeException("Некорректный номер столика");
    }

    @Override
    public int endReservationTable(int oldReservation) {
        for (Table table : tables){
           Optional<Reservation> current = table.getReservations().stream()
                    .filter(reservation -> reservation.getId()==oldReservation).findFirst();
            if (current.isPresent()){
                table.getReservations().remove(current.get());
                return table.getNo();
            }
        }
        throw new RuntimeException("Некорректный номер бронирования");
    }


}
