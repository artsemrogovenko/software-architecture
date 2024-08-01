package ru.geekbrains.lesson1.store.modelelements;

import lombok.AccessLevel;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class Buyer extends User {


    //region Поля
    private String gender;
    private String name;
    private String lastName;
    private String patronymic;
    private Date birthday;

    public Buyer(String name) {
        this.name=name;
    }
    //endregion

}
