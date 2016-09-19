package com.innovagenesis.aplicaciones.android.ejemplosunidaddosv2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class CustomListView extends Fragment {


    public CustomListView() {
        // Required empty public constructor
    }

    /** Esta clase es la encargada de Ejemplo del ListView personalizado **/


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_custom_list_view, container, false);



        return view;
    }

}
