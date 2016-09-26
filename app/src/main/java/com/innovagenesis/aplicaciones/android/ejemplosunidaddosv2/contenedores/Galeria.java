package com.innovagenesis.aplicaciones.android.ejemplosunidaddosv2.contenedores;

/** Adapter de galeria de imagenes */

public class Galeria {

    String descImgGaleria;
    int imagenGaleria;

    public Galeria(String descImgGaleria, int imagenGaleria) {
        this.descImgGaleria = descImgGaleria;
        this.imagenGaleria = imagenGaleria;
    }

    public String getDescImgGaleria() {
        return descImgGaleria;
    }

    public void setDescImgGaleria(String descImgGaleria) {
        this.descImgGaleria = descImgGaleria;
    }

    public int getImagenGaleria() {
        return imagenGaleria;
    }

    public void setImagenGaleria(int imagenGaleria) {
        this.imagenGaleria = imagenGaleria;
    }
}
