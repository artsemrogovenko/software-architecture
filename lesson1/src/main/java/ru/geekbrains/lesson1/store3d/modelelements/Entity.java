package ru.geekbrains.lesson1.store3d.modelelements;

public class Entity {
    private static int counter = 0;
    protected int id = 0;

    {
        id = ++counter;
    }

    protected int posX, posY, posZ;
    protected int angleX, angleY, angleZ;

    public void rotate(int angleX, int angleY, int angleZ) {
        this.angleX = angleX;
        this.angleY = angleY;
        this.angleZ = angleZ;
    }

    public void move(int posX, int posY, int posZ) {
        this.posX = posX;
        this.posY = posY;
        this.posZ = posZ;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ",\u001B[35m posX=" + posX +
                ", posY=" + posY +
                ", posZ=" + posZ +
                "\u001B[0m,\u001B[36m angleX=" + angleX +
                ", angleY=" + angleY +
                ", angleZ=" + angleZ +"\u001B[0m";
    }
}
