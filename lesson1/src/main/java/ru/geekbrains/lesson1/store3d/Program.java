package ru.geekbrains.lesson1.store3d;

import ru.geekbrains.lesson1.store3d.inmemorymodel.ModelStore;
import ru.geekbrains.lesson1.store3d.inmemorymodel.Observer1;
import ru.geekbrains.lesson1.store3d.inmemorymodel.Observer2;
import ru.geekbrains.lesson1.store3d.modelelements.*;

import java.util.ArrayList;
import java.util.List;

public class Program {

    public static void main(String[] args) {
        ModelStore modelstore = new ModelStore();

        Observer1 observer1 = new Observer1();
        Observer2 observer2 = new Observer2();

        modelstore.registerModelChanger(observer1);
        modelstore.registerModelChanger(observer2);


        Poligon p1 = new Poligon();
        List<Poligon> poligons = new ArrayList<>();
        poligons.add(p1);

        Camera camera1 = new Camera(2,4,5);
        camera1.rotate(40,50,20);

        Flash flash1 =new Flash(421,43,12);

        PoligonalModel poligonalModel = new PoligonalModel(poligons);
        modelstore.add(poligonalModel);

        modelstore.add(new Camera());

        Scene scene1 = new Scene(List.of(poligonalModel),List.of(flash1),List.of(camera1));
        modelstore.add(scene1);

        System.out.println();
        modelstore.getScene(1);

    }

}
