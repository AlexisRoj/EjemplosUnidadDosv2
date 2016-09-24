package com.innovagenesis.aplicaciones.android.ejemplosunidaddosv2.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.innovagenesis.aplicaciones.android.ejemplosunidaddosv2.R;
import com.innovagenesis.aplicaciones.android.ejemplosunidaddosv2.contenedores.CapturaDatosGrid;

import java.util.ArrayList;


/**
 * Administra el menu del home
 */

public class CustomMenuGridAdapter extends BaseAdapter {

    private ArrayList<CapturaDatosGrid> elementos;
    private Context context;

    public CustomMenuGridAdapter(Context context, ArrayList<CapturaDatosGrid> elementos) {
        this.context = context;
        this.elementos = elementos;
    }

    @Override
    public int getCount() {
        return elementos.size();
    }

    @Override
    /** Debe ser un metodo del tipo de la captura de datos**/
    public CapturaDatosGrid getItem(int position) {
        return elementos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = convertView;

        if (convertView == null) {

            view = inflater.inflate(R.layout.grid_template_menu, null);
        }
        /**Enlaza el template con sus elementos*/

        TextView textoDescrMenu = (TextView) view.findViewById(R.id.textoDescrMenu);
        ImageView imagenMenu = (ImageView) view.findViewById(R.id.imagenMenu);
        TextView numImageMenu = (TextView) view.findViewById(R.id.textoNumeroMenu);
        TextView textoImageMenu = (TextView) view.findViewById(R.id.textoImagenMenu);

        /**Utiliza el template como recurso de los datos que se van a cargar*/

        textoDescrMenu.setText(getItem(position).getDescMenu());
        imagenMenu.setImageResource(getItem(position).getImagenMenu());
        numImageMenu.setText(getItem(position).getNumMenu());
        textoImageMenu.setText(getItem(position).getTextoMenu());

        return view;
    }
}
