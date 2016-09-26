package com.innovagenesis.aplicaciones.android.ejemplosunidaddosv2.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import com.innovagenesis.aplicaciones.android.ejemplosunidaddosv2.R;
import com.innovagenesis.aplicaciones.android.ejemplosunidaddosv2.adapters.DiaHorarioAdapter;
import com.innovagenesis.aplicaciones.android.ejemplosunidaddosv2.contenedores.DiaHorario;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class CustomSpinner extends Fragment {

    private Spinner spinner;
    private ArrayList<DiaHorario> listaElementos;
    private TextView opcion;

    public CustomSpinner() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_custom_spinner, container, false);

        final String[] titulos = getActivity().getResources().getStringArray(R.array.horario_de_clases);
        String[] subTitulos = getActivity().getResources().getStringArray(R.array.dias_semana);

        listaElementos = new ArrayList<>();

        for (int i = 0; i < titulos.length; i++) {
            /** Se llena la lista del spinner*/
            listaElementos.add(new DiaHorario(titulos[i], subTitulos[i]));
        }

        /** Se crea el adaptador*/
        DiaHorarioAdapter adapter = new DiaHorarioAdapter(getContext(), listaElementos);

        spinner = (Spinner) view.findViewById(R.id.custom_spinner);
        spinner.setAdapter(adapter);

        final TextView titleFragment = (TextView)view.findViewById(R.id.titleCustomSpinner);
        titleFragment.setText(R.string.tituloListView);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                titleFragment.setText(titulos[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return view;
    }

}
