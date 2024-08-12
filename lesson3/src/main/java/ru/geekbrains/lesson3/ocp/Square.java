package ru.geekbrains.lesson3.ocp;

public class Square implements Shape{

    private int side; // Длина стороны квадрата
    public Square(int side) {
        this.side = side;
    }

    public int getSide() {
        return side;
    }

    @Override
    public double getArea() {
        return Math.pow(side, 2);
    }

}
