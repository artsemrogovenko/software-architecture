package ru.geekbrains.lesson2.factorymethod;

public class Sample {

    private String data;

    private Sample(String data) {
        this.data = data;
    }

    public static Sample create(String data){
        if (data == null || data.length() == 0)
            throw new RuntimeException("Error data.");
        return new Sample(data);
    }

}
