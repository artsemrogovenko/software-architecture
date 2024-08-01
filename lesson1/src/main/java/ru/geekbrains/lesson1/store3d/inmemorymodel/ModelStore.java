package ru.geekbrains.lesson1.store3d.inmemorymodel;

import ru.geekbrains.lesson1.store3d.modelelements.Camera;
import ru.geekbrains.lesson1.store3d.modelelements.Flash;
import ru.geekbrains.lesson1.store3d.modelelements.PoligonalModel;
import ru.geekbrains.lesson1.store3d.modelelements.Scene;

import java.util.ArrayList;
import java.util.List;

public class ModelStore implements IModelChanger {
    //TODO: Доработать в рамках домашней работы
    private List<ModelChangedObserver> changeObservers = new ArrayList<>();

    private List<PoligonalModel> models = new ArrayList<>();
    private List<Camera> cameras = new ArrayList<>();
    private List<Flash> flashes = new ArrayList<>();
    private List<Scene> scenes = new ArrayList<>();


    public void add(Object object) {
        String classname = object.getClass().getSimpleName();
        String info = object.toString();
        switch (classname) {
            case ("Camera"):
                cameras.add((Camera) object);
                break;
            case ("Flash"):
                flashes.add((Flash) object);
                break;
            case ("PoligonalModel"):
                models.add((PoligonalModel) object);
                break;
            case ("Scene"):
                scenes.add((Scene) object);
                break;
        }
        notifyChange("Добавлен " + info);
    }

    public void remove(Object object) {
        String classname = object.getClass().getSimpleName();
        String info = object.getClass().toString();
        switch (classname) {
            case ("Camera"):
                cameras.add((Camera) object);
                break;
            case ("Flash"):
                flashes.add((Flash) object);
                break;
            case ("PoligonalModel"):
                models.add((PoligonalModel) object);
                break;
            case ("Scene"):
                scenes.add((Scene) object);
                break;
        }
        notifyChange("Удален " + info);
    }

    public void getScene(int id) {
        for (Scene s : scenes) {
            if (s.getId() == id){
                System.out.println(s.toString());
                return;
            }
        }
    }

    @Override
    public void notifyChange(String message) {
        for (ModelChangedObserver observer : changeObservers) {
            observer.applyUpdateModel(message);
        }
    }

    @Override
    public void registerModelChanger(ModelChangedObserver o) {
        changeObservers.add(o);
    }

    @Override
    public void removeModelChanger(ModelChangedObserver o) {
        changeObservers.remove(o);
    }
}
