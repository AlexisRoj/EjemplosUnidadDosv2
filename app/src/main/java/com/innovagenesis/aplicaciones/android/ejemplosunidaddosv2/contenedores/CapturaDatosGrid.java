package com.innovagenesis.aplicaciones.android.ejemplosunidaddosv2.contenedores;

/**
 * Captura datos para el grid del menu principal
 */

public class CapturaDatosGrid {

    private int imagenMenu;
    private String numMenu;
    private String textoMenu;
    private String descMenu;

    public CapturaDatosGrid(String descMenu, int imagenMenu, String numMenu, String textoMenu) {
        this.descMenu = descMenu;
        this.imagenMenu = imagenMenu;
        this.numMenu = numMenu;
        this.textoMenu = textoMenu;
    }

    public String getDescMenu() {
        return descMenu;
    }

    public void setDescMenu(String descMenu) {
        this.descMenu = descMenu;
    }

    public int getImagenMenu() {
        return imagenMenu;
    }

    public void setImagenMenu(int imagenMenu) {
        this.imagenMenu = imagenMenu;
    }

    public String getNumMenu() {
        return numMenu;
    }

    public void setNumMenu(String numMenu) {
        this.numMenu = numMenu;
    }

    public String getTextoMenu() {
        return textoMenu;
    }

    public void setTextoMenu(String textoMenu) {
        this.textoMenu = textoMenu;
    }

}
