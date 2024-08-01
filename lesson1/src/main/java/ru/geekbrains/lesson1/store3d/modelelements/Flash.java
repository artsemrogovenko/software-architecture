package ru.geekbrains.lesson1.store3d.modelelements;

public class Flash extends Entity {
    public Flash(int x, int y, int z) {
        super.angleX = x;
        super.angleY = y;
        super.angleZ = z;
    }


    @Override
    public String toString() {
        return "Flash{" + super.toString() + '}';
    }
}
