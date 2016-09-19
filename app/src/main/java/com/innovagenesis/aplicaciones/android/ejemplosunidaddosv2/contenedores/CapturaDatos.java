package com.innovagenesis.aplicaciones.android.ejemplosunidaddosv2.contenedores;


public class CapturaDatos {

    public String titleMenuListview;
    public String descrMenuListview;

    /** Realiza la caputa de datos de llenado**/

    public CapturaDatos(String datosMenuListview, String descrMenuListview) {
        this.titleMenuListview = datosMenuListview;
        this.descrMenuListview = descrMenuListview;
    }

    public String getDatosMenuListview() {
        return titleMenuListview;
    }

    public void setDatosMenuListview(String datosMenuListview) {
        this.titleMenuListview = datosMenuListview;
    }

    public String getDescrMenuListview() {
        return descrMenuListview;
    }

    public void setDescrMenuListview(String descrMenuListview) {
        this.descrMenuListview = descrMenuListview;
    }


}
