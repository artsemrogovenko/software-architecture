package ru.geekbrains.lesson5;

import java.util.Collection;

public interface BusinessLogicalLayer {

    Collection<Model3D> getAllModels();
    Collection<Texture> getAllTextures();

    void renderModel(Model3D model);
    void renderAllModels();
    void addModel(Model3D newModel);
    void deleteModel(Model3D modelToDelete);
    void addTexture(Texture newTexture);
    void deleteTexture(Texture textureToDelete);

}
