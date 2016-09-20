package com.innovagenesis.aplicaciones.android.ejemplosunidaddosv2.adapters;


import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.innovagenesis.aplicaciones.android.ejemplosunidaddosv2.R;
import com.innovagenesis.aplicaciones.android.ejemplosunidaddosv2.contenedores.CapturaDatos;

import java.util.List;

public class CustomMenuListview extends ArrayAdapter<CapturaDatos>{


    public CustomMenuListview(Context context, List<CapturaDatos> objects) {
        /** Resive la lista y el contexto de donde se llama **/
        super(context, R.layout.template_list_view, objects);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        /** Instancia el layout y llena el listView la intencion de la creacion de este template
         *  es personalizar el objeto antes de cargarlo en su elemento respectivo
         **/

        LayoutInflater inflater = LayoutInflater.from(getContext());

        View view = inflater.inflate(R.layout.template_list_view,null);

        /**Enlazando TextsViews de captura de datos*/
        TextView menuTitleListview = (TextView)view.findViewById(R.id.titleMenuListview);
        TextView descrMenuListview = (TextView)view.findViewById(R.id.descrMenuListview);

       /**Asignacion de datos y llenado*/
        menuTitleListview.setText(getItem(position).getDatosMenuListview());
        descrMenuListview.setText(getItem(position).getDescrMenuListview());

        return view;
    }
}
