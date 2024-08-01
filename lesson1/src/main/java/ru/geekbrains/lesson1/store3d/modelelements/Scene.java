package ru.geekbrains.lesson1.store3d.modelelements;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Scene {
    private static int counter = 0;

    public int getId() {
        return id;
    }

    private int id;

    {
        id = ++id;
    }

    private Collection<PoligonalModel> models = new ArrayList<>();
    private Collection<Flash> flashes = new ArrayList<>();
    private Collection<Camera> cameras = new ArrayList<>();

    public Scene(Collection<PoligonalModel> models, Collection<Flash> flashes, Collection<Camera> cameras) {
        this.models = models;
        this.flashes = flashes;
        this.cameras = cameras;
    }

    public void addModels(List<PoligonalModel> newModels) {
        for (PoligonalModel m : newModels) {
            if (this.models.equals(m)) {
                continue;
            }
            this.models.add(m);
        }

    }

    public void deleteModels(List<PoligonalModel> removeModels) {
        for (PoligonalModel m : removeModels) {
            this.models.remove(m);

        }
    }


    public void addFlashes(List<Flash> newFlash) {
        for (Flash f : newFlash) {
            if (this.flashes.equals(f)) {
                continue;
            }
            this.flashes.add(f);
        }

    }

    public void deleteFlashes(List<Flash> removeFlashes) {
        for (Flash f : removeFlashes) {
            this.flashes.remove(f);
        }
    }


    public void addCameras(List<Camera> newCamera) {
        for (Camera c : newCamera) {
            if (this.flashes.equals(c)) {
                continue;
            }
            this.cameras.add(c);
        }

    }

    public void deleteCameras(List<Camera> removeCamera) {
        for (Camera c : removeCamera) {
            this.cameras.remove(c);
        }
    }

    public String getInfo(Collection<Object> objects) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Object o : objects) {
            stringBuilder.append(o.toString());
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        String modelsInfo = (models == null) ? "0" : getInfo(Collections.singleton(models));
        String camerasInfo = (cameras == null) ? "0" : getInfo(Collections.singleton(cameras));
        String flashInfo = (flashes == null) ? "0" : getInfo(Collections.singleton(flashes));
        return String.format("Scene{models:%s, cameras:%s, flashes:%s}", modelsInfo, camerasInfo, flashInfo);
    }
}

