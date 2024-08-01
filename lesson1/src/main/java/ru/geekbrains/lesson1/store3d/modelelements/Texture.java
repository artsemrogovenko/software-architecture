package ru.geekbrains.lesson1.store3d.modelelements;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Texture {

    public Texture(String name) {
        this.name = name;
    }

    private static int counter = 0;
    @Setter(AccessLevel.NONE)
    private String id;

    {
        id = String.format("\"Texture.\"%d",++counter);
    }

    private String name;
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Texture{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
