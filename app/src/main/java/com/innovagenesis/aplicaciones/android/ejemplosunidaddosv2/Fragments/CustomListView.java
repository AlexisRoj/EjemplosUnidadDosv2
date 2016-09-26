package com.innovagenesis.aplicaciones.android.ejemplosunidaddosv2.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.innovagenesis.aplicaciones.android.ejemplosunidaddosv2.R;
import com.innovagenesis.aplicaciones.android.ejemplosunidaddosv2.adapters.DiaHorarioAdapter;
import com.innovagenesis.aplicaciones.android.ejemplosunidaddosv2.contenedores.DiaHorario;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class CustomListView extends Fragment {

    private ListView horario;
    private ArrayList<DiaHorario> lista;
    private TextView opcion;


    public CustomListView() {
        // Required empty public constructor
    }

    /** Esta clase es la encargada de Ejemplo del ListView personalizado **/


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_custom_list_view, container, false);


        final String[] titulos = getActivity().getResources().getStringArray(R.array.horario_de_clases);
        String[] subtitulos = getActivity().getResources().getStringArray(R.array.dias_semana);
        final TextView tituloFragment = (TextView)view.findViewById(R.id.titleCustomListview);

        lista = new ArrayList<>();

        for (int i=0; i<titulos.length; i++){
            lista.add(new DiaHorario(titulos[i], subtitulos[i]));
        }

        DiaHorarioAdapter adapter = new DiaHorarioAdapter(getActivity(), lista);

        horario = (ListView) view.findViewById(R.id.custom_listView);
        tituloFragment.setText("Selecione una opcion del menu:");

        horario.setAdapter(adapter);
        horario.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                tituloFragment.setText("El item selecionado es: " + titulos[position]);
            }
        });

        return view;
    }

}
