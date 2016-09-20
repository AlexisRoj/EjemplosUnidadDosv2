package com.innovagenesis.aplicaciones.android.ejemplosunidaddosv2.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import com.innovagenesis.aplicaciones.android.ejemplosunidaddosv2.R;
import com.innovagenesis.aplicaciones.android.ejemplosunidaddosv2.contenedores.DiaHorario;

import java.util.List;

/**
 * utiliza un template para llenar el ListView incialmente se crea una clase para llenar el
 * Spinner y el ListView por aparte pero si los dos tienen los mismos datos se puede usar el
 * mismo
 */
public class DiaHorarioAdapter extends ArrayAdapter<DiaHorario> {
    public DiaHorarioAdapter(Context context, List<DiaHorario> objetos) {
        super(context, R.layout.list_template, objetos);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        /**La creacion del objeto View y asignarle el inflate, la intension es traer
         * al contexto todos los elementos del fragment*/

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.list_template, null);

        TextView titulo = (TextView) item.findViewById(R.id.titulo);
        TextView subtitulo = (TextView) item.findViewById(R.id.subtitulo);

        titulo.setText(getItem(position).getAsignatura());
        subtitulo.setText(getItem(position).getDia());

        return item;
    }
}
