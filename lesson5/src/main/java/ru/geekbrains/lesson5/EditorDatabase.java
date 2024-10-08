package ru.geekbrains.lesson5;

import java.util.*;

public class EditorDatabase implements Database {

    private Random random = new Random();
    private final ProjectFile projectFile;
    private Collection<Entity> entities;
    public EditorDatabase(ProjectFile projectFile){
        this.projectFile = projectFile;
        load();
    }

    @Override
    public void load() {
        // Загрузка всех сущностей проекта (модели, текстуры)
    }

    @Override
    public void save() {
        // Сохранение текущего состояния всех сущностей проекта
    }

    @Override
    public Collection<Entity> getAll() {
        // Ленивая загрузка
        if (entities == null){
            entities = new ArrayList<>();
            int modelsCount = 10 - random.nextInt(6); // 5 - 10
            for (int i = 0; i < modelsCount; i++)
                generateModelAndTextures();
        }

        return entities;
    }

    private void generateModelAndTextures(){
        Model3D model = new Model3D();
        int textureCount = random.nextInt(3);
        for (int i = 0; i < textureCount; i++){
            Texture texture = generateTexture();
            model.getTextures().add(texture);
            entities.add(texture);
        }
        entities.add(model);
    }

    private Texture generateTexture(){
        return new Texture();
    }

}
