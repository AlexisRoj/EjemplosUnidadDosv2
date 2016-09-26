package com.innovagenesis.aplicaciones.android.ejemplosunidaddosv2.contenedores;

/** Adapter de galeria de imagenes */

public class Galeria {

    private String descImgGaleria;
    private int imagenGaleria;
    private int imgFrameG;

    public Galeria(String descImgGaleria, int imagenGaleria, int imgFrameG) {
        this.descImgGaleria = descImgGaleria;
        this.imagenGaleria = imagenGaleria;
        this.imgFrameG = imgFrameG;
    }

    public int getImgFrameG() {
        return imgFrameG;
    }

    public void setImgFrameG(int imgFrameG) {
        this.imgFrameG = imgFrameG;
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
