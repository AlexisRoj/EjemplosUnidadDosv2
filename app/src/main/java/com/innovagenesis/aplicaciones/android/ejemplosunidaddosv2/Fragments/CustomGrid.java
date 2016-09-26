package com.innovagenesis.aplicaciones.android.ejemplosunidaddosv2.Fragments;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.innovagenesis.aplicaciones.android.ejemplosunidaddosv2.R;
import com.innovagenesis.aplicaciones.android.ejemplosunidaddosv2.adapters.CalendarioAdapter;
import com.innovagenesis.aplicaciones.android.ejemplosunidaddosv2.contenedores.Calendario;

import java.util.ArrayList;


public class CustomGrid extends Fragment {

    private GridView gridView;
    private View view;

    public CustomGrid() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_grid, container, false);

        CalendarioAdapter adapter = new CalendarioAdapter(getContext(), listar());

        gridView = (GridView) view.findViewById(R.id.grid);
        gridView.setAdapter(adapter);

        return view;
    }

    private ArrayList<Calendario> listar() {
        String[] meses = getResources().getStringArray(R.array.meses);
        TypedArray imagenes = getResources().obtainTypedArray(R.array.zodiaco);

        ArrayList<Calendario> lista = new ArrayList<>();

        for (int i = 0; i < meses.length; i++) {

            lista.add(new Calendario(imagenes.getResourceId(i, 0), meses[i]));
        }
        return lista;
    }

}
