package ru.geekbrains.lesson1.store3d.modelelements;

import java.util.Collection;

public class PoligonalModel extends Entity {

    public PoligonalModel(Collection<Poligon> poligons, Collection<Texture> textures) {
        this.poligons = poligons;
        this.textures = textures;
    }

    public PoligonalModel(Collection<Poligon> poligons) {
        this.poligons = poligons;
    }

    private Collection<Poligon> poligons;

    private Collection<Texture> textures;

    public Collection<Poligon> getPoligons() {
        return poligons;
    }

    public Collection<Texture> getTextures() {
        return textures;
    }

    public void setTextures(Collection<Texture> textures) {
        this.textures = textures;
    }

    @Override
    public String toString() {
        String texturesCount = textures != null ? String.valueOf(textures.size()) : "0";
        String poligonsCount = poligons != null ? String.valueOf(poligons.size()) : "0";
        return "PoligonalModel{" + super.toString() +
                " textures=" + texturesCount +
                ", poligons=" + poligonsCount +
                "}";
    }
}
