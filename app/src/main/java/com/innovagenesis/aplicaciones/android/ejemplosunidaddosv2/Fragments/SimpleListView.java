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

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class SimpleListView extends Fragment {

    private ListView horario;
    private TextView opcion;

    public SimpleListView() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_simple_list_view, container, false);



        final String[] titulos = getResources().getStringArray(R.array.horario_de_clases);
        String[] subtitulos = getResources().getStringArray(R.array.dias_semana);

        final TextView textView = (TextView)view.findViewById(R.id.textListview);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, titulos);
       // ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.horario_de_clases, android.R.layout.simple_list_item_1);

        horario = (ListView) view.findViewById(R.id.simple_listView);

        horario.setAdapter(adapter);

        horario.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                textView.setText("Seleciono: " + titulos[position]);

            }
        });



        return view;
    }

}
