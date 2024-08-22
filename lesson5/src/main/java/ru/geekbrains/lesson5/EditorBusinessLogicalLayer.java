package ru.geekbrains.lesson5;

import java.util.Collection;
import java.util.Random;

public class EditorBusinessLogicalLayer implements BusinessLogicalLayer {

    private DatabaseAccess databaseAccess;

    public EditorBusinessLogicalLayer(DatabaseAccess databaseAccess){
        this.databaseAccess = databaseAccess;
    }



    @Override
    public Collection<Model3D> getAllModels() {
        return databaseAccess.getAllModels();
    }

    @Override
    public Collection<Texture> getAllTextures() {
        return databaseAccess.getAllTextures();
    }

    @Override
    public void renderModel(Model3D model) {
        processRender(model);
    }

    @Override
    public void renderAllModels() {
        for (Model3D model: getAllModels()) {
            processRender(model);
        }
    }

    @Override
    public void deleteModel(Model3D modelToDelete) {
        databaseAccess.removeEntity(modelToDelete);
    }

    @Override
    public void deleteTexture(Texture textureToDelete) {
        databaseAccess.removeEntity(textureToDelete);
    }

    @Override
    public void addTexture(Texture newTexture) {
        databaseAccess.addEntity(newTexture);
    }

    @Override
    public void addModel(Model3D newModel) {
        databaseAccess.addEntity(newModel);
    }

    private Random random = new Random();

    private void processRender(Model3D model){
        try {
            Thread.sleep(2500 - random.nextInt(2000));
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
