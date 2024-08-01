package ru.geekbrains.lesson1.store3d.modelelements;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Point3D {

    public Point3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Point3D() {
    }

    private double x, y, z;

}
