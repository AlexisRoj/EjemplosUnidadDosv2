package com.innovagenesis.aplicaciones.android.ejemplosunidaddosv2.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.innovagenesis.aplicaciones.android.ejemplosunidaddosv2.R;
import com.innovagenesis.aplicaciones.android.ejemplosunidaddosv2.contenedores.Galeria;

import java.util.ArrayList;

/** Clase encargada de comunicarse con el template para el llenado del Gridview
 *  es importante recordar que el ArrayList extrae los datos del contenedor Galeria
 */


public class GaleriaAdapter extends BaseAdapter{

    private Context context;
    private ArrayList<Galeria> imgGaleria;

    public GaleriaAdapter(Context context, ArrayList<Galeria> imgGaleria) {
        this.context = context;
        this.imgGaleria = imgGaleria;
    }

    @Override
    public int getCount() {
        return imgGaleria.size();
    }

    @Override
    public Galeria getItem(int position) {
        return imgGaleria.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = convertView;

        if (view==null){
            view = inflater.inflate(R.layout.template_galeria,null);
        }

        /** Asigna los recursos al template, los extrae del */

        TextView descImgG = (TextView)view.findViewById(R.id.descrImagenG);
        ImageView imgFrameG = (ImageView)view.findViewById(R.id.imgframe);
        ImageView imgGaleria = (ImageView)view.findViewById(R.id.imgGaleria);

        descImgG.setText(getItem(position).getDescImgGaleria());
        imgFrameG.setImageResource(getItem(position).getImgFrameG());
        imgGaleria.setImageResource(getItem(position).getImagenGaleria());

        return view;
    }
}
