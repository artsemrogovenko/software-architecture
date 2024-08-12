package ru.geekbrains.lesson3.lsp;

import java.util.ArrayList;
import java.util.List;

public class Program {

    // Тип S будет подтипом Т тогда и только тогда,
    // когда каждому объекту oS типа S соответствует некий объект oT типа T таким образом,
    // что для всех программ P,
    // реализованных в терминах T, поведение P не будет меняться, если oT заменить на oS.

    public static void main(String[] args) {

        Bird bird1 = new Bird(); // oT
        Bird bird2 = new Bird(); // oT
        Bird bird3 = new Bird(); // oT
        Duck duck = new Duck();  // oS
        Penguin pinguin = new Penguin();

        List<Bird> listBirds = new ArrayList<>();
        listBirds.add(bird1);
        listBirds.add(bird2);
        listBirds.add(bird3);
        listBirds.add(duck);
        listBirds.add(pinguin);

        processFly(listBirds);
    }

    /**
     * P
     * @param birds
     */
    public static void processFly(List<Bird> birds) {
        for (Bird bird: birds) {
            if (bird.isCanFly())
                bird.fly();
        }
    }
}