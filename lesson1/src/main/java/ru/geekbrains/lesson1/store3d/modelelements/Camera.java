package ru.geekbrains.lesson1.store3d.modelelements;

public class Camera extends Entity {
    public Camera() {
    }

    public Camera(int x, int y, int z) {
        super.posX = x;
        super.posY = y;
        super.posZ = z;
    }

    @Override
    public String toString() {
        return "Camera{" + super.toString() + '}';
    }
}
