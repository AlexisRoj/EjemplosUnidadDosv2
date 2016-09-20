package com.innovagenesis.aplicaciones.android.ejemplosunidaddosv2.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.innovagenesis.aplicaciones.android.ejemplosunidaddosv2.R;
import com.innovagenesis.aplicaciones.android.ejemplosunidaddosv2.contenedores.DiaHorario;

import java.util.ArrayList;

/**
 * Carga los datos del Spinner
 */
public class SimpleSpinner extends Fragment {

    private Spinner spinner;
    private ArrayList<DiaHorario> listaElementos;
    private TextView opcion;

    public SimpleSpinner() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_simple_spinner, container, false);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource
                (getActivity(), R.array.horario_de_clases, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner = (Spinner)view.findViewById(R.id.simple_spinner);
        spinner.setAdapter(adapter);

        return view;
    }

}
