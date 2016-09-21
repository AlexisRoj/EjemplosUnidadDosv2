package com.innovagenesis.aplicaciones.android.ejemplosunidaddosv2.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.innovagenesis.aplicaciones.android.ejemplosunidaddosv2.R;
import com.innovagenesis.aplicaciones.android.ejemplosunidaddosv2.contenedores.Calendario;

import java.util.ArrayList;

public class CalendarioAdapter extends BaseAdapter{

    private ArrayList<Calendario> elementos;
    private Context context;

    public CalendarioAdapter(Context context, ArrayList<Calendario> elementos) {
        this.context = context;
        this.elementos = elementos;
    }

    @Override
    public int getCount() {
        return elementos.size();
    }

    @Override
    public Calendario getItem(int position) {
        return elementos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        /** Como no se hereda de la clase View se hace atravez del parent*/

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = convertView;

        if (convertView != null){
            view = inflater.inflate(R.layout.grid_template,null);
        }

        /** Adjunta elementos desde el template */

        TextView tituloImagen = (TextView) view.findViewById(R.id.tituloImagen);
        ImageView imange = (ImageView) view.findViewById(R.id.imagen);

        /** Carga datos */
        tituloImagen.setText(getItem(position).getMes());
        imange.setImageResource(getItem(position).getImagen());

        return view;
    }
}
